package com.tot;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class ConsoleInputOutputTest {

    @Test
    public void shouldPrintMessageAsGiven() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("This is input".getBytes());
        System.setIn(byteArrayInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ConsoleInputOutput input = new ConsoleInputOutput(bufferedReader);

        String actualInput = input.getUserInput();
        String expectedInput = "This is input";

        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void shouldHandleWhenNoInputIsGiven() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("".getBytes());
        System.setIn(byteArrayInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ConsoleInputOutput input = new ConsoleInputOutput(bufferedReader);

        String actualInput = input.getUserInput();
        String expectedInput = null;

        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void shouldPrintGivenMessage() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        ConsoleInputOutput output = new ConsoleInputOutput(bufferedReader);
        output.displayMessage("This is output");

        String actualOutput = outputStream.toString();
        String expectedOutput = "This is output" + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }
}