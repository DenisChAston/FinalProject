package org.aston.course.application.usecase.strategies;

import org.aston.course.application.datasource.Bus;
import org.aston.course.application.usecase.creators.BusCreatorImpl;
import org.aston.course.application.usecase.creators.StudentCreatorImpl;
import org.aston.course.application.usecase.creators.UserCreatorImpl;
import org.aston.course.application.usecase.randoms.BusRandomImpl;
import org.aston.course.application.usecase.randoms.StudentRandomImpl;
import org.aston.course.application.usecase.randoms.UserRandomImpl;
import org.aston.course.domain.business.GeneratorStrategy;
import org.aston.course.domain.model.SomeEntity;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.EntityCreator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RandomLoadStrategyImpl implements LoadStrategy {

    @Override
    public <T extends SomeEntity> void load(List<? super T> list, EntityCreator<T> creator) {
        Map<String, GeneratorStrategy> createStrategyMap;
        createStrategyMap = new HashMap<>();
        createStrategyMap.put("1", new BusRandomImpl());
        createStrategyMap.put("2", new StudentRandomImpl());
        createStrategyMap.put("3", new UserRandomImpl());
    }
}


