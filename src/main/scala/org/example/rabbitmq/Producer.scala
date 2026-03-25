package org.example.rabbitmq

object Producer:
  def publishMessage(message: String): Unit =
    withChannel(createConnectionFactory()): channel =>
      declareQueue(channel, QueueName)
      val msg = Message(message)
      channel.basicPublish("", QueueName, null, msg.serialize)
      println(s" [x] Sent: $msg")

  def main(args: Array[String]): Unit =
    publishMessage("Hello, Scalar!")
