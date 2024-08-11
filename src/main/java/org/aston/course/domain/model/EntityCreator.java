package org.aston.course.domain.model;

public interface EntityCreator<T extends SomeEntity> {

    T create(String firstParam, String secondParam, String thirdParam);

    T random();

    String getFirstParamName();
    String getSecondParamName();
    String getThirdParamName();
}
