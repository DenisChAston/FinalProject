package org.aston.course.application.usecase.creators;


import org.aston.course.application.datasource.User;
import org.aston.course.domain.model.EntityCreator;

public class UserCreatorImpl implements EntityCreator {

    @Override
    public User create(String name, String password, String thirdParam) {
        return new User.UserBuilder().setName(name).setPassword(password).setEmail(thirdParam).build();
    }

    @Override
    public String getFirstParamName() {
        return "имя пользователя";
    }

    @Override
    public String getSecondParamName() {
        return "пароль пользователя";
    }

    @Override
    public String getThirdParamName() {
        return "email пользователя";
    }
}
