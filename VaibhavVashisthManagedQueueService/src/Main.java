public class Main {
    public static void main(String[] args) {
        ManagedQueueService<Integer> queueService = new ManagedQueueService<>();
        queueService.addData("this is topic1", 100);
        queueService.addData("this is topic1", 67);
        queueService.addData("this is topic2", 99);

        queueService.


                subscribe("this is topic1");
        queueService.subscribe("this is topic2");

        System.out.println("Available topics: " + String.join(", ", queueService.listTopics()));

        for (String topic : queueService.listTopics()) {
            System.out.println("Data in topic " + topic + ":");
            for (Integer data : queueService.retrieveData(topic)) {
                System.out.println(data);
            }
        }
    }
}
