package org.example.rabbitmq

import java.nio.charset.StandardCharsets

object Producer:
  def main(args: Array[String]): Unit =
    withChannel(createConnectionFactory()): channel =>
      declareQueue(channel, QueueName)
      val message = Message("Hello, Scalar!")
      channel.basicPublish("", QueueName, null, message.serialize)
      println(s" [x] Sent '$message'")
