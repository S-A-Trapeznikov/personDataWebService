package com.epam.trapeznikau.operation;

import com.epam.trapeznikau.jpa.model.PersonalData;
import com.epam.trapeznikau.mapper.PersonalDataMapper;
import com.epam.trapeznikau.model.PersonalDataDto;
import com.epam.trapeznikau.repository.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class CreatePersonalDataOperation {

    @Autowired
    private PersonalDataRepository personalDataRepository;
    @Autowired
    private PersonalDataMapper mapper;

    @Transactional
    public PersonalDataDto perform(PersonalDataDto personalDto) {
        PersonalData personalDataJpa = mapper.mapToJpa(personalDto);
        PersonalData savedPersonalData = personalDataRepository.save(personalDataJpa);
        return mapper.mapToDto(savedPersonalData);
    }
}
