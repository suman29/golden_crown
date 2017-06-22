package com.tot;

import java.io.BufferedReader;

public class ConsoleInputOutput {
    BufferedReader bufferedReader;

    public ConsoleInputOutput(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String getUserInput() {
        try {
            String input = (bufferedReader.readLine());
            return input;

        } catch (Exception e) {
            return "";
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

}
