package com.epam.trapeznikau.jpa.specification;

import com.epam.trapeznikau.jpa.model.PersonalData;
import com.epam.trapeznikau.jpa.model.PersonalDataSearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class PersonalDataSearchCriteriaSpecification {

    public static Specification<PersonalData> bySearchCriteria(PersonalDataSearchCriteria criteria) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            addPredicateIfCriteriaPropertyNotNull(predicates, criteria.getName(),
                    builder.equal(root.get("name"), criteria.getName()));
            addPredicateIfCriteriaPropertyNotNull(predicates, criteria.getAge(),
                    builder.equal(root.get("age"), criteria.getAge()));
            addPredicateIfCriteriaPropertyNotNull(predicates, criteria.getSurname(),
                    builder.equal(root.get("surname"), criteria.getSurname()));
            addPredicateIfCriteriaPropertyNotNull(predicates, criteria.getStartBirthDate(),
                    builder.greaterThanOrEqualTo(root.get("birthDate"), criteria.getStartBirthDate()));
            addPredicateIfCriteriaPropertyNotNull(predicates, criteria.getEndBirthDate(),
                    builder.lessThanOrEqualTo(root.get("birthDate"), criteria.getEndBirthDate()));

            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    private static void addPredicateIfCriteriaPropertyNotNull(List<Predicate> predicates, Object propertyCriteria,
                                                              Predicate predicate) {
        if (propertyCriteria != null) {
            predicates.add(predicate);
        }
    }
}
