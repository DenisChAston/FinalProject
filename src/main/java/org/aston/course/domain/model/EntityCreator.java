package org.aston.course.domain.model;

public interface EntityCreator {

    <T> T create(String firstParam, String secondParam, String thirdParam);

    String getFirstParamName();
    String getSecondParamName();
    String getThirdParamName();

}
