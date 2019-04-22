package com.epam.trapeznikau.jpa.model;

import java.util.Date;

public class PersonalDataSearchCriteria {

        private String name;
        private String surname;
        private Integer age;
        private Date endBirthDate;
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
