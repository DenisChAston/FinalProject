package org.aston.course.application.usecase.creators;

import org.aston.course.application.datasource.Bus;
import org.aston.course.application.datasource.Student;
import org.aston.course.domain.model.EntityCreator;

import java.util.Random;

public class StudentCreatorImpl implements EntityCreator<Student> {

    private final Student student = new Student.StudentBuilder().build();

    private final Random rnd = new Random();

    @Override
    public Student create(String groupNumber, String averageScore, String thirdParam) {
        int tempGroupNumber = Integer.parseInt(groupNumber);
        double tempAverageScore = Double.parseDouble(averageScore);
        int tempGradebookNumber = Integer.parseInt(thirdParam);
        return new Student.StudentBuilder().setGroupNumber(tempGroupNumber).setAverageScore(tempAverageScore).setGradebookNumber(tempGradebookNumber).build();
    }

    @Override
    public Student random() {
        return create(String.valueOf(rnd.nextInt(10)), String.valueOf(rnd.nextDouble(2,5)), String.valueOf(rnd.nextInt(1000)));
    }

    @Override
    public String getFirstParamName() {
        return student.getFirstParam();
    }

    @Override
    public String getSecondParamName() {
        return student.getSecondParam();
    }

    @Override
    public String getThirdParamName() {
        return student.getThirdParam();
    }
}
