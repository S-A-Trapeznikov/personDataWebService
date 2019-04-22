package com.epam.trapeznikau.validation.validator;

import com.epam.trapeznikau.model.PersonalDataDto;
import com.epam.trapeznikau.validation.common.PersonalDataValidation;
import com.epam.trapeznikau.validation.constraint.UniquePersonalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniquePersonalDataValidation implements ConstraintValidator<UniquePersonalData, PersonalDataDto> {

    @Autowired
    private PersonalDataValidation personalDataValidation;

    @Override
    public boolean isValid(PersonalDataDto personalDataDto, ConstraintValidatorContext constraintValidatorContext) {
        return personalDataValidation.hasDuplicates(personalDataDto);
    }
}
