package org.aston.course.application.usecase.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;

public class SocketServerClient {
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
/** Класс для создания клиента, который будет подключаться к нашему серверу
 */
    public SocketServerClient() throws IOException {
        var inet4Address = Inet4Address.getByName("localhost");
        var socket = new Socket(inet4Address, 7777);
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());
    }
    /** Передача запроса ответа от сервера
     */
    public String getResponse() throws IOException {
        return inputStream.readUTF();
    }
    /**Передача запроса серверу
     */
    public void setRequest(String stringUTF) throws IOException {
        outputStream.writeUTF(stringUTF);
    }
}



