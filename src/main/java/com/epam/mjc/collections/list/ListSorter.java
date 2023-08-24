package com.epam.mjc.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListSorter {
    public void sort(List<String> sourceList) {


        List<String> resultsOfFunction =
                getResultsOfFunction(sourceList);

        List<String[]> pairsForSorting =
                getPairsForSorting(sourceList, resultsOfFunction);

        Comparator<String[]> comparator = new ListComparator().thenComparing(new ListComparatorForDuplicates());

        pairsForSorting.sort(comparator.thenComparing(new ListComparatorForDuplicates()));

        for (int i = 0; i < sourceList.size(); i++) {
            System.out.print(sourceList.get(i) + "  ------  ");
            sourceList.set(i, (pairsForSorting.get(i)[0]));
            System.out.println(sourceList.get(i));

        }

//        sourceList = new ArrayList<>();
//        for (String[] e : pairsForSorting) {
//            sourceList.add(e[0]);
//        }
////        sourceList = sortedList;
//        System.out.println(sourceList);
    }

    private List<String> getResultsOfFunction(List<String> sourceList) {
        List<String> resultsOfFunction = new ArrayList<>(); // 5x^2+3
        for (int i = 0; i < sourceList.size(); i++) {
            resultsOfFunction.add(String.valueOf(5 * Integer.parseInt(sourceList.get(i)) * Integer.parseInt(sourceList.get(i)) + 3)); // 5x^2+3
        }
//        System.out.println(resultsOfFunction + "\n");
        return resultsOfFunction;
    }

    private List<String[]> getPairsForSorting(List<String> sourceList, List<String> resultsOfFunction) {
        List<String[]> pairsForSorting = new ArrayList<>(); // sourceListInt + resultsOfFunction
        for (int i = 0; i < sourceList.size(); i++) {
            String[] pair = {sourceList.get(i).strip(), resultsOfFunction.get(i)};
//            System.out.println(Arrays.toString(pair));
            pairsForSorting.add(pair);
        }
//        System.out.println();
        return pairsForSorting;
    }
}


class ListComparator implements Comparator<String[]> {

    @Override
    public int compare(String[] a, String[] b) {
        if (Integer.parseInt(a[1]) == Integer.parseInt(b[1])) {
            return 0;
        }
        if (Integer.parseInt(a[1]) > Integer.parseInt(b[1])) {
            return 1;
        } else {
            return -1;
        }
    }
}

class ListComparatorForDuplicates implements Comparator<String[]> {
    public int compare(String[] a, String[] b) {
        if (Integer.parseInt(a[0]) == Integer.parseInt(b[0])) {
            return 0;
        }
        if (Integer.parseInt(a[0]) > Integer.parseInt(b[0])) {
            return 1;
        } else {
            return -1;
        }
    }
}
