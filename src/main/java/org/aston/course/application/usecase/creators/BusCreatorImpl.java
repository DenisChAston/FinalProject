package org.aston.course.application.usecase.creators;

import org.aston.course.application.datasource.Bus;
import org.aston.course.application.usecase.enums.BusModelNames;
import org.aston.course.domain.business.EntityCreator;

import java.util.Random;

/**
 * Класс, отвечающий за создание объекта.
 * Метод create принимает 3 параметра типа String.
 * Метод random создает объект со случайными значениями полей
 */

public class BusCreatorImpl implements EntityCreator<Bus> {

    //private final Random rnd = new Random();

    private final Bus bus = new Bus.BusBuilder().build();

    //массив, содержащий объекты Enum, описывающие варианты моделей автобусов для случайной генерации объекта
    private static final BusModelNames[] MODELS = BusModelNames.values();

    @Override
    public Bus create(String number, String model, String thirdParam) {
        int tempNumber = Integer.parseInt(number);
        int temMileage = Integer.parseInt(thirdParam);
        return new Bus.BusBuilder().setNumber(tempNumber).setModel(model).setMileage(temMileage).build();
    }

    @Override
    public Bus random() {
        return create(String.valueOf(rnd.nextInt(100)), String.valueOf(MODELS[rnd.nextInt(MODELS.length)]), String.valueOf(rnd.nextInt(10000)));
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
