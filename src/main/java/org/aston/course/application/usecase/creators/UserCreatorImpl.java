package org.aston.course.application.usecase.creators;


import org.aston.course.application.datasource.User;
import org.aston.course.domain.business.EntityCreator;

public class UserCreatorImpl implements EntityCreator<User> {

    @Override
    public User create(String name, String password, String email) {
        return new User.UserBuilder().setName(name).setPassword(password).setEmail(email).build();
    }
}
