package org.example;


import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    private static String MY_NAME;

    @Before
    public void before() {
        MY_NAME = "Sviatoslav";
    }

    @After
    public void after() {
        MY_NAME = "";
    }

    @Test
    public void mainTest() {
        Student student = new Student(1, "John");
        assertEquals("John", student.getName());
        assertEquals("Sviatoslav", MY_NAME);
    }

    @Test(expected = NullPointerException.class)
    public void test1() {
        throw new NullPointerException("");
    }

    @Ignore
    @Test(timeout = 1000)
    public void infinity() {
        while (true);
    }
}