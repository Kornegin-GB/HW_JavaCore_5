package ru.gb;

import java.io.File;

/*
'└' -- 9492
'├' -- 9500
'─' -- 9472
'│' -- 9474
 */

public class DirectoryTrees {
    /**
     * Вывод дерева дирректорий и файлов
     * 
     * @param file   имя файла или директории
     * @param indent отступ
     * @param isLast является ли текущий файл или дерриктория
     */
    public static void printTree(File file, String indent, boolean isLast) {
        System.out.print(indent); // рисуем отступ
        if (isLast) {
            System.out.print("" + (char) 9492 + (char) 9472);
            indent += "  ";
        } else {
            System.out.print("" + (char) 9500 + (char) 9472);
            indent += "" + (char) 9474 + " ";
        }
        System.out.println(file.getName());
        File[] files = file.listFiles();
        if (files == null) { return; }
        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                printTree(files[i], indent, subDirCounter == files.length - 1);
                subDirCounter++;
            }
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                printTree(files[i], indent, subDirCounter == files.length - 1);
                subDirCounter++;
            }
        }
    }
}
