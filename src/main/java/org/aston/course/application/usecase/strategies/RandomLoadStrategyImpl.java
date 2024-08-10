package org.aston.course.application.usecase.strategies;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.model.EntityCreator;

public class RandomLoadStrategyImpl implements LoadStrategy {

    @Override
    public <T extends Comparable<T>> void load(CustomList<T> list, EntityCreator creator) {

    }
}
