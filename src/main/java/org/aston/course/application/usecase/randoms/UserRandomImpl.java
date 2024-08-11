package org.aston.course.application.usecase.randoms;

import org.aston.course.application.datasource.Student;
import org.aston.course.application.datasource.User;
import org.aston.course.application.usecase.Enum.*;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.application.GeneratorStrategy;

import java.util.concurrent.ThreadLocalRandom;

public class UserRandomImpl implements GeneratorStrategy<User> {

    @Override
    public User generator(EntityCreator<User> creator) {
        User temp = creator.create(name(), password(), email());
        return temp;
    }

    private String name() {
        UserName[] name = UserName.values();
        int randomName = ThreadLocalRandom.current().nextInt(1, UserName.values().length);
        return String.valueOf(name[randomName]);
    }

    private String password() {
        PassEnum[] name = PassEnum.values();
        StringBuilder builder = new StringBuilder();
        for (int i = 10; i != 0; i--) {
            int randomChar = ThreadLocalRandom.current().nextInt(1, PassEnum.values().length);
            builder.append(name[randomChar]);
        }
        return builder.toString();
    }

    private String email() {
    int randUsEmailName = ThreadLocalRandom.current().nextInt(1, UserEmailName.values().length);
        int randUsEmailAppend = ThreadLocalRandom.current().nextInt(1, UserEmailName.values().length);
        int randUsEmailDom = ThreadLocalRandom.current().nextInt(1, UserEmailDomain.values().length);
        StringBuilder builder = new StringBuilder();
        UserEmailName [] names = UserEmailName.values();
        UserEmailNameAppend [] appends =UserEmailNameAppend.values();
        UserEmailDomain [] domains = UserEmailDomain.values();
        builder = builder.append(names[randUsEmailName]).append("@")
                .append(appends[randUsEmailAppend]).append(".")
                .append(domains[randUsEmailDom]);
        return builder.toString();
    }
}
