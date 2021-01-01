package annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;


/**
 * @author ：xzcube
 * @date ：Created in 2020/12/14 10:51
 */

@Repeatable(MyAnnocations.class)
@Retention(CLASS)
@Target({TYPE, METHOD})
public @interface MyAnnocation {
    String value();
}
