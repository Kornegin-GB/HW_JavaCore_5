package ru.gb;

import java.io.File;

public class Program {
    public static void main(String[] args) {
        DirectoryTrees.printTree(new File("."), "", true);
    }
}
