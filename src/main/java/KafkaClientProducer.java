import producer.runProducer;

public class KafkaClientProducer {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                new runProducer(5);
            } else {
                new runProducer(Integer.parseInt(args[0]));
            }
        } catch (Exception e) {
// TODO: handle exception
        }
    }
}
