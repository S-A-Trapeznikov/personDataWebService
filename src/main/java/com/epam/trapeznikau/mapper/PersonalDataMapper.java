package com.epam.trapeznikau.mapper;

import com.epam.trapeznikau.jpa.model.PersonalData;
import com.epam.trapeznikau.model.PersonalDataDto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PersonalDataMapper {

    @Mapping(source = "id", target = "primaryKey")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "birthDate", target = "birthDate")
    PersonalDataDto mapToDto(PersonalData personalData);

    @Mapping(source = "primaryKey", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "birthDate", target = "birthDate")
    PersonalData mapToJpa(PersonalDataDto personalDataDto);

    @InheritConfiguration(name = "mapToJpa")
    void updateJpa(PersonalDataDto personalDataDto, @MappingTarget PersonalData personalData);
}
