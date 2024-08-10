package org.aston.course.application.usecase.randoms;

import org.aston.course.application.datasource.User;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.business.GeneratorStrategy;
import org.aston.course.domain.model.SomeEntity;

public class UserRandomImpl implements GeneratorStrategy<User> {

    @Override
    public User generator(EntityCreator<User> creator) {
        return null;
    }
}
