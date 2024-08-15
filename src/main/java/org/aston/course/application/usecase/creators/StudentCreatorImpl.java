package org.aston.course.application.usecase.creators;

import org.aston.course.application.datasource.Student;
import org.aston.course.domain.business.EntityCreator;

/**
 * Класс, отвечающий за создание объекта.
 * Метод create принимает 3 параметра типа String.
 * Метод random создает объект со случайными значениями полей
 */

public class StudentCreatorImpl implements EntityCreator<Student> {

    private final Student student = new Student.StudentBuilder().build();
    //private final Random rnd = new Random();

    @Override
    public Student create(String groupNumber, String averageScore, String thirdParam) {
        int tempGroupNumber = Integer.parseInt(groupNumber);
        double tempAverageScore = Double.parseDouble(averageScore);
        int tempGradebookNumber = Integer.parseInt(thirdParam);
        return new Student.StudentBuilder().setGroupNumber(tempGroupNumber).setAverageScore(tempAverageScore).setGradebookNumber(tempGradebookNumber).build();
    }

    /**
     * Метод создает объект типа Student со случайными значениями полей
     * Номер группы в диапазоне от 1 до 50
     * Среднее значение от 0 до 5
     * Номер зачетной книжки в диапазоне от 1 до 1000000
     * @return - объект типа Student
     */
    @Override
    public Student random() {
        return create(String.valueOf(rnd.nextInt(1,50)), String.valueOf(rnd.nextDouble(0,5)), String.valueOf(rnd.nextInt(1,1000000)));
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
