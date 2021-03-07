## karate framework kafka producer

Produce Kafka Event by Calling Custom Java Code in Karate API Tests

## Karate Config For Kafka
* Define broker and topic variables according to environment for kafka on put `karate-config.js` page

**How to Run a Test?**

* Execute `mvn clean test -DargLine="-Dkarate.env=arg0" -Dtest=CucumberParallelTestRunner#executeParallelKafkaProducerTest` command