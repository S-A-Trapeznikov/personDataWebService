package com.epam.trapeznikau.service;

import com.epam.trapeznikau.model.PersonalDataDto;
import com.epam.trapeznikau.model.PersonalDataSearchCriteriaDto;
import com.epam.trapeznikau.model.ResultsDto;

public interface PersonalDataService {

    ResultsDto<PersonalDataDto> searchPersonalData(PersonalDataSearchCriteriaDto request);

    PersonalDataDto createPersonalData(PersonalDataDto personalDataDto);

    PersonalDataDto getPersonalData(Long primaryKey);

    PersonalDataDto updatePersonalData(PersonalDataDto personalDataDto);

    void deletePersonalData(Long primaryKey);
}
