package org.aston.course.domain.model;

import org.aston.course.application.datasource.CustomList;

public interface Sort<T extends Comparable<T>> {

    void sort(CustomList<T> list);
}
