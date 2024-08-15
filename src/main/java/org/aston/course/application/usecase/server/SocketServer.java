package org.aston.course.application.usecase.server;

import org.aston.course.application.usecase.creators.BusCreatorImpl;
import org.aston.course.application.usecase.creators.StudentCreatorImpl;
import org.aston.course.application.usecase.creators.UserCreatorImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
/** Сервер, к которому подключается клиент
 * Для начала работы следует его запустить, перед тем как начать работать с Main
 */
        try (ServerSocket serverSocket = new ServerSocket(7777);
             Socket socket = serverSocket.accept();
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream())
        ) {
            var request = inputStream.readUTF();
            while (!request.equals("stop")) {
/**Проверка запросов от клиента и отправка ответа
 */
                if (request.equals(BusCreatorImpl.class.toString())) {
                    outputStream.writeUTF(createBus());
                    request = inputStream.readUTF();
                } else if (request.equals(StudentCreatorImpl.class.toString())) {
                    outputStream.writeUTF(createStudent());
                    request = inputStream.readUTF();
                } else if (request.equals(UserCreatorImpl.class.toString())) {
                    outputStream.writeUTF(createUser());
                    request = inputStream.readUTF();
                }
            }
            outputStream.flush();
        }

    }
    /** На основе случайного генератора - симуляция заполненной базы данных
     * Если была бы готовая БД, то читали бы строки из нее
     */
    private static String createBus() {
        var bus = new BusCreatorImpl().random();
        StringBuilder sb = new StringBuilder();
        var str = String.valueOf(sb.append(bus.getNumber()).append(" ")
                .append(bus.getModel()).append(" ").append(bus.getMileage()));
        return str;

    }
    private static String createStudent() {
        var student = new StudentCreatorImpl().random();
        StringBuilder sb = new StringBuilder();
        var str = String.valueOf(sb.append(student.getGroupNumber()).append(" ")
                .append(student.getAverageScore()).append(" ").append(student.getGradebookNumber()));
        return str;
    }
    private static String createUser() {
        var user = new UserCreatorImpl().random();
        StringBuilder sb = new StringBuilder();
        var str = String.valueOf(sb.append(user.getName()).append(" ")
                .append(user.getPassword()).append(" ").append(user.getEmail()));
        return str;
    }

}




