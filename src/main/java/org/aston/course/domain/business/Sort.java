package org.aston.course.domain.business;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.model.SomeEntity;

import java.util.Comparator;

public interface Sort<T extends Comparable<T> & SomeEntity> {

    void sort(CustomList<T> list);

    void sort(CustomList<T> list, Comparator<T> comparator);
}
