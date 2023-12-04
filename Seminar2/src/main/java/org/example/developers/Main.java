package org.example.developers;

public class Main {
    public static void main(String[] args) {
        FullstackDeveloper dev = new FullstackDeveloper();
        dev.developGUI();
        dev.developServer();

        Developer dev2 = new FullstackDeveloper();
        if(dev2 instanceof Frontender){
            ((Frontender) dev2).developGUI();
        }
    }
}
