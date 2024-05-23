package com.chat;

import java.io.IOException;

public class Client extends Connection {

    public Client() throws IOException {
        super("cliente");
    }

    public void runClient() {
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
            System.out.println("El cliente está conectado, escriba 'salir()' para cerrar el chat");
        } catch (Exception e) {
            System.out.println("Excepción de conexión: " + e.getMessage());
            System.exit(0);
        }
    }

    public void exchangeMessages() {
        try {
            while (true) {
                serverMessage = in.readLine().replace("¬", "\n");
                System.out.println(serverMessage);

                System.out.print("Cliente: ");
                clientMessage = input.readLine();
                out.println(clientMessage);

                if (clientMessage.equals(EXIT_COMMAND)) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Excepción de conexión: " + e.getMessage());
            System.exit(0);
        }
    }
}
