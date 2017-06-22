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
    Role role() default Role.NONE;

    public enum Role{
        NONE(-1), STUDENT(0),COUNSELOR(1), ADMIN(2);
        private int index;

        private Role(int index){
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public static Role getRole(int index){
            for (Role role : Role.values()){
                if (role.getIndex() == index){
                    return role;
                }
            }
            return NONE;
        }
    }
}
