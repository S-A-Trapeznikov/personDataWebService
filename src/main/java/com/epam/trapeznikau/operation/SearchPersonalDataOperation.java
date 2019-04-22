package com.epam.trapeznikau.operation;

import com.epam.trapeznikau.jpa.model.PersonalData;
import com.epam.trapeznikau.jpa.model.PersonalDataSearchCriteria;
import com.epam.trapeznikau.jpa.specification.PersonalDataSearchCriteriaSpecification;
import com.epam.trapeznikau.mapper.PersonalDataMapper;
import com.epam.trapeznikau.mapper.PersonalDataSearchCriteriaMapper;
import com.epam.trapeznikau.model.PersonalDataDto;
import com.epam.trapeznikau.model.PersonalDataSearchCriteriaDto;
import com.epam.trapeznikau.model.ResultsDto;
import com.epam.trapeznikau.repository.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SearchPersonalDataOperation {

    @Autowired
    private PersonalDataRepository repository;
    @Autowired
    private PersonalDataSearchCriteriaMapper mapper;
    @Autowired
    private PersonalDataMapper personalDataMapper;

    public ResultsDto<PersonalDataDto> perform(PersonalDataSearchCriteriaDto personalDataSearchCriteriaDto) {
        PersonalDataSearchCriteria criteria = mapper.mapDtoToJpa(personalDataSearchCriteriaDto);
        PageRequest pageRequest = PageRequest.of(0,100);
        Page<PersonalData> pageResults = repository.findAll(
                PersonalDataSearchCriteriaSpecification.bySearchCriteria(criteria), pageRequest);

        ResultsDto<PersonalDataDto> resultsDto = new ResultsDto<>();
        resultsDto.setListResults(pageResults.stream().map(personalDataMapper::mapToDto).collect(Collectors.toList()));
        return resultsDto;
    }


}
