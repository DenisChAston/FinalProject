package org.aston.course;

import java.util.List;


public class BinarySearch {
    //Метод возвращает индекс искомой строки
    public static int binarySearch(List<String> list, String s){
        int min, max, mid;
        min = 0;
        max = list.size()-1;

        while(min <= max) {
            mid = min + (max - 1) / 2;
            int res = s.compareTo(list.get(mid));
            if (res == 0) {
                return mid;
            } else if (res > 0) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return -1;
    }
}
