package org.example.seminar;

import java.util.ArrayList;
import java.util.Iterator;

/*
Описать собственную коллекцию – список на основе массива.
Коллекция должна иметь возможность хранить любые типы данных,
иметь методы добавления и удаления элементов.
 */

/*
Написать итератор по массиву.
Итератор – это объект, осуществляющий движение по коллекциям любого типа, содержащим любые типы данных.
Итераторы обычно имеют только два метода – проверка на наличие следующего элемента и переход к следующему элементу.
Но также, особенно в других языках программирования, возможно встретить итераторы, реализующие дополнительную логику.
 */
public class Ex2MyList<T> implements Iterable<T>{
    private ArrayList<T> t;
    private int size;
    public Ex2MyList(){
        this.t = new ArrayList<T>();
        this.size = t.size();
    }
    public ArrayList<T> getT() {
        return t;
    }
    public int getSize() {
        return size;
    }

    public void addElement(T value){
        this.t.add(value);
        this.size = t.size();
    }

    public void removeElement(T value){
        this.t.remove(value);
        this.size = t.size();
    }

    @Override
    public String toString() {
        return this.t.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    class MyListIterator<T> implements Iterator<T>{
        int index;
        private ArrayList<T> array;

        public MyListIterator(){
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return (T) getT().get(index++);
        }
    }
}
