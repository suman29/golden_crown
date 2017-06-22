package com.tot.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class SecretMessagesFile {

    private String filePath;

    public SecretMessagesFile(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<String> getMessages() {
        ArrayList<String> msgs = new ArrayList<>();
        BufferedReader br = null;
        try {
            String currentMessage;
            br = new BufferedReader(new FileReader(filePath));

            while ((currentMessage = br.readLine()) != null) {
                msgs.add(currentMessage);
            }
        } catch (IOException exception) {
            exception.getStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return msgs;
    }

}