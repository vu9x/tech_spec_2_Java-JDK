package org.example.chat.server;

/*
На предыдущем семинаре было описано окно сервера приложения, содержащее две кнопки
(старт и стоп) и текстовое поле журнала. Необходимо вынести логику работы сервера
в класс ChatServer, а в обработчиках кнопок оставить только логику нажатия кнопки и
журналирования сообщений от сервера.
Для достижения цели необходимо описать интерфейс «слушатель сервера», с методом
«получить сообщение», вызывать его с одной стороны, и реализовать с другой. Вариант
решения
 */

public class Server implements ServerListerner{
    private boolean isServerWorking;
    private final Listerner listerner;

    public Server(Listerner listerner){
        this.listerner = listerner;
        this.isServerWorking = false;
    }

    private void start(){
        if(isServerWorking) {
            listerner.messageReceived("Server is working");
            return;
        }
        isServerWorking = true;
        listerner.messageReceived("Server started");
    }

    private void stop(){
        if(!isServerWorking) {
            listerner.messageReceived("Server stopped");
            return;
        }
        listerner.messageReceived("Server has stopped");
        isServerWorking = false;
    }

    @Override
    public void serverListerner(boolean status) {
        if(status){
            start();
        } else {
            stop();
        }
    }
}
