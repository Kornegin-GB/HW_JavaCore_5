package ru.gb;

import java.io.File;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        DirectoryTrees.printTree(new File("."), "", true);
        Backup.searchFile(new File("."));
        CreateFile.saveData("Array.txt", CreateFile.createArray());
        CreateFile.readData("Array.txt");
    }
}
