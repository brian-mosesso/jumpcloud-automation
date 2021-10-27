# Testing for broken-hashserve application

This repo contains test cases, defects, and some automation for broken-hashserve.

## Project

This repo uses maven for dependency management. It has rest assured for the java automation. There are also postman tests exported into a json file, jmeter load tests, test case html file, and defect html file.
The java uses rest assured, json simple, and testNG. Those were all new libraries for me and could be improved.

## Usage

- Manual test cases are located in jumpcloud-automation\test-cases.html. To open, right click on the file and open in a browser. Ideally a test case management tool would be used.
- Defects are located in jumpcloud-automation\defects.html. To open, right click on the file and open in a browser. Ideally a defect tracking tool would be used.
- Java rest-assured tests are located in jumpcloud-automation\src\main\java\TestAutomation.java. These can be run in IDE as long as the broken-hashserve application is running. Dependencies should auto import with mvn clean install as long as maven is configured. TestNG plugin might have to manually be added.
- Postman collection and environment can be found in jumpcloud-automation\postman. These can be imported back into Postman for running. The collection is runnable as long as the broken-hashserve application is running.
- JMeter tests for load testing are located in jumpcloud-automation\jmeter\broken-hashserve.jmx. These can be run in jmeter or using terminal as long as the broken-hashserve application is running.

## Choice for coverage

- Choice for coverage was based on some sort of MVP testing according to the requirements.
- The use of automation was decided to make it easier on the tester. Though there is still a lot that can be added to automation. It's a good starting point. The automation could use more assertions so they would fail when they should, and also could be refactored.
