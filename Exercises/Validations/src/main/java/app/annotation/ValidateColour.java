package app.annotation;

import app.validator.ColourValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ColourValidator.class)
@Documented
public @interface ValidateColour {

    String message() default "Invalid colour {value}!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String value();

//    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
//    @Retention(RUNTIME)
//    @Documented
//    @interface List {
//        String[] value();
//    }
}
