package lombok.constructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.CONSTRUCTOR)
public @interface DummyParameterAnnotation {
    String value() default "";
}
