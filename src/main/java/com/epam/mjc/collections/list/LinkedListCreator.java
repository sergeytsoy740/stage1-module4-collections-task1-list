package com.epam.mjc.collections.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListCreator {

      public LinkedList<Integer> createLinkedList(List<Integer> sourceList) {
        LinkedList<Integer> ll = new LinkedList<>();
        for (Integer e : sourceList) {
            if (e % 2 != 0) {
                ll.addFirst(e);
            } else {
                ll.addLast(e);
            }
        }
        return ll;
    }
}
