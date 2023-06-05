# Project Name

Short project description

## Table of Contents
- [Description](#description)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running Kafka Locally](#running-kafka-locally)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Description

This is just a sample unit integration testing in kafka.
We will be using a local instance of kafka so you should be ready to install it using docker.

### Prerequisites

1. Java 17
2. Docker
3. Kafka (We'll setup here)

### Installation

1. Clone the repository:

`git clone <repository_url>`

2. Import the project into your preferred IDE.

3. Install the project dependencies by running the following command:

`mvn install`


### Running Kafka Locally

To run your own local Kafka instance, follow these steps:

1. Download Kafka from [Kafka Downloads](https://kafka.apache.org/downloads).

2. Set up the necessary environment variables to easily access Kafka CLI.

3. Use the provided `kafka-zookeeper-docker-compose.yml` file to run your Kafka instance using Docker:

docker-compose -f kafka-zookeeper-docker-compose.yml up -d

This will start the Kafka and ZooKeeper containers.

## Usage

Explain how to use your project or provide examples of how to run and test it. For JUnit testing, follow these steps:

1. Open the project in your preferred IDE.

2. Navigate to the test directory and locate the JUnit test files.

3. Customize the test cases according to your requirements.

4. Run the JUnit tests using your IDE's test runner or by executing the tests via the command line:

`mvn test`


This command will execute the JUnit tests and provide the test results.

Note: Ensure that you have a running Kafka instance (locally or in a test environment) for the tests to interact with.


## License

MIT