package org.example.seminar;

public class Hw4Pair<K, V>{
    private K k;
    private V v;
    public Hw4Pair(K k, V v){
        this.k = k;
        this.v = v;
    }

    public K getK() {return k;}

    public V getV() {return v;}

    @Override
    public String toString() {
        return String.format("%s: %s", getK().toString(), getV().toString());
    }
}
