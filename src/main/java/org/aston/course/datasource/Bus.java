package org.aston.course.datasource;
//класс автобус
public class Bus implements Comparable<Bus> {
    private String number; //номер
    private String model; //модель
    private int mileage; //пробег

    //конструктор без параметров
    Bus () {
        this.number = "x000xx000";
        this.model = "unknown";
        this.mileage = 0;
    }
    //конструктор с параметрами
    Bus (String num, String mod, int mil) {
        this.number = num; //номер
        this.model = mod;  //модель
        this.mileage = mil; //пробег
    }

    // далее идут геттеры и сеттеры
    public void setNumber (String num) {
        this.number = num;
    }

    public void setModel (String mod) {
        this.model = mod;
    }

    public void setMileage (int mil) {
        this.mileage = mil;
    }

    public String getNumber () {
        return this.number;
    }

    public String getModel () {
        return this.model;
    }

    public int getMileage () {
        return this.mileage;
    }
    //конец геттеров и сеттеров

    //переопределение метода cравнения, сравнение по номеру)
    @Override //возвращает отрицательное число, если первый меньше второго
    public int compareTo(Bus other) { //ноль, если объекты равны, иначе - положительное число
        return this.number.toLowerCase().compareTo(other.number.toLowerCase()); //сравнение по номеру
    } //перед сравнением приводим номера к нижнему регистру

    //реализация паттерна Builder
    public static class Builder {
        private Bus newBus;

        public Builder() {
            newBus = new Bus();
        }

        public Builder withNumber(String num) {
            newBus.number = num;
            return this;
        }

        public Builder withModel(String mod) {
            newBus.model = mod;
            return this;
        }

        public Builder withMileage(int mil) {
            newBus.mileage = mil;
            return this;
        }

        public Bus build() {
            return newBus;
        }
    }

//проверка класса

    public static void printClass(Bus B) {
        System.out.print("Номер: " + B.number);
        System.out.print(" Модель: " + B.model);
        System.out.println(" Пробег: " + B.mileage);
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
        Bus myBus1 = new Bus.Builder()
                .withNumber("a007aa007")
                .withModel("Ikarus")
                .withMileage(32000)
                .build();
        Bus myBus2 = new Bus.Builder()
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
}
