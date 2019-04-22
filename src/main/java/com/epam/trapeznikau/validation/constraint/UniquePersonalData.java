package com.epam.trapeznikau.validation.constraint;

import com.epam.trapeznikau.validation.common.PersonalDataValidation;
import com.epam.trapeznikau.validation.validator.UniquePersonalDataValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniquePersonalDataValidation.class)
public @interface UniquePersonalData {

    String message() default "{com.epam.trapeznikau.validation.constraint}";

    Class<?>[] groups() default {};

    Class<? extends Payload> [] payload() default {};
}
