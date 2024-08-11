package org.aston.course.presentation.context;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.model.SomeEntity;

import java.io.BufferedReader;

public class BinarySearchContext {

    public <T extends SomeEntity & Comparable<T>> T start(CustomList<T> list, EntityCreator<T> creator, BufferedReader reader) {



        return list.get(0);
    }
}
