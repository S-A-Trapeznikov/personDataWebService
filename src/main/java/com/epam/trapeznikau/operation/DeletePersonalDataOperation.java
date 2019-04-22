package com.epam.trapeznikau.operation;

import com.epam.trapeznikau.repository.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DeletePersonalDataOperation {

    @Autowired
    private PersonalDataRepository personalDataRepository;

    @Transactional
    public void perform(Long primaryKey) {
        personalDataRepository.deleteById(primaryKey);
    }
}
