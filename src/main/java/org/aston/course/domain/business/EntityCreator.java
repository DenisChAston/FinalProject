package org.aston.course.domain.business;

import org.aston.course.domain.model.SomeEntity;

public interface EntityCreator {

    <T> T create(String firstParam, String secondParam, String thirdPara);
}
