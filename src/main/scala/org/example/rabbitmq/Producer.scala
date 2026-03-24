package org.example.rabbitmq

import java.nio.charset.StandardCharsets

object Producer:
  private final val QueueName = "scalar"

  def main(args: Array[String]): Unit =
    withChannel(createConnectionFactory()): channel =>
      declareQueue(channel, QueueName)
      val message = "Hello, Scalar!"
      channel.basicPublish("", QueueName, null, message.getBytes(StandardCharsets.UTF_8))
      println(s" [x] Sent '$message'")
