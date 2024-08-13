package org.aston.course.application.usecase.strategies;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.model.SomeEntity;

import java.io.BufferedReader;

/**
 * Стратегия заполнения списка случайными объектами
 */
public class RandomLoadStrategyImpl implements LoadStrategy {

    /**
     * Метод заполнения списка случайными объектами
     * @param list - объект кастомного класса листа
     * @param creator - объект для создания конкретного объекта
     * @param reader - поток для работы через консоль. Не используется в методе
     * @param <T> - тип объекта
     */
    @Override
    public <T extends Comparable<T> & SomeEntity> void load(CustomList<T> list, EntityCreator<T> creator, BufferedReader reader) {
        for (int i = 0; i < list.getCapacity(); i++) {
            T t = creator.random();
            list.add(t);
        }
    }
}
