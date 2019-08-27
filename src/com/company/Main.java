package com.company;

import java.util.*;

public class Main {
    public static List<Set<Integer>> subsets(Set<Integer> s) {
        Queue<Integer> copyToProtectData  = new LinkedList<Integer>();
        for(int member: s) {
            System.out.println(member);
            copyToProtectData.add(member);
        }
        List<Set<Integer>> subsets = new ArrayList<Set<Integer>>();
        generateSubsets(copyToProtectData, subsets, new HashSet<Integer>());
        return subsets;
    }
    private static void generateSubsets(Queue<Integer> s,
                                        List<Set<Integer>> subsets, Set<Integer> hashSet) {
        if(s.isEmpty()) {
            subsets.add(hashSet);
        } else {
            int member = s.remove();
            Set<Integer> copy = new HashSet<Integer>();
            for(int i:hashSet) {
                copy.add(i);
            }
            hashSet.add(member);
            Queue<Integer> queueCopy = new LinkedList<Integer>();
            for(int i:s){
                queueCopy.add(i);
            }
            generateSubsets(s, subsets, hashSet);
            generateSubsets(queueCopy, subsets, copy);
        }
    }

    public static void main(String[] args) {
        Set<Integer> hash_Set = new HashSet<Integer>();
        hash_Set.add(1);
        hash_Set.add(2);
        hash_Set.add(3);
        hash_Set.add(4);
        System.out.println(subsets(hash_Set));
        //https://stackoverflow.com/questions/29225659/is-the-space-complexity-of-this-subset-algorithm-actually-on
        //O(n 2n)
    }
}
