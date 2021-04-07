package com.ustudents.engine.network.net2.messages;

public class PackMessage extends Message {
    public PackMessage() {

    }

    public PackMessage(Integer numberOfParts) {
        getPayload().put("numberOfParts", numberOfParts);
    }

    public int getNumberOfParts() {
        return ((Long)getPayload().get("numberOfParts")).intValue();
    }
}