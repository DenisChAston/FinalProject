package org.aston.course.domain.business;

import org.aston.course.domain.model.SomeEntity;

import java.util.Comparator;

/**
 * Интерфейс компараторов
 * @param <T> - тип объекта
 */
public interface SomeComparator<T extends SomeEntity> extends Comparator<T> {

}
