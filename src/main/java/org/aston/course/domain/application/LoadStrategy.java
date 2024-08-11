package org.aston.course.domain.application;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.model.EntityCreator;
import org.aston.course.domain.model.SomeEntity;

import java.io.IOException;

public interface LoadStrategy {

   <T extends Comparable<T> & SomeEntity> void load(CustomList<T> list, EntityCreator<T> creator) throws IOException;
}
