package services;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket client = new Socket("127.0.0.1", 12345);

        System.out.println("O cliente se conectou ao servidor!");

        PrintStream output = new PrintStream(client.getOutputStream());

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            output.println(selectedFile.getAbsolutePath());
            System.out.println("Arquivo alterado");
        }
        output.close();
    }
}
