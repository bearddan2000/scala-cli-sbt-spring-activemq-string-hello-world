# scala-cli-sbt-spring-activemq-string-hello-world

## Description
A POC for active mq in springframework.
Sends and receives a string on a single
queue `SampleQueue`.

## Tech stack
- scala
- active mq
- sbt

## Docker stack
- openjdk:8-jre-alpine

## To run
`sudo ./install.sh -u`
- ActiveMQ console available at http://localhost:8161
- Login with admin/admin

## To stop (optional)
`sudo ./install.sh -d`

## For help
`sudo ./install.sh -h`

## Credits
- https://simplesassim.wordpress.com/2014/01/10/how-to-send-a-message-to-an-apache-activemq-topic-with-kotlin/
- https://examples.javacodegeeks.com/enterprise-java/jms/jms-messagelistener-example/
