import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ManagedQueueService<T> {
    private final Map<String, List<T>> topics;

    public ManagedQueueService() {
        this.topics = new HashMap<>();
    }

    //the methods below can be the service implementation of apis as per the requirements

    public synchronized void addData(String topic, T data) {
        List<T> topicQueue = topics.computeIfAbsent(topic, t -> new LinkedList<>());
        topicQueue.add(data);
    }

    public synchronized void subscribe(String topic) {
        topics.putIfAbsent(topic, new LinkedList<>());
    }


    public synchronized Iterable<String> listTopics() {
        return topics.keySet();
    }

    public synchronized Iterable<T> retrieveData(String topic) {
        return topics.get(topic);
    }
}
