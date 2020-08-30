# spring_cloud_stream_firsttime
## 説明
初めてのSpring Cloud Streamの為に作成したサンプルです。

## 要求事項
* Java 11以上
* Maven 3.6.3以上
* Docker

## 起動方法
プロジェクトのルートで以下コマンドを発行してください。
```
$ docker-compose up -d
$ mvn spring-boot:run
```

## 動作確認
### console-consumerの起動
```
// Kafkaコンテナに入る。
$ docker exec -it kafka /bin/bash

// メッセージを受信する用意をする。
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic cold-drink-topic --group consumer-group
// 後述のconsole-producerで入力した値が以下で表示される事を確認する。
```
### console-producerの起動
```
// Kafkaコンテナに入る。
$ docker exec -it kafka /bin/bash

// メッセージを送信する。
# kafka-console-producer.sh --broker-list localhost:9092 --topic order-topic
>{"test": 1}
>{"test": 2}
> (ctl-cで抜ける。)
```
