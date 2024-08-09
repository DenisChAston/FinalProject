package org.aston.course.datasource;

//класс Пользователь
public class User implements SomeEntity, Comparable<User> {

    private final String name; //имя
    private final String password; //пароль
    private final String email; //почта

    //конструктор с параметрами
    private User (UserBuilder builder) {
        this.name = builder.name; //имя
        this.password = builder.password;  //пароль
        this.email = builder.email; //почта
    }

    //геттеры
    public String getName () {
        return this.name;
    }

    public String getPassword () {
        return this.password;
    }

    public String getEmail () {
        return this.email;
    }

    //переопределение метода cравнения, сравнениваем по имени)
    @Override //возвращает отрицательное число, если первый меньше второго
    public int compareTo(User other) { //ноль, если объекты равны, иначе - положительное число
        int result = this.getName().toLowerCase().compareTo(other.getName().toLowerCase()); //сравнение по номеру
        if (result == 0) { //если имена совпадают, сравниваем адреса электронной почты
            result = this.getEmail().toLowerCase().compareTo(other.getEmail().toLowerCase());
        }
        return result;
    } //перед сравнением приводим имена и адреса почты к нижнему регистру

    //возвращает поля объекта в виде форматированной строки
    public static String toString(User U) {
        return "Имя: " + U.getName() +
                ", Пароль: " + U.getPassword() +
                ", E-mail: " + U.getEmail();
    }

    //реализация паттерна Builder
    public static class UserBuilder {
        private String name; //имя
        private String password; //пароль
        private String email; //почта

        public User.UserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public User.UserBuilder withPassword(String pass) {
            this.password = pass;
            return this;
        }

        public User.UserBuilder withEmail(String mail) {
            this.email = mail;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
