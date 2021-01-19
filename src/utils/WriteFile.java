package utils;

import java.io.*;

public class WriteFile {
    public void create (String dir) {
        try {
            FileReader archiveReader = new FileReader(dir);
            BufferedReader writeArq = new BufferedReader(archiveReader);

            FileWriter archiveWriter = new FileWriter("./recebido.txt");
            PrintWriter printArq = new PrintWriter(archiveWriter);

            String line = writeArq.readLine();
            while (line != null) {
                printArq.printf("%s\n", line);
                line = writeArq.readLine();
            }

            archiveReader.close();
            archiveWriter.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        System.out.println();
    }
}
