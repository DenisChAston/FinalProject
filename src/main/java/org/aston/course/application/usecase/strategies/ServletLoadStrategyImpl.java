package org.aston.course.application.usecase.strategies;

import org.aston.course.application.datasource.CustomList;
import org.aston.course.application.usecase.server.SocketServerClient;
import org.aston.course.domain.application.LoadStrategy;
import org.aston.course.domain.business.EntityCreator;
import org.aston.course.domain.model.SomeEntity;

import java.io.*;

public class ServletLoadStrategyImpl implements LoadStrategy {
    SocketServerClient client = null;

    /**
     * Класс для генерации списка из сервера
     */
    @Override
    public <T extends Comparable<T> & SomeEntity> void load(CustomList<T> list, EntityCreator<T> creator, BufferedReader reader) throws IOException {
        /**Проверяем подключены ли мы уже к серверу, если нет (клиент не создан), создаем клиент
         */
        if (client == null) {
            client = new SocketServerClient();
        }
        /** Здесь уже есть подключение к серверу - можем отправлять запросы к нему.
         */
        String request = creator.getClass().toString(); //Формируем запрос к серверу - определяем тип запрашиваемых данных
        for (int i = 0; i < list.getCapacity(); i++) {
            client.setRequest(request); //Отправка запроса
            var str = client.getResponse().split(" "); //Получаю результат в строке, через пробел и сразу разделяю ее
            list.add(creator.create(str[0], str[1], str[2])); //создание объекта, на основе полученных данных от сервера

        }
    }
}



