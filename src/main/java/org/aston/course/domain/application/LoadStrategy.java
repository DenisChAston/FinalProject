package org.aston.course.domain.application;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.model.SomeEntity;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Общий интерфейс для всех стратегий. Реализация паттерна
 */

public interface LoadStrategy {

   /**
    * Абстрактный метод для заполнения списка объектами
    * @param list - астомный список объектов
    * @param creator - объект для создания конкретного объекта
    * @param <T> - тип объекта
    * @throws IOException
    */

   <T extends Comparable<T> & SomeEntity> void load(CustomList<T> list, EntityCreator<T> creator, BufferedReader reader) throws IOException;
}
