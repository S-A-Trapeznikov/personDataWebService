package com.epam.trapeznikau.validation.common;

import com.epam.trapeznikau.model.PersonalDataDto;
import com.epam.trapeznikau.model.PersonalDataSearchCriteriaDto;
import com.epam.trapeznikau.service.impl.PersonalDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional(readOnly = true)
public class PersonalDataValidation {

    @Autowired
    private PersonalDataServiceImpl personalDataServiceImpl;

    public boolean hasDuplicates(PersonalDataDto personalDataDto) {
        PersonalDataSearchCriteriaDto personalDataSearchCriteriaDto = new PersonalDataSearchCriteriaDto();
        setPersonalDataSearchCriteriaDto(personalDataDto, personalDataSearchCriteriaDto);
        List<PersonalDataDto> listResults =
                personalDataServiceImpl.searchPersonalData(personalDataSearchCriteriaDto).getListResults();
        return isPersonalDataDuplicates(personalDataDto, listResults);

    }

    private void setPersonalDataSearchCriteriaDto(PersonalDataDto personalDataDto, PersonalDataSearchCriteriaDto personalDataSearchCriteriaDto) {
        personalDataSearchCriteriaDto.setName(personalDataDto.getName());
        personalDataSearchCriteriaDto.setAge(personalDataDto.getAge());
        personalDataSearchCriteriaDto.setSurname(personalDataDto.getSurname());
        personalDataSearchCriteriaDto.setStartBirthDate(personalDataDto.getBirthDate());
    }

    private boolean isPersonalDataDuplicates(PersonalDataDto personalDataDto, List<PersonalDataDto> listResults) {
        if (isListNotEmpty(listResults)) {
            for (PersonalDataDto personalData : listResults) {
                if (isDuplicate(personalDataDto, personalData)) return true;
            }
        }
        return false;
    }

    private boolean isListNotEmpty(List listResults) {
        return !listResults.isEmpty();
    }

    private boolean isDuplicate(PersonalDataDto personalDataDto, PersonalDataDto personalData) {
        if (personalData.equals(personalDataDto)) {
            return true;
        }
        return false;
    }
}
