package org.aston.course.domain.business;

import org.aston.course.domain.model.SomeEntity;

import java.util.Random;

/**
 * Интерфейс создания объекта
 * @param <T> - тип объекта
 */
public interface EntityCreator<T extends SomeEntity> {

    Random rnd = new Random();

    T create(String firstParam, String secondParam, String thirdParam);

    T random();

    String getFirstParamName();
    String getSecondParamName();
    String getThirdParamName();
}
