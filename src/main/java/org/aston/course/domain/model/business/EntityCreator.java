package org.aston.course.domain.model.business;

import org.aston.course.domain.model.SomeEntity;

public interface EntityCreator<T extends SomeEntity> {

    T create(String firstParam, String secondParam, String thirdPara);
}
