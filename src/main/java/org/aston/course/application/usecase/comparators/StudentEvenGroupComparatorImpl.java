package org.aston.course.application.usecase.comparators;

import org.aston.course.application.datasource.Student;
import org.aston.course.domain.business.SomeComparator;

public class StudentEvenGroupComparatorImpl implements SomeComparator<Student> {

    /**
     * Компаратор для сравнения только тех Студентов, у которых Номер группы четный
     * @param thisStudent the first object to be compared.
     * @param otherStudent the second object to be compared.
     * @return -1, 0, 1 как результат сортировки по умолчанию
     */
    @Override
    public int compare(Student thisStudent, Student otherStudent) {
        if (thisStudent.getGroupNumber()%2 == 0 && otherStudent.getGroupNumber()%2 == 0) {
            return thisStudent.compareTo(otherStudent);
        }
        return 0;
    }
}
