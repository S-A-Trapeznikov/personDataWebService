package com.epam.trapeznikau.validation.group.sequence;


import com.epam.trapeznikau.validation.group.CreateFirstGroup;
import com.epam.trapeznikau.validation.group.CreateSecondGroup;
import com.epam.trapeznikau.validation.group.CreateThirdGroup;

import javax.validation.GroupSequence;

@GroupSequence({
        CreateFirstGroup.class,
        CreateSecondGroup.class,
        CreateThirdGroup.class
})
public interface CreateGroupSequence
{
}
