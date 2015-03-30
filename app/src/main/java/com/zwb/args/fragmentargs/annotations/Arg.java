package com.zwb.args.fragmentargs.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Fragment的参数注解
 * Created by wenbiao_zheng on 2015/1/26.
 *
 * @author wenbiao_zheng
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Arg {
    String value() default "";
}
