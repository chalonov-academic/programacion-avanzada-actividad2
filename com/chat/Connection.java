package com.chat;

import java.io.*;
import java.net.*;
import java.util.Objects;

public class Connection {
    final int port = 1234;
    final String host = "localhost";
    protected Socket socketCliente;
    protected ServerSocket socketServidor;
    protected BufferedReader in = null;
    protected PrintWriter out = null;
    protected BufferedReader input = null;
    protected String clientMessage;
    protected String serverMessage;
    private String tipo;
    protected String mensaje;
    final String EXIT_COMMAND = "salir()";

    public Connection(String tipo) throws IOException {
        this.tipo = tipo;
        if (Objects.equals(tipo, "servidor")) {
            socketServidor = new ServerSocket(port);
            socketCliente = new Socket();
        } else {
            socketCliente = new Socket(host, port);
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void runUser(){}

    public void runConnection(){}

    public void openConnection() {
        try {
            in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            out = new PrintWriter(socketCliente.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            System.out.println("Error en la apertura de la conexión");
        }
    }

    public void exchangeMessages() {}

    public void closeConnection() {
        try {
            if (Objects.equals(tipo, "servidor")) {
                System.out.println("Conexión cerrada --> " + getTipo());
                socketServidor.close();
                socketCliente.close();
            } else {
                System.out.println("Conexión cerrada --> " + getTipo());
                socketCliente.close();
            }
        } catch (Exception e) {
            System.out.println("Excepción de cerrar conexión: " + e.getMessage());
            System.exit(0);
        }
    }
}
