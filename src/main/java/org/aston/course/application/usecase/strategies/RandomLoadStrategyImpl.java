package org.aston.course.application.usecase.strategies;

import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.model.application.LoadStrategy;
import org.aston.course.domain.model.business.EntityCreator;

import java.util.List;

public class RandomLoadStrategyImpl implements LoadStrategy {

    @Override
    public <T extends SomeEntity> void load(List<? super T> list, EntityCreator<T> creator, int entityCount) {
        T temp = creator.create("12", "4.25", "1223");
        list.add(temp);
    }
}
