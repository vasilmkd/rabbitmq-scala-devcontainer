package org.example.rabbitmq

import com.rabbitmq.client.DeliverCallback

object Consumer:
  def main(args: Array[String]): Unit =
    val factory = createConnectionFactory()
    val channel = createChannel(factory)

    declareQueue(channel, QueueName)
    println(" [*] Waiting for messages.")

    val deliverCallback: DeliverCallback = (_, delivery) =>
      val message = Message.deserialize(delivery.getBody)
      println(s" [x] Received '$message'")

    channel.basicConsume(QueueName, true, deliverCallback, _ => ())
  end main
