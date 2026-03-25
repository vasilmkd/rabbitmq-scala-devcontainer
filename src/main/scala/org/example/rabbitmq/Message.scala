package org.example.rabbitmq

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, ObjectInputStream, ObjectOutputStream}
import java.time.Instant
import scala.util.Using

final case class Message(message: String, timestamp: Instant = Instant.now()):
  def serialize: Array[Byte] =
    Using.resource(ByteArrayOutputStream()): bos =>
      Using.resource(ObjectOutputStream(bos)): oos =>
        oos.writeObject(this)
      bos.toByteArray

object Message:
  def deserialize(bytes: Array[Byte]): Message =
    Using.resource(ByteArrayInputStream(bytes)): bis =>
      Using.resource(ObjectInputStream(bis)): ois =>
        ois.readObject().asInstanceOf[Message]
