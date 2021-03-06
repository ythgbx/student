package net.bus.web.aspect;

import net.bus.web.context.SessionContext;
import net.bus.web.controller.dto.BaseResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Edifi_000 on 2016-07-01.
 */

@Component
@Aspect
public class WebAuth {

    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;

    private static Logger logger = LoggerFactory.getLogger(WebAuth.class);

    @Around("execution(org.springframework.web.servlet.ModelAndView net.bus.web.controller..*.*(..)) && @annotation(auth)")
    public Object checkWebAuth(ProceedingJoinPoint point, Auth auth) throws Throwable {

        if (auth.role() != Auth.Role.NONE) {
            if (session.getAttribute(SessionContext.CURRENT_USER) == null) {
                return new ModelAndView("redirect:/user/login");
            } else {
                Auth.Role role = (Auth.Role) session.getAttribute(SessionContext.CURRENT_USER_ROLE);
                if (role.ordinal() >= auth.role().ordinal()) {
                    return point.proceed();
                } else {
                    return new ModelAndView("redirect:/user/login");
                }
            }
        } else {
            return point.proceed();
        }
    }

    @Around("(execution(java.util.List net.bus.web.controller..*.*(..)) " +
            "||execution(net.bus.web.controller.dto.* net.bus.web.controller..*.*(..)))"+
            "&& @annotation(auth)")
    public Object checkWebResultAuth(ProceedingJoinPoint point, Auth auth) throws Throwable {

        BaseResult result = new BaseResult();

        if (auth.role() != Auth.Role.NONE) {
            if (session.getAttribute(SessionContext.CURRENT_USER) == null) {
                result.setResult("error");
                result.setError("user not login!");
                return result;
            } else {
                Auth.Role role = (Auth.Role) session.getAttribute(SessionContext.CURRENT_USER_ROLE);
                if (role.ordinal() >= auth.role().ordinal()) {
                    return point.proceed();
                } else {
                    result.setResult("error");
                    result.setError("user role low!");
                    return result;
                }
            }
        } else {
            return point.proceed();
        }
    }
}
