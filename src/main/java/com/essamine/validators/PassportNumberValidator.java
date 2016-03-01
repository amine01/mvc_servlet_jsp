package com.essamine.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PassportNumberValidator implements ConstraintValidator<PassportNumber, String> {

	@Override
	public void initialize(PassportNumber constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String passportNumber, ConstraintValidatorContext context) {

		if (passportNumber.length() != 6)
			return false;
		int i = 0;
		for (char c : passportNumber.toCharArray()) {
			if (Character.isDigit(c))
				i++;
		}

		if (i == 4)
			return true;

		return false;
	}

}
