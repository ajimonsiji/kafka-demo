package producer;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class runProducer {
    String TOPIC="kafka-java-topic-new";

    public runProducer(final int sendMessageCount) throws Exception
    {
        System.out.println("Running Producer");
        Producer<Long,String> producer= (Producer<Long, String>) new createProducer().createProducer();
        System.out.println(producer);
        long time = System.currentTimeMillis();
        try {
            for (long index = time; index < time + sendMessageCount; index++) {
                System.out.println("Sending records to topic : " + TOPIC);
                final ProducerRecord<Long, String> record = new ProducerRecord<>(TOPIC, index, "Hello Kafka " + index);
                RecordMetadata metadata = producer.send(record).get();
                long elapsedTime = System.currentTimeMillis() - time;
                System.out.printf("Sent record(key=%s value=%s) " +
                                "meta(partition=%d, offset=%d) time=%d\n",
                        record.key(), record.value(), metadata.partition(),
                        metadata.offset(), elapsedTime);
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        } finally {
            producer.flush();
            producer.close();
        }
    }

}
