package com.tot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EntryTest {

    @Mock
    Universe universe;

    @Mock
    ConsoleInputOutput console;

    Entry enterGame;

    @Test
    public void shouldTakeUserInputAndRespondAccordingly() {
        when(console.getUserInput())
                .thenReturn("y")
                .thenReturn("air|land|msg");
        when(universe.isValidKingdom("air")).thenReturn(true);
        when(universe.isValidKingdom("land")).thenReturn(true);
        enterGame = new Entry(console, universe);

        enterGame.start();

        verify(universe).findRuler();
        verify(universe).showRulerName();
        verify(universe).showRulerAllies();
        Mockito.verify(universe).send("air", "land", "msg");
    }

}