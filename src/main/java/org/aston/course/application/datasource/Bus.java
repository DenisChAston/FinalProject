package org.aston.course.application.datasource;

import org.aston.course.domain.model.SomeEntity;

import java.util.Objects;

public class Bus implements SomeEntity, Comparable<Bus> {

    private final int number;
    private final String model;
    private final int mileage;

    private Bus(int number, String model, int mileage) {
        this.number = number;
        this.model = model;
        this.mileage = mileage;
    }

    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return String.format("Номер:%d, Модель:%s, Пробег:%d", number, model, mileage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bus bus = (Bus) o;
        return number == bus.number && mileage == bus.mileage && model.equals(bus.model);
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + model.hashCode();
        result = 31 * result + mileage;
        return result;
    }

    /**
     * Сортировка по умолчанию для объектов типа Bus.
     * Сначала сравнивается по полю Number - номер маршрута автобуса
     * Затем сравнивается по полю Model - модель автобуса
     * В конце сравнивается по полю Mileage - пробег автобуса
     * @param otherBus the object to be compared.
     * @return -1, если номер маршрута меньше, или название модели по алфавиту раньше, или пробег меньше,
     * 0, если объекты полностью идентичны
     * 1, если номер маршрута больше, или название модели по алфовиту позже, или пробег больше
     */
    @Override
    public int compareTo(Bus otherBus) {
        int numberComparing = Integer.compare(this.number, otherBus.getNumber());
        int andModelComparing = numberComparing == 0 ? this.model.toLowerCase().compareTo(otherBus.getModel().toLowerCase()) : numberComparing;
        return andModelComparing == 0 ? Integer.compare(this.mileage, otherBus.getMileage()) : andModelComparing;
    }


    /*
    Метод для возврата названия полей
     */
    @Override
    public String getFirstParam() {
        return "номер автобуса";
    }

    @Override
    public String getSecondParam() {
        return "модель автобуса";
    }

    @Override
    public String getThirdParam() {
        return "пробег автобуса";
    }

    public static class BusBuilder {

        private int number;
        private String model;
        private int mileage;

        public BusBuilder setNumber(int number) {
            this.number = number;
            return this;
        }

        public BusBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public BusBuilder setMileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        public Bus build() {
            return new Bus(number, model, mileage);
        }
    }
}
