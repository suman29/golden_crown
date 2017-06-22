package com.tot;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class UniverseTest {

    HashMap<String, Kingdom> kingdomNamesMap;
    Universe universe;

    Kingdom land = new Kingdom("Land", "Panda", "");
    Kingdom water = new Kingdom("Water", "Octopus", "");
    Kingdom ice = new Kingdom("Ice", "Mammoth", "");
    Kingdom air = new Kingdom("Air", "Owl", "");
    Kingdom fire = new Kingdom("Fire", "Dragon", "");

    @Before
    public void setUp() throws Exception {
        kingdomNamesMap = new HashMap<>();
        kingdomNamesMap.put("Land", land);
        kingdomNamesMap.put("Water", water);
        kingdomNamesMap.put("Ice", ice);
        kingdomNamesMap.put("Air", air);
        kingdomNamesMap.put("Fire", fire);
        universe = new Universe(kingdomNamesMap, "");
    }

    @Test
    public void shouldBeAbleToDecideRulerWhenNoMessageIsSent() {
        Kingdom ruler = universe.findRuler();
        String allies = universe.showRulerAllies();
        assertNull(ruler);
        assertEquals("Allies of ruler is: None", allies);
    }

    @Test
    public void shouldBeAbleToDecideRulerWhenSendsMsgToAll() {
        Message msg1 = new Message(fire, air, "oaaawaala");
        Message msg2 = new Message(fire, ice, "zmzmzmzaztzozh");
        Message msg3 = new Message(fire, land, "a1d22n333a4444p");
        Message msg4 = new Message(fire, air, "oaaadsfdfwaala");

        universe.send(msg1);
        universe.send(msg2);
        universe.send(msg3);
        universe.send(msg4);

        Kingdom ruler = universe.findRuler();

        assertEquals(ruler, fire);
        assertEquals(ruler.allies().size(), 3);
    }

    @Test
    public void shouldBeAbleToDecideRulerWhenMultipleRulerTriesToFormAllies() {
        universe.send(new Message(land, air, "Let’s swing the sword together"));
        universe.send(new Message(land, land, "Die or play the tame of thrones"));
        universe.send(new Message(land, ice, "Ahoy! Fight for me with men and money"));
        universe.send(new Message(land, water, "Summer is coming"));
        universe.send("Land", "Water", "Summer is coming");
        universe.send(new Message(land, fire, "Drag on Martin!"));

        Kingdom ruler = universe.findRuler();
        assertEquals(land, ruler);
        assertEquals(ruler.allies().size(), 3);
        assertEquals(universe.showRulerName(), "Ruler is: Land");
    }

    @Test
    public void shouldBeAbleToValidateKingdom() {
        assertFalse(universe.isValidKingdom("l"));
        assertTrue(universe.isValidKingdom("Land"));
    }
}