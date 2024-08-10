package org.aston.course.application.usecase.creators;

import org.aston.course.application.datasource.Bus;
import org.aston.course.domain.model.EntityCreator;

public class BusCreatorImpl implements EntityCreator {

    @Override
    public Bus create(String number, String model, String thirdParam) {
        int tempNumber = Integer.parseInt(number);
        //Model tempModel = Model.valueOf(model);
        int temMileage = Integer.parseInt(thirdParam);
        return new Bus.BusBuilder().setNumber(tempNumber).setModel(model).setMileage(temMileage).build();
    }

    @Override
    public String getFirstParamName() {
        return "номер автобуса";
    }

    @Override
    public String getSecondParamName() {
        return "модель автобуса";
    }

    @Override
    public String getThirdParamName() {
        return "пробег автобуса";
    }
}
