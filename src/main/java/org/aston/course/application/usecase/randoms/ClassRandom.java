package org.aston.course.application.usecase.randoms;

import org.aston.course.application.datasource.Bus;
import org.aston.course.domain.business.Generator;

public class ClassRandom implements Generator<Bus> {

    @Override
    public Bus generate() {
        return new Bus.BusBuilder().setNumber(12).setModel("asd").setMileage(1000).build();
    }
}
