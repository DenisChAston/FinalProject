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

    //код для проверки
    public static void printClass(User U) {
        System.out.println(toString(U));
    }

    public static void comparePair(User U1, User U2) {
        int comp = U1.compareTo(U2);
        if (comp == 0) {
            System.out.println(U1.name + " и " + U2.name + " равны.");
        }
        else if (comp < 0) {
            System.out.println(U1.name + " меньше " + U2.name);
        }
        else  System.out.println(U1.name + " больше " + U2.name);
    }

    public static void main(String[] args) {
        User myUser1 = new User.UserBuilder()
                .withName("Petrov")
                .withPassword("1234567890")
                .withEmail("petrov@mail.ru")
                .build();
        User myUser2 = new User.UserBuilder()
                .withName("Ivan")
                .withPassword("0987654321")
                .withEmail("ivanov@mail.ru")
                .build();
        printClass(myUser1);
        printClass(myUser2);
        comparePair(myUser1, myUser2);
        comparePair(myUser2, myUser1);
        comparePair(myUser1, myUser1);
        comparePair(myUser2, myUser2);
    }
    //
}
