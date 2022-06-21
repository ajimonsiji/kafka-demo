# kafka-demo

Kafka Setup
docker run --name kafka0 --hostname kafka0 -p 9092:9092 -p 8081:8081 -p 2181:2181 -p 9999:9999 -i -t --privileged --network spark-net -v /Users/aijmonsiji/Documents/Docker:/opt centos:7 /usr/sbin/init


jdk-8u202-linux-arm64-vfp-hflt.tar.gz



https://archive.apache.org/dist/zookeeper/zookeeper-3.6.1/ 
zookeeper archives


Kafka: https://archive.apache.org/dist/kafka/3.1.0/kafka_2.13-3.1.0.tgz

telnet localhost 2181

tar -xvf apache-zookeeper-3.6.1-bin.tar -C /opt 
mv a*zookeeper-3.6.1* /opt/zookeeper 
mkdir -p /opt/data/zookeeper Create a zookeeper configuration file and update with the following values. 
vi /opt/zookeeper/conf/zoo.cfg 
	tickTime=2000 
	dataDir=/opt/data/zookeeper 
	clientPort=2181 
	Update the zoo.cfg with the above entries.
 You can save the file using esc+wq! Start the zookeeper using the following scripts. 
 /opt/zookeeper/bin/zkServer.sh start


 tar -zxf kafka_2.12-*–C /opt 
 mv kafka_2.1* /opt/kafka 
 mkdir /opt/data/kafka-logs

/opt/kafka/bin/kafka-server-start.sh -daemon /opt/kafka/config/server.properties


dnf --disablerepo '*' --enablerepo=extras swap centos-linux-repos centos-stream-repos

dnf --disablerepo '*' --enablerepo=extras swap centos-linux-repos centos-stream-repos
yum install ncurses


/opt/kafka/bin/kafka-run-class.sh kafka.tools.DumpLogSegments --deep-iteration --printdata-log --files datadir/000000.log


./kafka-topics.sh --create --bootstrap-server localhost:9092 --topic test --replication-factor 1 --partitions 3

./kafka-console-producer.sh --broker-list localhost:9092 --topic test

./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning


curl -X POST -H "Content-Type: application/vnd.schemaregistry.v1+json" --data '{"schema": "{\"type\":\"record\",\"name\":\"Payment\",\"namespace\":\"com.tos\",\"fields\":[{\"name\":\"id\",\"t ype\":\"string\"},{\"name\":\"amount\",\"type\":\"double\"}]}"}' http://localhost:8081/subjects/mykafka-value/versions




Kafka Java API

Simple 
