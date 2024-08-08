package org.aston.course.application.datasource;

import org.aston.course.domain.model.SomeEntity;

public class Student implements SomeEntity {

    private final int groupNumber;
    private final double averageScore;
    private final int gradebookNumber;

    private Student(int groupNumber, double averageScore, int gradebookNumber) {
        this.groupNumber = groupNumber;
        this.averageScore = averageScore;
        this.gradebookNumber = gradebookNumber;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public int getGradebookNumber() {
        return gradebookNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;
        return groupNumber == student.groupNumber && Double.compare(averageScore, student.averageScore) == 0 && gradebookNumber == student.gradebookNumber;
    }

    @Override
    public int hashCode() {
        int result = groupNumber;
        result = 31 * result + Double.hashCode(averageScore);
        result = 31 * result + gradebookNumber;
        return result;
    }

    @Override
    public String toString() {
        return String.format("Номер группы:%d, Средний балл:%.2f, Номер зачетки:%d", groupNumber, averageScore, gradebookNumber);
    }

    public static class StudentBuilder {
        private int groupNumber;
        private double averageScore;
        private int gradebookNumber;

        public StudentBuilder setGroupNumber(int groupNumber) {
            this.groupNumber = groupNumber;
            return this;
        }

        public StudentBuilder setAverageScore(double averageScore) {
            this.averageScore = averageScore;
            return this;
        }

        public StudentBuilder setGradebookNumber(int gradebookNumber) {
            this.gradebookNumber = gradebookNumber;
            return this;
        }

        public Student build() {
            return new Student(groupNumber, averageScore, gradebookNumber);
        }
    }
}
