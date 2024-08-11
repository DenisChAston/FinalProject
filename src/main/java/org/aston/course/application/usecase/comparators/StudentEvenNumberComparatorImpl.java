package org.aston.course.application.usecase.comparators;

import org.aston.course.application.datasource.Student;
import org.aston.course.domain.business.EvenNumberComparator;

import java.util.Comparator;

public class StudentEvenNumberComparatorImpl implements Comparator<Student>, EvenNumberComparator {

    @Override
    public int compare(Student thisStudent, Student otherStudent) {
        if (thisStudent.getGroupNumber()%2 == 0 && otherStudent.getGroupNumber()%2 == 0) {
            return thisStudent.compareTo(otherStudent);
        }
        return 0;
    }
}
