package org.example.rabbitmq

import com.rabbitmq.client.{Channel, ConnectionFactory}

import scala.util.Using

final val QueueName = "scalar"

def createConnectionFactory(): ConnectionFactory =
  val factory = ConnectionFactory()
  factory.setHost("rabbitmq")
  factory

def createChannel(factory: ConnectionFactory): Channel =
  val connection = factory.newConnection()
  connection.createChannel()

def withChannel[A](factory: ConnectionFactory)(use: Channel => A): A =
  Using.resource(factory.newConnection()): connection =>
    Using.resource(connection.createChannel()): channel =>
      use(channel)

def declareQueue(channel: Channel, name: String): Unit =
  val args = java.util.Map.of[String, AnyRef]("x-queue-type", "quorum")
  channel.queueDeclare(name, true, false, false, args)
