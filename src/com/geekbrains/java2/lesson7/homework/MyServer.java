package com.geekbrains.java2.lesson7.homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {
    private final int PORT = 8189;
    private List<ClientHandler> clients;
    private AuthService authService;

    public AuthService getAuthService() {
        return authService;
    }

    public MyServer() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            authService = new AuthService();
            authService.start();
            clients = new ArrayList<>();
            while (true) {
                System.out.println("Server awaits clients");
                Socket socket = server.accept();
                System.out.println("Client connected");
                new ClientHandler(this, socket);
            }
        } catch (IOException ex) {
            System.out.println("Server error");
        } finally {
            if(authService!=null) {
                authService.stop();
            }
        }
    }


    public synchronized void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public synchronized void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public synchronized void broadcast(String s) {
        for(ClientHandler client: clients) {
            client.sendMsg(s);
        }
    }

    /**
     * Отправка приватного сообщения одному клиенту. Адресация получателя по никнейму.
     * Если клиента с таким никнеймом не существует, сообщаем об этом отправителю
     * @param from от кого отправляем сообщение
     * @param to никнейм клиента, которому отправляем сообщение
     * @param message отправляемое сообщение
     */
    public void sendPrivateMessage(ClientHandler from, String to, String message) {
        ClientHandler recipient = findClientFromNick(to);
        if (recipient != null) {
            recipient.sendMsg("Private from " + from.getName() + ": " + message);
            from.sendMsg("Private to " + to + ": " + message);
        }
        else { from.sendMsg("User " + to + " does not exist"); }
    }

    /**
     * Поиск клиента по его никнейму
     * @param requestNick никнейм искомого клиента
     * @return ссылка на клиента, если таковой найден, либо null, если клиента с запрашиваемым никнеймом нет в списке
     */
    private synchronized ClientHandler findClientFromNick(String requestNick) {
        for (ClientHandler client:clients) {
            if (client.getName().equals(requestNick)) { return client; }
        }
        return null;
    }

    public synchronized boolean isNickLogged(String nick) {
        for(ClientHandler client: clients) {
            if (client.getName().equals(nick)) {
                return true;
            }
        }
        return false;
    }

}
