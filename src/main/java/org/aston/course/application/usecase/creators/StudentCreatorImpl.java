package org.aston.course.application.usecase.creators;

import org.aston.course.application.datasource.Student;
import org.aston.course.domain.model.business.EntityCreator;

public class StudentCreatorImpl implements EntityCreator<Student> {

    @Override
    public Student create(String groupNumber, String averageScore, String gradebookNumber) {
        int tempGroupNumber = Integer.valueOf(groupNumber);
        double tempAverageScore = Double.parseDouble(averageScore);
        int tempGradebookNumber = Integer.parseInt(gradebookNumber);
        return new Student.StudentBuilder().setGroupNumber(tempGroupNumber).setAverageScore(tempAverageScore).setGradebookNumber(tempGradebookNumber).build();
    }
}
