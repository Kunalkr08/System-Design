package pubsub;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import pubsub.entities.Message;
import pubsub.entities.Topic;
import pubsub.subscriber.Subscriber;

public class PubSubService {
    private final ExecutorService deliveryExecutor;
    private final Map<String, Topic> topicRegistry;
    private static volatile PubSubService INSTANCE;

    private PubSubService() {
        this.topicRegistry = new ConcurrentHashMap<>();
        this.deliveryExecutor = Executors.newCachedThreadPool();
    }

    public static PubSubService getInstance() {
        if (INSTANCE == null) {
            synchronized (PubSubService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PubSubService();
                }
            }
        }
        return INSTANCE;
    }
    
    public void createTopic(String topicName) {
       topicRegistry.putIfAbsent(topicName, new Topic(topicName, deliveryExecutor));
       System.out.println("Topic " + topicName + " created");
    }

    public void subscribe(String topicName, Subscriber subscriber) {
        Topic topic = topicRegistry.get(topicName);

        if(topic == null) throw new IllegalArgumentException("Topic not found: " + topicName);
        topic.addSubscriber(subscriber);
        System.out.println("Subscriber '" + subscriber.getId() + "' subscribed to topic: " + topicName);
    }

    public void unsubscribe(String topicName, Subscriber subscriber) {
        Topic topic = topicRegistry.get(topicName);
        if (topic != null) topic.removeSubscriber(subscriber);
        System.out.println("Subscriber '" + subscriber.getId() + "' unsubscribed from topic: " + topicName);
    }

    public void publish(String topicName, Message message) {
        System.out.println("Publishing message to topic: " + topicName);
        Topic topic = topicRegistry.get(topicName);
        if (topic == null) throw new IllegalArgumentException("Topic not found: " + topicName);
        topic.broadcast(message);
    }

    public void shutdown() {
        System.out.println("PubSubService shutting down...");
        deliveryExecutor.shutdown();
        try {
            // Wait a reasonable time for existing tasks to complete
            if (!deliveryExecutor.awaitTermination(60, TimeUnit.SECONDS)) {
                deliveryExecutor.shutdownNow();
            }
        } catch (InterruptedException ie) {
            deliveryExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("PubSubService shutdown complete.");
    }
}
