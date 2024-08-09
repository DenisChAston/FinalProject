package org.aston.course.datasource;

//класс Студент
public class Student implements SomeEntity, Comparable<Student>{
    private final int gradeBookNum; //номер зачетной книжки
    private final int groupNumber; //номер группы
    private final double averageScore; //средний бал

    //конструктор с параметрами
    private Student (StudentBuilder builder) {
        this.gradeBookNum = builder.gradeBookNum; //номер зачетной книжки
        this.groupNumber = builder.groupNumber;  //номер группы
        this.averageScore = builder.averageScore; //средний бал
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
        return this.getGradeBookNum() - other.getGradeBookNum(); //сравнение по номеру зачетной книжки, как уникального значения
    } //метод compareTo из класса Integer не применен, поскольку не работает с примитивами

    //возвращает поля объекта в виде форматированной строки
    public static String toString(Student S) {
        return "Номер зачетной книжки: " + S.gradeBookNum +
                ", Номер группы: " + S.getGroupNumber() +
                ", Средний бал: " + S.getAverageScore();
    }

    //реализация паттерна Builder
    public static class StudentBuilder {
        private int gradeBookNum; //номер зачетной книжки
        private int groupNumber; //номер группы
        private double averageScore; //средний бал

        public Student.StudentBuilder withGradeBookNum(int gBookNum) {
            this.gradeBookNum = gBookNum;
            return this;
        }

        public Student.StudentBuilder withGroupNumber(int groupNum) {
            this.groupNumber = groupNum;
            return this;
        }

        public Student.StudentBuilder withAverageScore(double avScore) {
            this.averageScore = avScore;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    //код для проверки
    public static void printClass(Student S) {
        System.out.println(toString(S));
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
        Student myStudent1 = new Student.StudentBuilder()
                .withGradeBookNum(846123)
                .withGroupNumber(312)
                .withAverageScore(4.50)
                .build();
        Student myStudent2 = new Student.StudentBuilder()
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
    //
}
