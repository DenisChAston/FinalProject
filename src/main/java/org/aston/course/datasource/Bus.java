package org.aston.course.datasource;

//класс автобус
public class Bus implements SomeEntity, Comparable<Bus> {
    private final String number; //номер
    private final String model; //модель
    private final int mileage; //пробег

    //конструктор с параметрами
    private Bus (BusBuilder builder) {
        this.number = builder.number; //номер
        this.model = builder.model;  //модель
        this.mileage = builder.mileage; //пробег
    }
    //геттеры
    public String getNumber () {
        return this.number;
    }

    public String getModel () {
        return this.model;
    }

    public int getMileage () {
        return this.mileage;
    }

    //переопределение метода cравнения, сравнениваем по номеру)
    @Override //возвращает отрицательное число, если первый меньше второго
    public int compareTo(Bus other) { //ноль, если объекты равны, иначе - положительное число
        return this.getNumber().toLowerCase().compareTo(other.getNumber().toLowerCase()); //сравнение по номеру
    } //перед сравнением приводим номера к нижнему регистру

    //возвращает поля объекта в виде форматированной строки
    public static String toString(Bus B) {
        return "Номер: " + B.getNumber() +
                ", Модель: " + B.getModel() +
                ", Пробег: " + B.getMileage();
    }

    //реализация паттерна Builder
    public static class BusBuilder {
        private String number; //номер
        private String model; //модель
        private int mileage; //пробег

        public BusBuilder withNumber(String number) {
            this.number = number;
            return this;
        }

        public BusBuilder withModel(String model) {
            this.model = model;
            return this;
        }

        public BusBuilder withMileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        public Bus build() {
            return new Bus(this);
        }
    }
//удалить
    public static void printClass(Bus B) {
        System.out.println(toString(B));
    }

    public static void comparePair(Bus B1, Bus B2) {
        int comp = B1.compareTo(B2);
        if (comp == 0) {
            System.out.println(B1.number + " и " + B2.number + " равны.");
        }
        else if (comp < 0) {
            System.out.println(B1.number + " меньше " + B2.number);
        }
        else  System.out.println(B1.number + " больше " + B2.number);
    }

    public static void main(String[] args) {
        Bus myBus1 = new Bus.BusBuilder()
                .withNumber("a007aa007")
                .withModel("Ikarus")
                .withMileage(32000)
                .build();
        Bus myBus2 = new Bus.BusBuilder()
                .withNumber("x001xx001")
                .withModel("Luidor")
                .withMileage(50000)
                .build();
        printClass(myBus1);
        printClass(myBus2);
        comparePair(myBus1, myBus2);
        comparePair(myBus2, myBus1);
        comparePair(myBus1, myBus1);
        comparePair(myBus2, myBus2);
    }
//
}
