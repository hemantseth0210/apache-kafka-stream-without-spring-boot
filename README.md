# apache-kafka-stream-without-spring-boot

### Start Zookeeper
  - Open a command prompt and start the Zookeeper
    - .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
    
### Start Kafka
  - Open a new command prompt and start the Apache Kafka
    - .\bin\windows\kafka-server-start.bat .\config\server.properties
    
### Create Topic
  - Open a new command prompt and create two topics , that has only one partition & one replica
    - .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic kafka-streams-input-topic
     - .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic kafka-streams-output-topic

### Start Projects
  - Start mykafka-producer project
  - Start mykafka-processor project
  - Start mykafka-consumer project
  
### Send the message through Postman
  - Send the message to the topic through using the end point GET http://localhost:8080/sendMessages/Welcome to Apache Kafka

### Check the console of consumer
  - Console should display the word counts
  
