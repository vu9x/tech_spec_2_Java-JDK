package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Создать окно клиента чата. Окно должно содержать
JtextField для ввода логина, пароля, IP-адреса сервера,
порта подключения к серверу, область ввода сообщений,
JTextArea область просмотра сообщений чата и JButton подключения
к серверу и отправки сообщения в чат. Желательно сразу
сгруппировать компоненты, относящиеся к серверу сгруппировать
на JPanel сверху экрана, а компоненты, относящиеся к отправке
сообщения – на JPanel снизу
 */
public class Chat extends JFrame{
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JButton btnSend = new JButton("Send");
    JLabel lblLogin = new JLabel("Login: ");
    JLabel lblPassword = new JLabel("Password: ");
    JLabel lblIP = new JLabel("IP: ");
    JLabel lblMessage = new JLabel("Message: ");
    JTextField txtFieldLogin = new JTextField();
    JTextField txtFieldPassword = new JTextField();
    JTextField txtFieldIP = new JTextField();
    JTextField txtFieldMessage = new JTextField();
    JTextArea areaMessage = new JTextArea();
    JPanel panServer = new JPanel(new GridLayout(6,2));
    JPanel panClient = new JPanel(new GridLayout(4,2));
    String login;
    String pass;
    String IP;
    String message;
    Chat(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server manager");
        setResizable(false);
        panServer.add(lblLogin);
        panServer.add(txtFieldLogin);
        panServer.add(lblPassword);
        panServer.add(txtFieldPassword);
        panServer.add(lblIP);
        panServer.add(txtFieldIP);
        panClient.add(lblMessage);
        panClient.add(areaMessage);
        panClient.add(txtFieldMessage);
        panClient.add(btnSend);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message = txtFieldLogin.getText() + ": " + txtFieldMessage.getText() + "\n";
                areaMessage.append(message);
                System.out.println("Message has sent: " + message);
            }
        });

        setLayout(new GridLayout(2,1));
        add(panServer);
        add(panClient);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Chat();
    }
}
