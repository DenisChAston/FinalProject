package org.aston.course.application.usecase.randoms;

import org.aston.course.application.datasource.Bus;
import org.aston.course.application.datasource.Student;
import org.aston.course.application.usecase.Enum.BusName;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.application.GeneratorStrategy;

import java.util.concurrent.ThreadLocalRandom;


public class BusRandomImpl implements GeneratorStrategy<Bus> {
    @Override
    public Bus generator(EntityCreator<Bus> creator) {
        Bus temp = creator.create(busNumberGen(), busNameGen(), busNumberMil());
        return temp;
    }

    private String busNumberGen() {

        int randomNum = ThreadLocalRandom.current().nextInt(1, 150 + 1);
        return String.valueOf(randomNum);
    }

    private String busNameGen() {
        BusName[] name = BusName.values();
        int randomName = ThreadLocalRandom.current().nextInt(0, BusName.values().length);
        return String.valueOf(name[randomName]);
    }

    private String busNumberMil() {

        int randomNum = ThreadLocalRandom.current().nextInt(1000, 99999);
        return String.valueOf(randomNum);
    }
}

