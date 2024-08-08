package org.aston.course;
//класс автобус
public class Bus implements Comparable<Bus> {
    private int number; //номер
    private String model; //модель
    private int mileage; //пробег
    //конструктор без параметров
    Bus () {
        this.number = 0;
        this.model = "unknown";
        this.mileage = 0;
    }
    //конструктор с параметрами
    Bus (int num, String mod, int mil) {
        this.number = num; //номер
        this.model = mod;  //модель
        this.mileage = mil; //пробег
    }
    //переопределение метода cравнения, сравнение по номеру)
    public int compareTo (Bus other) { //возвращает отрицательное число, если первый меньше второго
        return Integer.compare(number, other.number); //ноль, если объекты равны //иначе - положительное число
    }
    // далее идут геттеры и сеттеры
    public void setNumber (int num) {
        this.number = num;
    }

    public void setModel (String mod) {
        this.model = mod;
    }

    public void setMileage (int mil) {
        this.mileage = mil;
    }

    public int getNumber () {
        return this.number;
    }

    public String getModel () {
        return this.model;
    }

    public int getMileage () {
        return this.mileage;
    }

}
