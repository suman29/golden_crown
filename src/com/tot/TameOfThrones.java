package com.tot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TameOfThrones {

    public static void main(String[] args) {
        Kingdom landKingdom = new Kingdom("land", "panda", "");
        Kingdom waterKingdom = new Kingdom("water", "octopus", "");
        Kingdom iceKingdom = new Kingdom("ice", "mammoth", "");
        Kingdom airKingdom = new Kingdom("air", "owl", "");
        Kingdom fireKingdom = new Kingdom("fire", "dragon", "");

        HashMap<String, Kingdom> kingdomNamesMap = new HashMap<>();
        kingdomNamesMap.put("land", landKingdom);
        kingdomNamesMap.put("water", waterKingdom);
        kingdomNamesMap.put("ice", iceKingdom);
        kingdomNamesMap.put("air", airKingdom);
        kingdomNamesMap.put("fire", fireKingdom);

        Universe universe = new Universe(kingdomNamesMap, "Southeros");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ConsoleInputOutput console = new ConsoleInputOutput(bufferedReader);
        Entry enterGame = new Entry(console, universe);
        enterGame.start();
    }
}
