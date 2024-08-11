package org.aston.course.domain.model;

public interface EntityCreator {

    //может и не нужно ограничинвать
    <T> T create(String firstParam, String secondParam, String thirdParam);

    <T> T random();

    String getFirstParamName();
    String getSecondParamName();
    String getThirdParamName();

}
