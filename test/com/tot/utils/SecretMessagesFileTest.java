package com.tot.utils;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class SecretMessagesFileTest {

    @Test
    public void checkIfBooksAreBeingReadFromFile() {
        String filePath = System.getProperty("User.dir") + File.separator + "Msgs.txt";
        SecretMessagesFile msgReader = new SecretMessagesFile(filePath);
        ArrayList<String> msgs = msgReader.getMessages();

        assertThat(msgs, is(notNullValue()));
    }
}