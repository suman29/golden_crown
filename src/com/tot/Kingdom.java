package com.tot;

import java.util.HashSet;
import java.util.Set;

public class Kingdom {
    private String name;
    private String king;
    private String emblem;
    private Set<Kingdom> allies;


    public Kingdom(String name, String emblem, String king) {
        this.name = name;
        this.emblem = emblem;
        this.king = king;
        this.allies = new HashSet<Kingdom>();
    }

    public void receiveMessage(Kingdom kingdom, String msgCode) {
        if (this.approveAlliance(msgCode) && kingdom != this) {
            this.addAlliance(kingdom);
            kingdom.addAlliance(this);
        }
    }

    public void addAlliance(Kingdom kingdom) {
        this.allies.add(kingdom);
    }


    public String showAlliesName() {
        String allies = "";
        for (Kingdom kingdom : this.allies) {
            allies = allies + kingdom.name + " ";
        }
        return allies;
    }

    public Set<Kingdom> allies() {
        return this.allies;
    }

    private boolean approveAlliance(String message) {
        return containsEmblem(message);
    }

    private boolean containsEmblem(String message) {
        Set<Character> msgCodeSet = createHashSet(message.toLowerCase());
        Set<Character> emblemSet = createHashSet(this.emblem.toLowerCase());

        return msgCodeSet.containsAll(emblemSet);
    }

    private Set<Character> createHashSet(String msg) {
        Set<Character> set = new HashSet<>();
        for (char c : msg.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    public String toString() {
        return this.name;
    }

}
