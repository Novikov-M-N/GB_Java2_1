package com.geekbrains.java2.lesson7.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private MyServer myServer;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;

    public String getName() {
        return name;
    }

    public ClientHandler(MyServer myServer, Socket socket) {
        this.myServer = myServer;
        this.socket = socket;
        this.name = "";
        try {
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            new Thread(()-> {
                try {
                    authenticate();
                    readMessages();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException ex) {
            throw new RuntimeException("Client creation error");
        }
    }

    private void closeConnection() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        myServer.unsubscribe(this);
        myServer.broadcast("User " + name + " left");
    }

    private void readMessages() throws IOException {
        while (true) {
            if (in.available()>0) {
                String message = in.readUTF();
                System.out.println("From " + name + ":" + message);
                if (message.equals("/end")) {
                    return;
                }
                // Отправка клиентом приватного сообщения
                if (message.startsWith("/w")) {
                    // Разбиваем строку на части: команда на отправку приватного сообщения, кому отправляем и само сообщение
                    String[] parts = message.split("\\s");
                    // Проверяем формат сообщения: не пропущен ли пробел после /w,
                    // не начинается ли с этих символов какое-нибудь другое слово,
                    // все ли требуемые части сообщения на месте
                    if (parts[0].equals("/w") && parts.length >= 3){
                        String to = parts[1];
                        // Собираем обратно сообщение из отдельных слов, не забываем про пробелы
                        StringBuilder privateMessage = new StringBuilder();
                        for (int i = 2; i < parts.length; i++) {
                            privateMessage.append(parts[i]);
                            if (i < parts.length - 1) { privateMessage.append(" "); }
                        }
                        // Даём команду серверу на отправку приватного сообщения
                        myServer.sendPrivateMessage(this, to, privateMessage.toString());
                    // Если пользователь неправильно ввёл формат приватного сообщения, даём подсказку
                    } else { this.sendMsg("Format for private message: /w [recipient nick] [private message]"); }
                } else { myServer.broadcast(name + ": " + message); }
            }
        }
    }

    private void authenticate() throws IOException {
        while(true) {
            if (in.available()>0){
                String str = in.readUTF();
                if (str.startsWith("/auth")) {
                    String[] parts = str.split("\\s");
                    String nick = myServer.getAuthService().getNickByLoginAndPwd(parts[1], parts[2]);
                    if (nick != null) {
                        if (!myServer.isNickLogged(nick)) {
                            System.out.println(nick + " logged into chat");
                            name = nick;
                            sendMsg("/authOk " + nick);
                            myServer.broadcast(nick + " is in chat");
                            myServer.subscribe(this);
                            return;
                        } else {
                            System.out.println("User " + nick + " tried to re-enter");
                            sendMsg("User already logged in");
                        }
                    } else {
                        System.out.println("Wrong login/password");
                        sendMsg("Incorrect login attempted");
                    }
                }
            }

        }
    }

    public void sendMsg(String s) {
        try {
            out.writeUTF(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
