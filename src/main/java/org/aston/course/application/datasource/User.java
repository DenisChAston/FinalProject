package org.aston.course.application.datasource;

import org.aston.course.domain.model.SomeEntity;

import java.math.BigDecimal;

public class User implements SomeEntity, Comparable<User> {

    private final String name;
    private final String password;
    private final String email;

    private User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return name.equals(user.name) && password.equals(user.password) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Имя:%s, Пароль:%s, Почта:%s", name, password, email);
    }


    /**
     * Сортировка по умолчанию для объектов типа User.
     * Сначала сравнивается по полю Name - имя пользователя
     * Затем сравнивается по полю Email - email пользователя
     * В конце сравнивается по полю Password - пароль
     * @param otherUser the object to be compared.
     * @return -1, если имя по алфавиту раньше, или email по алфавиту раньше, или пароль по алфавиту раньше
     * 0, если объекты полностью идентичны
     * 1, если имя по алфавиту позже, или email по алфавиту позже, или пароль по алфавиту розже
     */
    @Override
    public int compareTo(User otherUser) {
        int nameComparing = this.name.toLowerCase().compareTo(otherUser.getName().toLowerCase());
        int andEmailComparing = nameComparing == 0 ? this.email.toLowerCase().compareTo(otherUser.getEmail().toLowerCase()) : nameComparing;
        return andEmailComparing == 0 ? this.password.toLowerCase().compareTo(otherUser.getPassword().toLowerCase()) : andEmailComparing;
    }

    @Override
    public String getFirstParam() {
        return "имя пользователя";
    }

    @Override
    public String getSecondParam() {
        return "пароль пользователя";
    }

    @Override
    public String getThirdParam() {
        return "email пользователя";
    }

    public static class UserBuilder {
        private String name;
        private String password;
        private String email;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(name, password, email);
        }
    }
}
