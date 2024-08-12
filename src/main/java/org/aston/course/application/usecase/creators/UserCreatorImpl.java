package org.aston.course.application.usecase.creators;


import org.aston.course.application.datasource.User;
import org.aston.course.application.usecase.enums.EmailAddress;
import org.aston.course.application.usecase.enums.LowCaseAlphabet;
import org.aston.course.application.usecase.enums.UpCaseAlphabet;
import org.aston.course.domain.business.EntityCreator;

import java.util.Random;

public class UserCreatorImpl implements EntityCreator<User> {

    private final User user = new User.UserBuilder().build();

    private static final UpCaseAlphabet[] UP_CASE_ALPHABETS = UpCaseAlphabet.values();
    private static final LowCaseAlphabet[] LOW_CASE_ALPHABETS = LowCaseAlphabet.values();
    private static final EmailAddress[] EMAIL_ADDRESSES = EmailAddress.values();
    private final Random rnd = new Random();

    @Override
    public User create(String name, String password, String thirdParam) {
        return new User.UserBuilder().setName(name).setPassword(password).setEmail(thirdParam).build();
    }

    @Override
    public User random() {
        StringBuilder name = getUserNameRandom();
        StringBuilder password = getUserPasswordRandom();
        StringBuilder email = getUserEmailRandom();
        return create(name.toString(), password.toString(), email.toString());
    }

    private StringBuilder getUserNameRandom() {
        StringBuilder name = new StringBuilder();

        if (rnd.nextInt(2) == 1) {
            name.append(UP_CASE_ALPHABETS[rnd.nextInt(UP_CASE_ALPHABETS.length)]);
        }
        for (int i = 0; i < rnd.nextInt(5, 10); i++) {
            name.append(LOW_CASE_ALPHABETS[rnd.nextInt(LOW_CASE_ALPHABETS.length)]);
        }
        return name;
    }

    private StringBuilder getUserPasswordRandom() {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < rnd.nextInt(6, 10); i++) {
            int bol = rnd.nextInt(5);
            switch (bol) {
                case 0 -> password.append(UP_CASE_ALPHABETS[rnd.nextInt(UP_CASE_ALPHABETS.length)]);
                case 1 -> password.append(rnd.nextInt(10));
                default -> password.append(LOW_CASE_ALPHABETS[rnd.nextInt(LOW_CASE_ALPHABETS.length)]);
            }
        }
        return password;
    }

    private StringBuilder getUserEmailRandom() {
        StringBuilder email = new StringBuilder();
        for (int i = 0; i < rnd.nextInt(6, 8); i++) {
            if (rnd.nextInt(5) == 0) {
                email.append(rnd.nextInt(11));
            } else {
                email.append(LOW_CASE_ALPHABETS[rnd.nextInt(LOW_CASE_ALPHABETS.length)]);
            }
        }
        email.append(EMAIL_ADDRESSES[rnd.nextInt(EMAIL_ADDRESSES.length)].getName());
        return email;
    }

    @Override
    public String getFirstParamName() {
        return user.getFirstParam();
    }

    @Override
    public String getSecondParamName() {
        return user.getSecondParam();
    }

    @Override
    public String getThirdParamName() {
        return user.getThirdParam();
    }
}
