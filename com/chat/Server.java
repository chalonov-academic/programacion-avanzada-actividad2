package com.chat;

import java.io.IOException;

public class Server extends Connection {

    public Server() throws IOException {
        super("servidor");
    }

    public void runServer() {
        runUser();
    }

    // Overload methods
    public void runUser() {
        try {
            runConnection();
            openConnection();
            exchangeMessages();
            closeConnection();
        } catch (Exception e) {
            System.out.println("Excepción de conexión: " + e.getMessage());
            System.exit(0);
        }
    }

    public void runConnection() {
        try {
            System.out.println("El servidor está conectado...esperando conectar con el cliente");
            socketCliente = socketServidor.accept();
            System.out.println("Se conectó un cliente");
        } catch (Exception e) {
            System.out.println("Excepción de conexión: " + e.getMessage());
            System.exit(0);
        }
    }

    public void exchangeMessages() {
        try {
            while (true) {
                clientMessage = in.readLine();
                System.out.println("Cliente: " + clientMessage);

                if (clientMessage.equals(EXIT_COMMAND)) {
                    break;
                }
                System.out.print("Servidor: ");
                //serverMessage = input.readLine();
                serverMessage = "Mensaje recibido es:" + clientMessage;
                System.out.println(serverMessage);
                out.println(serverMessage);
            }
        } catch (Exception e) {
            System.out.println("Excepción de conexión: " + e.getMessage());
            System.exit(0);
        }
    }

    public String exchangeMessagesMod(String serverMessage) {
        try {
            System.out.print(serverMessage.replace("¬", "\n"));
            out.println(serverMessage);
            out.flush();

            clientMessage = in.readLine();
            System.out.println(clientMessage);

        } catch (Exception e) {
            System.out.println("Excepción de conexión: " + e.getMessage());
            System.exit(0);
        }
        return clientMessage;
    }
}
