package org.aston.course.application.usecase.randoms;
import org.aston.course.application.datasource.Bus;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.business.GeneratorStrategy;
import org.aston.course.domain.model.SomeEntity;


public class BusRandomImpl implements GeneratorStrategy<Bus> {


    @Override
    public Bus generator(EntityCreator<Bus> creator) {
        return null;
    }
}

