package org.aston.course.application.usecase.comparators;

import org.aston.course.application.datasource.Bus;
import org.aston.course.domain.business.SomeComparator;

public class BusEvenNumberComparatorImpl implements SomeComparator<Bus> {

    /**
     * Компаратор для сравнения только тех Автобусов, у которых Номер маршрута четный
     * @param thisBus the first object to be compared.
     * @param otherBus the second object to be compared.
     * @return -1, 0, 1 как результат сортировки по умолчанию
     */
    @Override
    public int compare(Bus thisBus, Bus otherBus) {

        if (thisBus.getNumber()%2==0 && otherBus.getNumber() %2 ==0) {
            return thisBus.compareTo(otherBus);
        }
        return 0;
    }
}
