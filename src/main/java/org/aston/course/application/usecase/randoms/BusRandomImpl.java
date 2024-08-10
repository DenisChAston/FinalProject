package org.aston.course.application.usecase.randoms;
import org.aston.course.application.datasource.Bus;
import org.aston.course.application.datasource.Student;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.application.GeneratorStrategy;


public class BusRandomImpl implements GeneratorStrategy<Bus> {


    @Override
    public Bus generator(EntityCreator<Bus> creator) {
        Bus temp = creator.create("12","MAZ","123");
        return temp;
    }
}

