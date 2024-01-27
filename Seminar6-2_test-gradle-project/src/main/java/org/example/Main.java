package org.example;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        String string = "string";
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add(string);
        set1.add("1");
        set2.add("1");
        set2.add("2");

        System.out.println(Lists.reverse(list));
        System.out.println(Lists.charactersOf(string));
        System.out.println(Lists.partition(Lists.charactersOf(string), 2));
        System.out.println(Sets.union(set1, set2));
        System.out.println(Sets.intersection(set1, set2));
        System.out.println(Sets.symmetricDifference(set1, set2));
    }
}