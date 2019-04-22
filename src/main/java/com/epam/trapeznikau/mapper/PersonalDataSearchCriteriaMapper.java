package com.epam.trapeznikau.mapper;

import com.epam.trapeznikau.jpa.model.PersonalDataSearchCriteria;
import com.epam.trapeznikau.model.PersonalDataSearchCriteriaDto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonalDataSearchCriteriaMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "endBirthDate", target = "endBirthDate")
    @Mapping(source = "startBirthDate", target = "startBirthDate")
    PersonalDataSearchCriteria mapDtoToJpa(PersonalDataSearchCriteriaDto personalDataSearchCriteriaDto);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "endBirthDate", target = "endBirthDate")
    @Mapping(source = "startBirthDate", target = "startBirthDate")
    PersonalDataSearchCriteriaDto mapJpaToDto(PersonalDataSearchCriteria personalDataSearchCriteria);
}
