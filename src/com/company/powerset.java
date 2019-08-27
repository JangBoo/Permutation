package com.company;

/**
 * Created by jangh on 2019-05-22.
 */

import java.util.ArrayList;
import java.util.List;

public class powerset {
    public static void main(String[] args) {


    }
    public List<List<Integer>> getPowerSet(List<Integer> set) {
        List<List<Integer>> powerSet = new ArrayList<List<Integer>>();
        int max = 1 << set.size();
        for(int i=0; i < max; i++) {
            List<Integer> subSet = getSubSet(i, set);
            powerSet.add(subSet);
        }
        return powerSet;
    }

    private List<Integer> getSubSet(int p, List<Integer> set) {
        List<Integer> subSet = new ArrayList<Integer>();
        int position = 0;
        for(int i=p; i > 0; i >>= 1) {
            if((i & 1) == 1) {
                subSet.add(set.get(position));
            }
            position++;
        }
        return subSet;
    }
}