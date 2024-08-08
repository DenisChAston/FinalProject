package org.aston.course.application.datasource;

import org.aston.course.domain.model.SomeEntity;

public class Bus implements SomeEntity {

    private final String number;
    private final Model model;
    private final int mileage;

    private Bus(String number, Model model, int mileage) {
        this.number = number;
        this.model = model;
        this.mileage = mileage;
    }

    public String getNumber() {
        return number;
    }

    public Model getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return String.format("Номер:%s, Модель:%s, Пробег:%d", number, model, mileage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bus bus = (Bus) o;
        return mileage == bus.mileage && number.equals(bus.number) && model == bus.model;
    }

    @Override
    public int hashCode() {
        int result = number.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + mileage;
        return result;
    }

    public static class BusBuilder {

        private String number;
        private Model model;
        private int mileage;

        public BusBuilder setNumber(String number) {
            this.number = number;
            return this;
        }

        public BusBuilder setModel(Model model) {
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
