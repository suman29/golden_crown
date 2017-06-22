package com.tot;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KingdomTest {

    Kingdom land;
    Kingdom water;

    @Before
    public void setUp() {
        land = new Kingdom("Land", "Panda", "");
        water = new Kingdom("Water", "Octopus", "");
    }

    @Test
    public void testSendMessageWhenAllianceIsAccepted() throws Exception {
        water.receiveMessage(land, "I want octopus");
        assertEquals(1, land.allies().size());
        assertEquals(1, water.allies().size());
    }

    @Test
    public void testSendMessageWhenAllianceIsNotAccepted() throws Exception {
        water.receiveMessage(land, "I want Octo shdsk");
        assertEquals(0, land.allies().size());
        assertEquals(0, water.allies().size());
    }

    @Test
    public void testShowAllies() throws Exception {
        water.receiveMessage(land, "I want Octopus");
        String actualResult = water.showAlliesName();

        assertEquals("Land ", actualResult);
    }
}