package org.example.seminar;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String t = "Hi";
        DataInputStream v = new DataInputStream(System.in);
        Integer k = 5;

        Ex1MegaClass<String, DataInputStream, Integer> test1 = new Ex1MegaClass(t, v , k);

        System.out.println(test1.toString());

        Ex2MyList<String> test2 = new Ex2MyList<>();
        test2.addElement("a");
        test2.addElement("b");

        System.out.println(test2.toString());
        System.out.println(test2.getSize());

        for (String str: test2) {
            System.out.println(str);
        }

        // Homework 2:
        System.out.println("Homework 2: ");
        System.out.printf("sum() = %d\n", Hw2Calculator.sum(2, 3.0f));
        System.out.printf("subtract() = %d\n", Hw2Calculator.subtract(2, 3.0f));
        System.out.printf("multiply() = %d\n", Hw2Calculator.multiply(2, 3.0f));
        System.out.printf("divide() = %d\n", Hw2Calculator.divide(2, 3.0f));

        // Homework 3:

        ArrayList<String> hw3Test1 = new ArrayList<>(Arrays.asList("a", "b"));
        ArrayList<String> hw3Test2 = new ArrayList<>(Arrays.asList("a", "b"));
        ArrayList<String> hw3Test3 = new ArrayList<>(Arrays.asList("c"));
        ArrayList<Integer> hw3Test4 = new ArrayList<>(Arrays.asList(1, 2));
        System.out.println("Homework 3:");
        System.out.println(Hw3CompareArrays.compareArrays(hw3Test1, hw3Test2));
        System.out.println(Hw3CompareArrays.compareArrays(hw3Test1, hw3Test3));
//        System.out.println(Hw3CompareArrays.compareArrays(hw3Test1, hw3Test4));

        // Homework 4:
        System.out.println("Homework 4: ");
        Hw4Pair answer = new Hw4Pair(3, 4.0f);
        System.out.println(answer.toString());
    }
}
