package org.aston.course.domain.model;

public interface EntityCreator {

    <T> T create(String firstParam, String secondParam, String thirdParam);

    <T> T random();

    String getFirstParamName();
    String getSecondParamName();
    String getThirdParamName();
}
