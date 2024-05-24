package org.example;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main( String[] args ) throws IOException {
        program("file.txt");
    }

    public static void program(String fileName) throws IOException {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            List<Integer> l = new ArrayList<>();
            if (!scanner.hasNextInt()){
                throw new NumberFormatException("Ошибка");
            } else {
                while (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    l.add(number);
                }
                System.out.println("Сумма: " + sum(l));
                System.out.println("Минимум: " + min(l));
                System.out.println("Максимум: " + max(l));
                System.out.println("Произведение: " + mult(l));
            }

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ошибка в формате");
        } catch (IOException ex) {
            throw new IOException("Файл не найден");
        }
    }
    public static BigInteger max(List<Integer> arr) {
        BigInteger res = BigInteger.valueOf(Integer.MIN_VALUE);
        for (int i = 0; i < arr.size(); i++) {
            BigInteger c = BigInteger.valueOf(arr.get(i));
            if (c.compareTo(res) > 0) {
                res = c;
            }
        }
        return res;
    }

    public static BigInteger min(List<Integer> arr) {
        BigInteger res = BigInteger.valueOf(Integer.MAX_VALUE);
        for (int i = 0; i < arr.size(); i++) {
            BigInteger c = BigInteger.valueOf(arr.get(i));
            if (c.compareTo(res) < 0) {
                res = c;
            }
        }
        return res;
    }

    public static BigInteger sum(List<Integer> arr) {
        BigInteger res = BigInteger.valueOf(0);
        for (int i = 0; i < arr.size(); i++) {
            res = res.add(BigInteger.valueOf(arr.get(i)));
        }
        return res;
    }

    public static BigInteger mult(List<Integer> arr) {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 0; i < arr.size(); i++) {
            res = res.multiply(BigInteger.valueOf(arr.get(i)));
        }
        return res;
    }




}
