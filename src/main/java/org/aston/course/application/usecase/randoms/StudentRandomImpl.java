package org.aston.course.application.usecase.randoms;
import org.aston.course.application.datasource.Student;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.application.GeneratorStrategy;

import java.util.concurrent.ThreadLocalRandom;

public class StudentRandomImpl implements GeneratorStrategy<Student> {
    @Override
    public Student generator(EntityCreator<Student> creator) {
        String fp = String.valueOf(groupNumberGen());
        String sp = String.valueOf(averegeScore());
        String tp = String.valueOf(groupNumberGen());
        Student temp = creator.create(fp,sp,tp);
        return temp;
    }
    private int groupNumberGen (){

        int randomNum = ThreadLocalRandom.current().nextInt(1000, 9998 + 1);
        return randomNum;
    }
    private double averegeScore(){
        double randomNum = ThreadLocalRandom.current().nextDouble(1, 4 + 1);
        return randomNum;
    }
}
