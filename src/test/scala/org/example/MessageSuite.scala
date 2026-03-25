package org.example

import munit.FunSuite
import org.example.rabbitmq.Message

class MessageSuite extends FunSuite:

  test("every message instance contains a string"):
    val message = Message("this is a test message")
    assertEquals(message.message, "this is not the same message")

  test("serialization and deserialization"):
    val originalMessage = Message("this is another message")
    val bytes = originalMessage.serialize
    val deserializedMessage = Message.deserialize(bytes)
    assertEquals(deserializedMessage, originalMessage)

  test("serialize, deserialize and serialize again"):
    val originalMessage = Message("this is yet another message")
    val bytes1 = originalMessage.serialize
    val deserializedMessage = Message.deserialize(bytes1)
    val bytes2 = deserializedMessage.serialize
    assertEquals(bytes2, bytes1)
