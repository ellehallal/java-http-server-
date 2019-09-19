# Java HTTP Server

[![Build Status](https://travis-ci.org/itsellej/java-http-server-.svg?branch=master)](https://travis-ci.org/itsellej/java-http-server-)

- [Java HTTP Server](#java-http-server)
  - [Description](#description)
  - [Preview](#preview)
  - [Features](#features)
  - [Getting Started](#getting-started)
  - [Language](#language)
  - [Testing](#testing)

## Description

 A HTTP server, created with Java. 

## Preview

- Coming soon

## Getting Started

- [Install Java, version 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [Install Maven, version 3.6.1](https://maven.apache.org/download.cgi)

To start the server:

 ```
git clone https://github.com/itsellej/java-http-server-
cd java-http-server-
mvn package
java -Dserver.port=$PORT $JAVA_OPTS -jar target/http-server-1.0-SNAPSHOT.jar
 ```
 
## Language 

 The language used to create this application is [Java, version 11](https://docs.oracle.com/en/java/), using the build automation tool, [Maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html).

## Testing

The testing library used for the unit tests [JUnit, version 5.4.2](https://junit.org/junit5/).

To run the unit tests:

```mvn test``` 

The testing library used for the acceptance tests is [Spinach](https://codegram.github.io/spinach/)

To run the acceptance tests, start the server and then do the following:

```
cd src/test/acceptance-tests
bundler install
bundler exec spinach
```




