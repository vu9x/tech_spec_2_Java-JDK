package org.example.lecture.box;

import java.util.ArrayList;
import java.util.Arrays;

public class copyTo {
    public static <T> void copyTo(ArrayList<? extends T> src, ArrayList<? super T> dst){
        for(T o: src) {
            dst.add(o);
        }
    }

    private static class Animal {
        protected String name;
        protected Animal(){this.name = "Animal";}

        @Override
        public String toString() {return name;}
    }

    private static class Cat extends Animal{
        protected Cat() {this.name = "Cat";}
        public void voice(){
            System.out.println("Meow");
        }
    }

    public static void main(String[] args) {
        ArrayList<Cat> cats = new ArrayList<>(Arrays.asList(new Cat()));
        ArrayList<Animal> animals = new ArrayList<>(Arrays.asList(new Animal()));
        copyTo(cats, animals);

        cats.get(0).voice();
        ((Cat)animals.get(1)).voice();
    }
}
