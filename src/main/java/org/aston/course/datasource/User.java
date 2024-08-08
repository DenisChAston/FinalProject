package org.aston.course.datasource;

//класс Пользователь
public class User implements Comparable<User> {

    private String name; //имя
    private String password; //пароль
    private String email; //почта

    //конструктор без параметров
    User () {
        this.name = "unknown";
        this.password = "unknown";
        this.email = "unknown";
    }
    //конструктор с параметрами
    User (String name, String pass, String mail) {
        this.name = name; //имя
        this.password = pass;  //пароль
        this.email = mail; //почта
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
        int result = this.name.toLowerCase().compareTo(other.name.toLowerCase()); //сравнение по номеру
        if (result == 0) { //если имена совпадают, сравниваем адреса электронной почты
            result = this.email.toLowerCase().compareTo(other.email.toLowerCase());
        }
        return result;

    } //перед сравнением приводим имена и адреса почты к нижнему регистру

    //реализация паттерна Builder
    public static class Builder {
        private final User newUser;

        public Builder() {
            newUser = new User();
        }

        public User.Builder withName(String name) {
            newUser.name = name;
            return this;
        }

        public User.Builder withPassword(String pass) {
            newUser.password = pass;
            return this;
        }

        public User.Builder withEmail(String mail) {
            newUser.email = mail;
            return this;
        }

        public User build() {
            return newUser;
        }
    }

    //код для проверки
    public static void printClass(User U) {
        System.out.print("Имя: " + U.name);
        System.out.print(" Пароль: " + U.password);
        System.out.println(" E-mail: " + U.email);
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
        User myUser1 = new User.Builder()
                .withName("Aleksei")
                .withPassword("1234567890")
                .withEmail("dolinin@mail.ru")
                .build();
        User myUser2 = new User.Builder()
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





}
