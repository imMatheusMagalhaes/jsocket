package services;

import utils.WriteFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(12345);

        System.out.println("Porta 12345 aberta!");

        Socket client = server.accept();

        WriteFile write = new WriteFile();

        System.out.println("Nova conexão com o cliente " + client.getInetAddress().getHostAddress());

        Scanner input = new Scanner(client.getInputStream());

        while (input.hasNextLine()) {
            String dir = input.nextLine();
            write.create(dir);
        }

        input.close();
        server.close();
    }
}
