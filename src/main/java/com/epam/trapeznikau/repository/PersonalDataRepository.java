package com.epam.trapeznikau.repository;

import com.epam.trapeznikau.jpa.model.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalData, Long>, JpaSpecificationExecutor<PersonalData> {
}
