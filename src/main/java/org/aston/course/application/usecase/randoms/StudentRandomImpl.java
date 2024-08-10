package org.aston.course.application.usecase.randoms;
import org.aston.course.application.datasource.Student;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.business.GeneratorStrategy;
import org.aston.course.domain.model.SomeEntity;

public class StudentRandomImpl implements GeneratorStrategy<Student> {
    @Override
    public Student generator(EntityCreator<Student> creator) {
        Student temp = creator.create("1","2","3");
        return temp;
    }
}
