# Selenium Cucumber (Java) - Grid Dockerized

### `Framework helps to -`
Achieve Cross Browser and Parallel Testing at once
Dockerized Selenium Grid
Summarize result of Cross Browser & Parallel testing

### `Selenium Grid`
Selenium Grid is a smart proxy server for Selenium UI Tests. Its aim is to provide an easy way to run tests in parallel on multiple machines.
With Selenium Grid, one server acts as the hub that routes JSON formatted test commands to one or more registered Grid nodes.

### `Components of Selenium grid`
image

### `Selenium grid as Docker Image`
•	Docker provider the convenient way to set up and scale Selenium Grid infrastructure in a unit known as Container. 
•	Scaling nodes up and down easily
•	Portable and Reliable for CI

### `Pre-Requisite`
• Docker
• Maven
• Java 8 & above
• Allure (for reporting)

#### `Allure installation`

`Linux`
For debian-based repositories a PPA is provided:
sudo apt-add-repository ppa:qameta/allure
sudo apt-get update 
sudo apt-get install allure

`Mac OS X`
For Mas OS, automated installation is available via Homebrew
brew install allure

`Windows`
For Windows, Allure is available from the Scoop commandline-installer.
To install Allure, download and install Scoop and then execute in the Powershell:

for more information - https://docs.qameta.io/allure/

### `How to Run`

`1. Spin up docker images `
$ docker-compose up -d --scale chrome=2 --scale firefox=2

Verify running containers 'docker ps -a'

`2. Test Execution`
$ mvn clean test

`3. Allure report generation`
$ allure serve target/allure-results


