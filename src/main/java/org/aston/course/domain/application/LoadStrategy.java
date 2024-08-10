package org.aston.course.domain.application;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.model.EntityCreator;

public interface LoadStrategy {

   <T extends Comparable<T>> void load(CustomList<T> list, EntityCreator creator);
}
