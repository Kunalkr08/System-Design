package pubsub.subscriber;

import pubsub.entities.Message;

public class AlertSubscriber implements Subscriber {
    private final String id;

    public AlertSubscriber(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Alert Subscriber received message " + id + " " + message.getPayload());
    }
}
