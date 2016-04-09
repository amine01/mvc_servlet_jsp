package com.essamine.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Documented
@Constraint(validatedBy = PassportNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PassportNumber {
	String message() default "Passport Number must be 6 with 4 numeric characters";

	Class<?>[] groups() default {};

	Class<?>[] payload() default {};

}