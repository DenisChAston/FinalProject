package org.aston.course.application.usecase.strategies;

import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.EntityCreator;

import java.util.List;

public class ConsoleLoadStrategyImpl implements LoadStrategy {

    @Override
    public <T extends SomeEntity> void load(List<? super T> list, EntityCreator<T> creator, int entityCount) {
        T temp = creator.create("53", "MAZ", "1000");
        list.add(temp);
    }
}
