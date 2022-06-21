package producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class createProducer {

    public Producer<Long, String> createProducer() {
        System.out.println("Creating producer");
        String bootStrapServer = "kafka0:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootStrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,LongSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.CLIENT_ID_CONFIG,"KafkaProducer");
        properties.setProperty(ProducerConfig.ACKS_CONFIG,"all");
        return new KafkaProducer<Long, String>(properties);
    }

}
