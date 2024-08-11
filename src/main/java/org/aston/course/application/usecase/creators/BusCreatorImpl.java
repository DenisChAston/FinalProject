package org.aston.course.application.usecase.creators;

import org.aston.course.application.datasource.Bus;
import org.aston.course.domain.model.EntityCreator;

import java.util.Random;

public class BusCreatorImpl implements EntityCreator<Bus> {

    private final Bus bus = new Bus.BusBuilder().build();

    private final Random rnd = new Random();
    private static final String[] model = {"Kamaz", "Maz", "Liaz"};

    @Override
    public Bus create(String number, String model, String thirdParam) {
        int tempNumber = Integer.parseInt(number);
        int temMileage = Integer.parseInt(thirdParam);
        return new Bus.BusBuilder().setNumber(tempNumber).setModel(model).setMileage(temMileage).build();
    }

    @Override
    public Bus random() {
        return create(String.valueOf(rnd.nextInt(100)), model[rnd.nextInt(model.length)-1], String.valueOf(rnd.nextInt(10001)-1));
    }

    @Override
    public String getFirstParamName() {
        return bus.getFirstParam();
    }

    @Override
    public String getSecondParamName() {
        return bus.getSecondParam();
    }

    @Override
    public String getThirdParamName() {
        return bus.getThirdParam();
    }
}
