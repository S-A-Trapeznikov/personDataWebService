package com.epam.trapeznikau.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PersonalDataSearchCriteriaDto {

    private String name;
    private String surname;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endBirthDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startBirthDate;

    public Date getEndBirthDate() {
        return endBirthDate;
    }

    public void setEndBirthDate(Date endBirthDate) {
        this.endBirthDate = endBirthDate;
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

    public Date getStartBirthDate() {
        return startBirthDate;
    }

    public void setStartBirthDate(Date startBirthDate) {
        this.startBirthDate = startBirthDate;
    }
}
