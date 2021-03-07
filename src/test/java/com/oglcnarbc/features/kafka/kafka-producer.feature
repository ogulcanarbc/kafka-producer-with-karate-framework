@kafka-producer
Feature: kafka event producer test suite

  Background:
    * def UserCreatedEventProducer = Java.type('com.oglcnarbc.kafka.producer.users.UserCreatedEventProducer')
    * def userCreatedEventProducer = new UserCreatedEventProducer(kafka_broker,user_created_topic)

  Scenario: kafka producer example
    * def message = userCreatedEventProducer.produceUserCreatedEvent()
    * print 'produce message:', message

  Scenario: kafka producer example with parameter
    * def message = userCreatedEventProducer.produceUserCreatedEvent(823,'oglcnarbc')
    * print 'produce message:', message