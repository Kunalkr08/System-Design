package pubsub.subscriber;

import pubsub.entities.Message;

public interface Subscriber {
    String getId();
    void onMessage(Message message);
}
