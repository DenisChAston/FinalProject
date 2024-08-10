package org.aston.course.application.usecase.randoms;

import org.aston.course.application.datasource.Student;
import org.aston.course.application.datasource.User;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.application.GeneratorStrategy;

public class UserRandomImpl implements GeneratorStrategy<User> {

    @Override
    public User generator(EntityCreator<User> creator) {
        User temp = creator.create("йцук","про","енгшщ");
        return temp;
    }
}
