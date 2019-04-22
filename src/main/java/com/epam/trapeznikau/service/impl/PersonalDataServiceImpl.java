package com.epam.trapeznikau.service.impl;

import com.epam.trapeznikau.model.PersonalDataDto;
import com.epam.trapeznikau.model.PersonalDataSearchCriteriaDto;
import com.epam.trapeznikau.model.ResultsDto;
import com.epam.trapeznikau.operation.*;
import com.epam.trapeznikau.service.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalDataServiceImpl implements PersonalDataService {

    @Autowired
    private CreatePersonalDataOperation createPersonalDataOperation;
    @Autowired
    private GetPersonalDataOperation getPersonalDataOperation;
    @Autowired
    private UpdatePersonalDataOperation updatePersonalDataOperation;
    @Autowired
    private DeletePersonalDataOperation deletePersonalDataOperation;
    @Autowired
    private SearchPersonalDataOperation searchPersonalDataOperation;

    @Override
    public ResultsDto<PersonalDataDto> searchPersonalData(PersonalDataSearchCriteriaDto request) {
        return searchPersonalDataOperation.perform(request);
    }

    @Override
    public PersonalDataDto createPersonalData(PersonalDataDto personalDataDto) {
        return createPersonalDataOperation.perform(personalDataDto);
    }

    @Override
    public PersonalDataDto getPersonalData(Long primaryKey) {
        return getPersonalDataOperation.perform(primaryKey);
    }

    @Override
    public PersonalDataDto updatePersonalData(PersonalDataDto personalDataDto) {
        return updatePersonalDataOperation.perform(personalDataDto);
    }

    @Override
    public void deletePersonalData(Long primaryKey) {
        deletePersonalDataOperation.perform(primaryKey);
    }
}
