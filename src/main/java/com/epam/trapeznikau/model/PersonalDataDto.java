package com.epam.trapeznikau.model;


import com.epam.trapeznikau.validation.constraint.UniquePersonalData;
import com.epam.trapeznikau.validation.group.CreateFirstGroup;

import java.util.Date;

@UniquePersonalData(groups = { CreateFirstGroup.class})
public class PersonalDataDto {

    private Long primaryKey;
    private String name;
    private String surname;
    private Integer age;
    private Date birthDate;

    public Long getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Long primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
