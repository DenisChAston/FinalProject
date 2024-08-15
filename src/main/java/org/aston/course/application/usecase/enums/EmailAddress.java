package org.aston.course.application.usecase.enums;

public enum EmailAddress {
    Yandex("@yandex.ru"), Mail("@mail.ru"), Google("@gmail.com"),
    Yahoo("@yahoo.com"), Inbox("@inbox.ru");

    private final String name;

    EmailAddress(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
