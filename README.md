# Rest Assured Testing Framework for Patient API

This framework is designed to automate API tests for the Patient endpoint using Rest Assured in Java.

## Overview

The framework provides both positive and negative test cases for the Patient API endpoint. It ensures that the API
functions correctly for valid inputs and handles errors for invalid inputs.

## Getting Started

### Prerequisites

- Java 8 or later.
- Maven.
- IDE (e.g., IntelliJ IDEA, Eclipse).

### Installing Java

#### For Windows:

- Download the Java JDK installer from
  the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- Run the installer and follow the setup instructions.
- Add Java to your `PATH` variable.

#### For MacOS:

- Use Homebrew: `brew install openjdk@11`
- Or download the installer from
  the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) and follow the
  setup instructions.

### Installing Maven

#### For Windows:

- Download the binary zip archive from the [official Maven website](https://maven.apache.org/download.cgi).
- Extract it to a directory.
- Add the `bin` directory to your `PATH` variable.

#### For MacOS:

- Use Homebrew: `brew install maven`

### Setup & Installation

1. Clone the Repository:

```bash
git clone git@github.com:bbagishbek/cripshealth-api-test.git
```

2. Navigate to Project Directory:

```bash
cd crisphealth-api-test
```

3. Install Dependencies:

```bash
mvn install
```

### Running Tests

1. Through Maven:

```bash
mvn test
```
2. Through an IDE:

* Open the project in your preferred IDE.
* Navigate to the test directory.
* Run tests using the IDE's built-in test runner.

