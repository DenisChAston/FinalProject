package org.aston.course.application.usecase.creators;


import org.aston.course.application.datasource.User;
import org.aston.course.domain.model.EntityCreator;

import java.util.Random;

public class UserCreatorImpl implements EntityCreator {

    public static final String upCharsRus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String lowCharsRus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static final String upCharsUK = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lowCharsUk = "abcdefghijklmnopqrstuvwxyz";
    private static final String[] emails = {"@mail.ru", "@yandex.ru", "@gmail.com"};
    private final Random rnd = new Random();



    @Override
    public User create(String name, String password, String thirdParam) {
        return new User.UserBuilder().setName(name).setPassword(password).setEmail(thirdParam).build();
    }

    @Override
    public User random() {

        StringBuilder name = new StringBuilder();
        if (rnd.nextInt(5) == 0) {
            name.append(upCharsRus.charAt(rnd.nextInt(upCharsRus.length())));
        } else {
            name.append(lowCharsRus.charAt(rnd.nextInt(lowCharsRus.length())));
        }
        for (int i = 0; i < rnd.nextInt(5, 10); i++) {
            name.append(lowCharsRus.charAt(rnd.nextInt(lowCharsRus.length())));
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < rnd.nextInt(6, 10); i++) {
            int bol = rnd.nextInt(5);
            switch (bol) {
                case 0 -> password.append(upCharsUK.charAt(rnd.nextInt(upCharsUK.length())));
                case 1 -> password.append(rnd.nextInt(10));
                default -> password.append(lowCharsUk.charAt(rnd.nextInt(lowCharsUk.length())));
            }
        }

        StringBuilder email = new StringBuilder();
        for (int i = 0; i < rnd.nextInt(6, 8); i++) {
            if (rnd.nextInt(5) == 0) {
                email.append(rnd.nextInt(11));
            } else {
                email.append(lowCharsUk.charAt(rnd.nextInt(lowCharsUk.length())));
            }
        }
        email.append(emails[rnd.nextInt(emails.length)]);

        return create(name.toString(), password.toString(), email.toString());
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
