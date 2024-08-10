package org.aston.course.application.usecase.creators;

import org.aston.course.application.datasource.Student;
import org.aston.course.domain.model.EntityCreator;

public class StudentCreatorImpl implements EntityCreator {

    @Override
    public Student create(String groupNumber, String averageScore, String thirdParam) {
        int tempGroupNumber = Integer.valueOf(groupNumber);
        double tempAverageScore = Double.parseDouble(averageScore);
        int tempGradebookNumber = Integer.parseInt(thirdParam);
        return new Student.StudentBuilder().setGroupNumber(tempGroupNumber).setAverageScore(tempAverageScore).setGradebookNumber(tempGradebookNumber).build();
    }

    @Override
    public String getFirstParamName() {
        return "номер группы студента";
    }

    @Override
    public String getSecondParamName() {
        return "средний балл студента";
    }

    @Override
    public String getThirdParamName() {
        return "номер зачетной книжки студента";
    }
}
