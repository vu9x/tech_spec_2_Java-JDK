package org.example.chat.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ServerRun extends JFrame implements Listerner{
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    ServerListerner server;
    StringBuilder log;
    JButton btnStart = new JButton("Start Server");
    JButton btnStop = new JButton("Stop Server");


    ServerRun() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server manager");
        setResizable(false);

        server = new Server(this);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.serverListerner(true);
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.serverListerner(false);
            }
        });

        setLayout(new GridLayout(1,2));
        add(btnStart);
        add(btnStop);
        setVisible(true);
    }

    @Override
    public void messageReceived(String text) {
        System.out.println(text);
    }

//    private void putMessageToLog(String msg){
//        log.appedn
//    }

    public static void main(String[] args){
        new ServerRun();
    }
}
