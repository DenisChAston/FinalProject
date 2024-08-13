package org.aston.course.application.usecase.exceptions;

/**
 * Класс для отлавливания неверного ввода email.
 * Пример корректного email - example@gmail.com
 */

public class EmailFormatException extends RuntimeException {

    public EmailFormatException() {
    }

    public EmailFormatException(String message) {
        super(message);
    }

    public EmailFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailFormatException(Throwable cause) {
        super(cause);
    }

    public EmailFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
