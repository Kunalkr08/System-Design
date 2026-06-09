package pubsub.entities;

import java.sql.Timestamp;

public class Message {
    private final String payload;
    private final Timestamp publishedTime;

    public Message(String payload) {
        this.payload = payload;
        this.publishedTime = new Timestamp(System.currentTimeMillis());
    }

    public String getPayload() {
        return payload;
    } 

    public void printPublishedTime() {
        System.out.println("Current message was published at" + publishedTime);
    }
}
