package org.example;

import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.util.concurrent.TimeUnit;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;



import static junit.framework.TestCase.assertEquals;
import static org.example.Calculator.program;
import static org.junit.Assert.*;


public class CalculatorTest {
    private List<Integer> all = new ArrayList<>();

    @Before
    @Test
    public void programExceptionFormat() throws NumberFormatException {
        Throwable thrown = assertThrows(NumberFormatException.class, () -> {
            program("fileWrongFormat.txt");
        });
        assertNotNull(thrown.getMessage());

    }

    @Before
    @Test
    public void programExceptionWrongFileName() throws IOException {
        Throwable thrown = assertThrows(IOException.class, () -> {
            program("wrongName.txt");
        });
        assertNotNull(thrown.getMessage());

    }

    @Test
    public void TimeLimitProgram() throws IOException {
        long a = System.nanoTime();
        program("file.txt");
        long b = System.nanoTime();
        assertTrue((b - a) < 15000000);
    }

    @Test
    public void durationTimeDifferenceTest(){
        all.add(1);
        all.add(2);
        all.add(3);

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            arr.add(i);
        }


        long a = System.nanoTime();
        Calculator.min(all);
        long b = System.nanoTime();
        Calculator.min(arr);
        long c = System.nanoTime();
        System.out.println("Время работы функции min() c 3 элементами: " + (b - a) + ", с 1000 элементами: " + (c - b));

        a = System.nanoTime();
        Calculator.max(all);
        b = System.nanoTime();
        Calculator.max(arr);
        c = System.nanoTime();
        System.out.println("Время работы функции max() c 3 элементами: " + (b - a) + ", с 1000 элементами: " + (c - b));

        a = System.nanoTime();
        Calculator.sum(all);
        b = System.nanoTime();
        Calculator.sum(arr);
        c = System.nanoTime();
        System.out.println("Время работы функции sum() c 3 элементами: " + (b - a) + ", с 1000 элементами: " + (c - b));

        a = System.nanoTime();
        Calculator.mult(all);
        b = System.nanoTime();
        Calculator.mult(arr);
        c = System.nanoTime();
        System.out.println("Время работы функции mult() c 3 элементами: " + (b - a) + ", с 1000 элементами: " + (c - b));


    }

    @Test
    public void minTest(){
        all.add(1);
        all.add(2);
        all.add(3);
        BigInteger realResult = Calculator.min(all);
        assertEquals(BigInteger.valueOf(1), realResult);

    }

    @Test
    public void maxTest(){
        all.add(3);
        all.add(9);
        all.add(15);

        BigInteger realResult = Calculator.max(all);

        assertEquals(BigInteger.valueOf(15), realResult);

    }

    @Test
    public void sumTest(){
        all.add(1);
        all.add(2);
        all.add(3);

        BigInteger realResult = Calculator.sum(all);

        assertEquals(BigInteger.valueOf(6), realResult);

    }

    @Test
    public void multTest(){
        all.add(4);
        all.add(2);
        all.add(3);

        BigInteger realResult = Calculator.mult(all);

        assertEquals(BigInteger.valueOf(24), realResult);

    }

}
