package org.aston.course.datasource;

//класс Студент
public class Student implements Comparable<Student>{
    private int gradeBookNum; //номер зачетной книжки
    private int groupNumber; //номер группы
    private double averageScore; //средний бал


    //конструктор без параметров
    Student () {
        this.gradeBookNum = 0;
        this.averageScore = 0;
        this.groupNumber = 0;
    }
    //конструктор с параметрами
    Student (int gBookNum, int groupNum, double avScore) {
        this.gradeBookNum = gBookNum; //номер зачетной книжки
        this.groupNumber = groupNum;  //номер группы
        this.averageScore = avScore; //средний бал
    }

    //геттеры
    public int getGradeBookNum () {
        return this.gradeBookNum;
    }

    public int getGroupNumber () {
        return this.groupNumber;
    }

    public double getAverageScore () {
        return this.averageScore;
    }

    //переопределение метода cравнения, сравнениваем по номеру)
    @Override //возвращает отрицательное число, если первый меньше второго
    public int compareTo(Student other) { //ноль, если объекты равны, иначе - положительное число
        return this.gradeBookNum - other.gradeBookNum; //сравнение по номеру зачетной книжки, как уникального значения
    } //метод compareTo из класса Integer не применен, поскольку не работает с примитивами

    //реализация паттерна Builder
    public static class Builder {
        private final Student newStudent;

        public Builder() {
            newStudent = new Student();
        }

        public Student.Builder withGradeBookNum(int gBookNum) {
            newStudent.gradeBookNum = gBookNum;
            return this;
        }

        public Student.Builder withGroupNumber(int groupNum) {
            newStudent.groupNumber = groupNum;
            return this;
        }

        public Student.Builder withAverageScore(double avScore) {
            newStudent.averageScore = avScore;
            return this;
        }

        public Student build() {
            return newStudent;
        }
    }

    //код для проверки
    public static void printClass(Student S) {
        System.out.print("Номер зачетной книжки: " + S.gradeBookNum);
        System.out.print(" Номер группы: " + S.groupNumber);
        System.out.println(" Средний бал: " + S.averageScore);
    }

    public static void comparePair(Student S1, Student S2) {
        int comp = S1.compareTo(S2);
        if (comp == 0) {
            System.out.println(S1.gradeBookNum + " и " + S2.gradeBookNum + " равны.");
        }
        else if (comp < 0) {
            System.out.println(S1.gradeBookNum + " меньше " + S2.gradeBookNum);
        }
        else  System.out.println(S1.gradeBookNum + " больше " + S2.gradeBookNum);
    }

    public static void main(String[] args) {
        Student myStudent1 = new Student.Builder()
                .withGradeBookNum(846123)
                .withGroupNumber(312)
                .withAverageScore(4.50)
                .build();
        Student myStudent2 = new Student.Builder()
                .withGradeBookNum(654846)
                .withGroupNumber(212)
                .withAverageScore(4.00)
                .build();
        printClass(myStudent1);
        printClass(myStudent2);
        comparePair(myStudent1, myStudent2);
        comparePair(myStudent2, myStudent1);
        comparePair(myStudent1, myStudent1);
        comparePair(myStudent2, myStudent2);
    }
}
