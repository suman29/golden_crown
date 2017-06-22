package com.tot;

public class Message {
    private String msgCode;
    private Kingdom sender;
    private Kingdom receiver;

    Message(Kingdom sender, Kingdom receiver, String msgCode) {
        this.sender = sender;
        this.receiver = receiver;
        this.msgCode = msgCode;
    }

    public void send() {
        String msg = msgCode;
        this.receiver.receiveMessage(this.sender, msg);
    }
}
