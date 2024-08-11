package org.aston.course.application.usecase.comparators;

import org.aston.course.application.datasource.Bus;
import org.aston.course.domain.business.EvenNumberComparator;

import java.util.Comparator;

public class BussEvenNumberComparatorImpl implements Comparator<Bus>, EvenNumberComparator {

    @Override
    public int compare(Bus thisBus, Bus otherBus) {

        if (thisBus.getNumber()%2==0 && otherBus.getNumber() %2 ==0) {
            return thisBus.compareTo(otherBus);
        }
        return 0;
    }
}
