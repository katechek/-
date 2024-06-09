package org.example;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class Calculator {
    public static void main( String[] args ) throws IOException {
        program("file.txt");
    }

    public static void program(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<Integer> l = new ArrayList<>();
            String line = reader.readLine();
            if (line.length() == 0){
                throw new NumberFormatException("Ошибка");
            } else {
                String[] str = line.split(" ");
                int s = str.length;
                for (String numberString : str) {
                    l.add(Integer.parseInt(numberString));
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
