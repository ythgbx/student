package net.bus.web.aspect;

import java.lang.annotation.*;
/**
 * Created by Edifi_000 on 2016-07-01.
 */

/**
 * 权限注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {
    Role role() default Role.USER;

    public enum Role{ NONE, USER, ADMIN};
}
