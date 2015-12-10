#!/bin/bash

echo "Building the java agent..."
./gradlew agent:jar

echo "Building the target app..."
./gradlew app:jar

echo "Running the app with java agent..."
java -javaagent:agent/build/libs/agent.jar -jar app/build/libs/app.jar
