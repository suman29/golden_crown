package com.tot;

import java.util.HashMap;

public class Universe {
    private HashMap<String, Kingdom> kingdoms;
    private String name;
    private Kingdom ruler;

    public Universe(HashMap<String, Kingdom> kingdoms, String name) {
        this.kingdoms = kingdoms;
        this.name = name;
        this.ruler = null;
    }

    public Kingdom findRuler() {

        for (Kingdom kingdom : kingdoms.values()) {
            if (kingdom.allies().size() >= 3) {
                this.ruler = kingdom;
            }
        }
        return this.ruler;
    }

    public String showRulerAllies() {
        if (this.ruler == null) {
            return "Allies of ruler is: " + ConsoleMessages.NONE;
        }
        return "Allies of ruler is: " + this.ruler.showAlliesName();
    }

    public String showRulerName() {
        if (this.ruler == null) {
            return "Ruler is: " + ConsoleMessages.NONE;
        }
        return "Ruler is: " + this.ruler.toString();
    }


    public void send(String sender, String receiver, String secretMsg) {
        Kingdom senderKingdom = kingdoms.get(sender);
        Kingdom receivingKingdom = kingdoms.get(receiver);
        Message message = new Message(senderKingdom, receivingKingdom, secretMsg);
        send(message);
    }

    public void send(Message message) {
        message.send();
    }

    public boolean isValidKingdom(String kingdomName) {
        return !(kingdoms.get(kingdomName) == null);
    }
}
