package org.aston.course.domain.application;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.business.EntityCreator;

import java.util.List;

public interface LoadStrategy {

   <T extends Comparable<T>> void load(CustomList<T> list, EntityCreator creator, int entityCount);
}
