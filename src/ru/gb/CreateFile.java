package ru.gb;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

//https://stackabuse.com/bytes/java-convert-int-to-a-byte/
public class CreateFile {
    /**
     * Побитовое сохранение массива чисел в файл
     * 
     * @param array сохраняемый массив
     * @throws IOException Ошибка записи данных в файл
     */
    public static void saveData(String fileNameOut, int[] array) throws IOException {
        try (FileOutputStream out = new FileOutputStream(fileNameOut)) {
            for (int b = 0; b < 3; b++) { // запись в 3 байта
                byte by = 0;
                for (int v = 0; v < 3; v++) { // write by 3 values in each
                    by += (byte) (array[3 * b + v] << (v * 2));
                }
                out.write(by);
            }
        }
    }

    /**
     * Прочитать числа из файла, полученного в результате побитового сохранения
     * 
     * @throws IOException Ошибка чтения данных из файла
     */
    public static void readData(String fileNameIn) throws IOException {
        int[] ar20 = new int[9];
        FileInputStream in = new FileInputStream(fileNameIn);
        int b;
        int i = 0;
        while ((b = in.read()) != -1) {
            for (int v = 0; v < 3; ++v) { // 3 values of four possible
                ar20[i++] = b >> (v * 2) & 0x3;
            }
        }
        in.close();
        System.out.println(Arrays.toString(ar20));
    }

    public static int[] createArray() {
        int[] array = new int[9];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(4);
        }
        return array;
    }
}
