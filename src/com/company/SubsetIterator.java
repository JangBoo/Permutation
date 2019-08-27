package com.company;

import java.util.*;

public class SubsetIterator<E> {
    private final List<E> set;
    private final int max;
    private int index;
    public SubsetIterator(List<E> originalList) {
        set = originalList;
        max = (1 << set.size());
        System.out.println(max);
        index = 0;
    }
    public boolean hasNext() {
        return index < max;
    }
    public Queue<E> next() {
        Queue<E> q = new LinkedList<>();
        //List<E> newSet = new ArrayList<E>();
        int flag = 1;
        for (E element : set) {
            if ((index & flag) != 0) {
                q.add(element);
            }
            //System.out.println(flag);
            flag <<= 1;
        }
        ++index;
        return q;
    }

    // Test.
    public static void main(String[] args) {
        List<String> set = Arrays.asList("A", "B", "C", "D");
        SubsetIterator<String> it =
                new SubsetIterator<String>(set);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}