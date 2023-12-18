# Spring Boot Microservice example with Axon Server & Apache Kafka
## Axon Server
Tải Axon Server phiên bản: 2023.1.2 tại: https://developer.axoniq.io/download

![image](https://github.com/DHThienIT/DemoProject_BorrowingBook_Microservice/assets/114917226/6596c5dc-2711-475f-9663-1fa830fcf828)

Sau khi tải về và giải nén, đọc và thực hiện chạy server theo file README.txt của Axon Server

![image](https://github.com/DHThienIT/DemoProject_BorrowingBook_Microservice/assets/114917226/2de1d96d-7f95-4342-8d2e-12aef318bfaa)

## Apache Kafka
Tải Apache Kafka phiên bản 3.6.1 tại: https://kafka.apache.org/downloads

![image](https://github.com/DHThienIT/DemoProject_BorrowingBook_Microservice/assets/114917226/1a131d9e-77fd-4f30-846b-f52554d591e7)

- File README.txt của Kafka
```
#2 lệnh khởi chạy Apache Kafka
zookeeper-server-start.bat C:\kafka_2.13-3.6.0\config\zookeeper.properties
kafka-server-start.bat C:\kafka_2.13-3.6.0\config\server.properties

#Command kafka
kafka-topics.bat --create --topic hythien --bootstrap-server localhost:9092
kafka-topics.bat --list --bootstrap-server localhost:9092

######### Demo #########

#Test gửi thông tin từ producer
kafka-console-producer.bat --topic quickstart-events --bootstrap-server localhost:9092
>Hello 1
>Hello 2

#Test nhận toàn bộ thông tin từ consumer
kafka-console-consumer.bat --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
>{in ra các kết quả}

######### Demo #########

#Xem thêm các config cho file application.properties của Producer
https://docs.confluent.io/platform/current/installation/configuration/producer-configs.html

#Xem thêm các config cho file application.properties của Consumer
https://docs.confluent.io/platform/current/installation/configuration/consumer-configs.html
```

Cách khởi chạy Apache Kafka bằng lệnh

![image](https://github.com/DHThienIT/DemoProject_BorrowingBook_Microservice/assets/114917226/73cb0d6d-1b4e-4114-a069-9652aeb022d2)

##Nguồn tham khảo
> [Xây dựng dự án cơ bản Microservice + Axon Server](https://www.youtube.com/playlist?list=PLDHSigHSDJWUTBa8r8tvQDQMZbemLBNp4)
> [Khóa học Spring Boot & Kafka - JMaster.io](https://www.youtube.com/watch?v=HGywc-e5f4E&list=PLsfLgp1K1xQ42CWP8dsIa7OT2EJFnRGGd)
