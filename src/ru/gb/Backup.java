package ru.gb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Backup {
    private static final String BACKUP_DIRECTORY = "./backup";

    public static void searchFile(File file) throws IOException {
        File directory = new File(BACKUP_DIRECTORY);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (directory.mkdir()) {
                System.out.println("Create directory");
            }
            if (files[i].isFile()) {
                String nameFile = files[i].getName();
                String backupFile = BACKUP_DIRECTORY + "/" + nameFile;
                concatenate(nameFile, backupFile);
            }
        }
    }

    private static void concatenate(String fileIn, String fileOut) throws IOException {
        // На запись
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileOut)) {
            int c;
            // На чтение
            try (FileInputStream fileInputStream = new FileInputStream(fileIn)) {
                while ((c = fileInputStream.read()) != -1) {
                    fileOutputStream.write(c);
                }
            }
        }
    }
}
