https://kafka.apache.org/downloads

----------------------------------------------------------------------------------------------

zookeeper-server-start.bat D:/Software/kafka_2.13-3.2.3/config/zookeeper.properties
 (2181)

kafka-server-start.bat D:/Software/kafka_2.13-3.2.3/config/server.properties
(9092)

----------------------------------------------------------------------------------------------
craeting a topic(with or without bat working)
kafka-topics.bat --create --topic uploadsheettopic --bootstrap-server localhost:9092

publish meassages to uploadsheettopic
kafka-console-producer.bat --topic uploadsheettopic --bootstrap-server localhost:9092

consume meaasges from uploadsheettopic (expected the msgs whatever produced in uploadsheet topic all are need to be consume)
kafka-console-consumer.bat --topic uploadsheettopic --from-beginning --bootstrap-server localhost:9092


get the list of all topics
kafka-topics.bat --list --bootstrap-server localhost:9092

..........................................................................................
creating a topic with replication factor(replication factor always 1 only 1 broker is available --replication-factor 1 ---if we are not give repli. no issue it will take
by default 1 broker--if we mention replication factor always 1 only 1 broker is available see belo) )
kafka-topics.bat --create --topic OrderTopic --bootstrap-server localhost:9092 --replication-factor 1

craeting a topic with partition (--partitions 3)..it means inside kafka it will create 3 topics UserTopic-0,UserTopic-1,
UserTopic-2(if not give partition by default it will create UserTopic-0))
kafka-topics.bat --create --topic UserTopic --bootstrap-server localhost:9092 --partitions 5

note:replication-factor(broker) and partition are not dependent any one we can use or ignore both also it will work.

delete an existing topic(not working)
kafka-topics --delete --topic topic123 --bootstrap-server localhost:9092
....................................

Note: if we have 1 producer and more consumer it require to take a topic with more partition or else by default it will take one partition.
(need to take kafka-topics.bat --create --topic UserTopic --bootstrap-server localhost:9092 --partitions 3)

------------------------------------
