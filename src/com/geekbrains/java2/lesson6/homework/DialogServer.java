package com.geekbrains.java2.lesson6.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class DialogServer {
    private static boolean isConnected = false; // Флаг проверки, не разорвано ли соединение

    /**
     * Обработка входящего потока
     * @param socket сокет обмена данными с удалённой машиной. От него создаются входящий и исходящий потоки
     */
    private static void read(Socket socket) {
        try {
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            String inputString;
            while (isConnected) {
                inputString = inputStream.readUTF();
                System.out.println(inputString);
                // Если получем от удалённой машины запрос на разрыв соединения, ставим в false флаг isConnected
                // и отправляем другой стороне подтверждение на разрыв соединения
                if (inputString.equalsIgnoreCase("/end")) {
                    System.out.println("Соединение отключено");
                    isConnected = false;
                    outputStream.writeUTF("/end");
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Отправка сообщений удалённой стороне
     * @param socket сокет обмена данными с удалённой машиной. От него создаётся исходящий поток
     */
    private static void write(Socket socket) {
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            String outputString;
            while (true) {
                outputString = consoleReader.readLine();
                // Если соединение разорвано, то при попытке отправки возникнет ошибка. Поэтому проверяем.
                if (isConnected) { outputStream.writeUTF(outputString); }
                if (!isConnected || outputString.equalsIgnoreCase("/end")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен. Ожидание подключения...");
            Socket socket = serverSocket.accept();
            isConnected = true;
            System.out.println("Клиент подключен");
            // Чтение и отправку сообщений делаем в параллельных потоках, чтобы связь работала в дуплексном режиме
            new Thread(() -> write(socket)).start();
            read(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
