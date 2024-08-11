package org.aston.course.application.usecase.comparators;

import org.aston.course.application.datasource.Student;
import org.aston.course.domain.business.SomeComparator;

public class StudentEvenBussComparatorImpl implements SomeComparator<Student> {

    @Override
    public int compare(Student thisStudent, Student otherStudent) {
        if (thisStudent.getGroupNumber()%2 == 0 && otherStudent.getGroupNumber()%2 == 0) {
            return thisStudent.compareTo(otherStudent);
        }
        return 0;
    }
}
