package org.aston.course.application.datasource;

import org.aston.course.domain.model.SomeEntity;

import java.util.Objects;

public class Bus implements SomeEntity {

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
