import org.example.rabbitmq.Producer

val message = "Sent from a worksheet"

Producer.publishMessage(message)
