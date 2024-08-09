package org.aston.course.application.usecase.creators;

import org.aston.course.application.datasource.Bus;
import org.aston.course.application.datasource.Model;
import org.aston.course.domain.model.business.EntityCreator;

public class BusCreatorImpl implements EntityCreator<Bus> {

    @Override
    public Bus create(String number, String model, String mileage) {
        int tempNumber = Integer.parseInt(number);
        //Model tempModel = Model.valueOf(model);
        int temMileage = Integer.parseInt(mileage);
        return new Bus.BusBuilder().setNumber(tempNumber).setModel(model).setMileage(temMileage).build();
    }
}
