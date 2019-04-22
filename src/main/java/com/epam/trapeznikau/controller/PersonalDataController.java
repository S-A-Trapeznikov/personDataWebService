package com.epam.trapeznikau.controller;

import com.epam.trapeznikau.jpa.model.PersonalData;
import com.epam.trapeznikau.model.PersonalDataDto;
import com.epam.trapeznikau.model.PersonalDataSearchCriteriaDto;
import com.epam.trapeznikau.model.ResultsDto;
import com.epam.trapeznikau.service.PersonalDataService;
import com.epam.trapeznikau.validation.group.sequence.CreateGroupSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/persons")
public class PersonalDataController {

    @Autowired
    private PersonalDataService personalDataService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = { "", "/" })
    public ResponseEntity<ResultsDto<PersonalDataDto>> searchPersonalData(
            @RequestBody PersonalDataSearchCriteriaDto personalDataDtoSearchCriteria) {
        ResultsDto<PersonalDataDto> resultsDto = personalDataService.searchPersonalData(personalDataDtoSearchCriteria);
        return ResponseEntity.ok(resultsDto);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonalDataDto> createPersonalData(
            @Validated({ CreateGroupSequence.class })
            @RequestBody PersonalDataDto personalData) {
        return ResponseEntity.ok(personalDataService.createPersonalData(personalData));
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/{primaryKey}")
    public ResponseEntity<PersonalDataDto> getPersonalData(@PathVariable Long primaryKey) {
        return ResponseEntity.ok(personalDataService.getPersonalData(primaryKey));
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonalDataDto> updatePersonalData(@RequestBody PersonalDataDto personalData) {
        return ResponseEntity.ok(personalDataService.updatePersonalData(personalData));
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, path = "/{primaryKey}")
    public ResponseEntity deletePersonalData(@PathVariable Long primaryKey) {
        personalDataService.deletePersonalData(primaryKey);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
