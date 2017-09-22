package pojo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 我的思路
 * zeyu
 * 2017/9/20
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface My {
}
