# Testing for broken-hashserve application

This repo contains test cases, defects, and some automation for broken-hashserve.

## Project

This repo uses maven and rest assured for the java automation. There are also postman tests exported into a json file, test case text file, and defect text file.

## Usage

- Java rest-assured tests are located in jumpcloud-automation\src\main\java\TestAutomation.java. These can be run in IDE as long as the broken-hashserve application is running. Dependencies should auto import as long as maven is configured.
- Postman collection and environment can be found in jumpcloud-automation\postman. These can be imported back into Postman for running. The collection is runnable as long as the broken-hashserve application is running.