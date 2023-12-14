package org.example.seminar;

public class Hw2Calculator{
    public static <T extends Number> int sum(T first, T second){
        return first.intValue() + second.intValue();
    }

    public static <T extends Number> int multiply(T first, T second){
        return first.intValue() * second.intValue();
    }

    public static <T extends Number> int divide(T first, T second){
        return first.intValue() / second.intValue();
    }

    public static <T extends Number> int subtract(T first, T second){
        return first.intValue() - second.intValue();
    }
}
