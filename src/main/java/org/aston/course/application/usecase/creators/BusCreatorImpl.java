package org.aston.course.application.usecase.creators;

import org.aston.course.application.datasource.Bus;
import org.aston.course.application.usecase.enums.BusModelNames;
import org.aston.course.domain.business.EntityCreator;

/**
 * Класс, отвечающий за создание объекта.
 * Метод create принимает 3 параметра типа String.
 * Метод random создает объект со случайными значениями полей
 */

public class BusCreatorImpl implements EntityCreator<Bus> {

    private final Bus bus = new Bus.BusBuilder().build();

    //массив, содержащий объекты Enum, описывающие варианты моделей автобусов для случайной генерации объекта
    private static final BusModelNames[] MODELS = BusModelNames.values();

    @Override
    public Bus create(String number, String model, String thirdParam) {
        int tempNumber = Integer.parseInt(number);
        int temMileage = Integer.parseInt(thirdParam);
        return new Bus.BusBuilder().setNumber(tempNumber).setModel(model).setMileage(temMileage).build();
    }

    /**
     * Метод создает объект типа Bus со случайными значениями полей
     * Номер автобуса в диапазоне от 1 до 999
     * Модель автобуса из списка моделей типа Enum
     * Пробег автобуса в диапазоне от 0 до 999999
     * @return - объект типа Bus
     */
    @Override
    public Bus random() {
        return create(String.valueOf(rnd.nextInt(1,1000)), String.valueOf(MODELS[rnd.nextInt(MODELS.length)]), String.valueOf(rnd.nextInt(1000000)));
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
