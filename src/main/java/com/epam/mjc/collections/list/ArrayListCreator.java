package com.epam.mjc.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ArrayListCreator {

    public static void main(String[] args) {

        List<String> source = Arrays.asList("The", "ArrayList", "class", "has", "many", "useful", "methods");
        new ArrayListCreator().createArrayList(source);

        List<Integer> intSource = Arrays.asList(2, 14, 3, 6, 5, 7);
        new LinkedListCreator().createLinkedList(intSource);

        List<String> sourceList = Arrays.asList("7", "10", "6", "-7", "-2", "0", "-2", "-23");
        new ListSorter().sort(sourceList);
        // [7, 10, 6, -7, -2, 0, -2, -23] source
        // [0, -2, -2, 6, -7, 7, 10, -23] expected

    }

    public ArrayList<String> createArrayList(List<String> sourceList) {
        ArrayList<String> resultList = new ArrayList<>();
//        for (int i = 1; i < sourceList.size() + 1; i++) {
//            if (i % 3 == 0) {
//                resultList.add(sourceList.get(i - 1));
//                resultList.add(sourceList.get(i - 1));
//            }
//        }
        ListIterator<String> listIterator = sourceList.listIterator();

        while (listIterator.hasNext()) {
            int n = listIterator.nextIndex() + 1;
            String s = listIterator.next();
            if (n % 3 == 0) {
                resultList.add(s);
                resultList.add(s);
            }
        }

        return resultList;
    }
}
