package com.essamine.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.essamine.entities.Single;

public class FriendValidator implements ConstraintValidator<Friend, Single> {

	@Override
	public void initialize(Friend friend) {

	}

	@Override
	public boolean isValid(Single single, ConstraintValidatorContext context) {
		Single singleF = single.getSingleFriend();
		if (single == null)
			return true;
		
		if (singleF != null)
			if (singleF.getId() == single.getId())
				return false;

//		if (single == null)
//			return singleF == null;
//		else if (single.getId() == singleF.getId())
//			return false;

		return true;
		// return (single == null || singleF == null || single.getId() ==
		// singleF.getId());
	}

}
