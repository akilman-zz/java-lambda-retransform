#!/bin/bash

case1() {
    echo "Building the test case (1) app - an anonymous call site re-transform..."
    ./gradlew clean agent:jar app:anonymousCallSiteJar

    echo "Running test case (1) app with java agent..."
    java -javaagent:agent/build/libs/agent.jar -jar app/build/libs/anonymousCallSite.jar
}


case2() {
    echo "Building the test case (2) app - an instance method call site re-transform..."
    ./gradlew clean agent:jar app:instanceMethodCallSiteJar

    echo "Running test case (1) app with java agent... will throw exception in ~3 seconds"
    java -javaagent:agent/build/libs/agent.jar -jar app/build/libs/instanceMethodCallSite.jar
}

case3() {
    echo "Building the test case (3) app - an static method call site re-transform..."
    ./gradlew clean agent:jar app:staticMethodCallSiteApp

    echo "Running test case (1) app with java agent... will throw exception in ~3 seconds"
    java -javaagent:agent/build/libs/agent.jar -jar app/build/libs/staticMethodCallSiteApp.jar
}

case "$1" in
"case1") case1 ;;
"case2") case2 ;;
"case3") case3 ;;
esac