package org.example.mouseApp;

public class Main {
    public interface MouseListerner{
        void mouseUp();
        void mouseDown();
    }

    private static class MouseAdapter implements MouseListerner{
        @Override public void mouseUp() {}
        @Override public void mouseDown() {}
    }

    private static void addMouseListerner(MouseListerner l){
        l.mouseUp();
        l.mouseDown();
    }

    public static void main(String[] args) {
        MouseAdapter m = new MouseAdapter();
//        m.mouseDown();
//        m.mouseUp();
        addMouseListerner(m);

        // добавляем сразу класс MouseAdapter в метод addMouseListerner
        addMouseListerner(new MouseAdapter());

        // Реализуем добавление интерфейсного идентификатора в метод addMouseListerner
        // без промежуточного класса MouseAdapter
        MouseListerner l = new MouseListerner() {
            @Override
            public void mouseUp() {

            }
            @Override
            public void mouseDown() {

            }
        };
        addMouseListerner(l);

        //Реализация без интерфейсного идентификатора, а сразу передать
        // реализующий экземпляр в аргумент метода

        addMouseListerner(new MouseListerner() {
            @Override public void mouseUp() {

            }
            @Override public void mouseDown() {
            }
        });
    }
}