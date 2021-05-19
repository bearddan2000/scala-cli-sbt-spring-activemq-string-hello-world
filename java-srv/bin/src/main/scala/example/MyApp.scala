package example

import org.springframework.context.annotation.Configuration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.jms.Session
import javax.jms.Message;
import org.apache.activemq.ActiveMQConnectionFactory

@Configuration
@EnableAutoConfiguration
@ComponentScan
class MyApp
{

  val MQAddress = "tcp://mq-srv:61616"

  val QueueName = "SampleQueue"

  def receive() {
    val connFactory = new ActiveMQConnectionFactory(MQAddress)

    val conn = connFactory.createConnection()

    val sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE)

    val dest = sess.createQueue(QueueName)

    val cons = sess.createConsumer(dest)

    conn.start()

    val msg = cons.receive()

    println(msg)

    conn.close()
  }

  def send() {
    val connFactory = new ActiveMQConnectionFactory(MQAddress)

    val conn = connFactory.createConnection()

    val sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE)

    val dest = sess.createQueue(QueueName)

    val cons = sess.createProducer(dest)

    conn.start()

    val msg :Message = sess.createTextMessage("hello world")

  	cons.send(msg)

    conn.close()
  }

}

object Application extends App {

 SpringApplication.run(classOf[MyApp]);

 val app :MyApp = new MyApp()

 app.send()

 app.receive()
}
