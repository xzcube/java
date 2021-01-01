package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * @author ：xzcube
 * @date ：Created in 2020/12/14 14:48
 */

@Target({TYPE, METHOD})
@Retention(CLASS)
public @interface MyAnnocations {
    MyAnnocation[] value();
}
