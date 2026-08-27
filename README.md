# Selenium Java BDD Automation Framework

A Java-based **UI Test Automation Framework** built using **Selenium WebDriver, Cucumber BDD, TestNG and Maven**.

This project demonstrates a structured and reusable approach to web application automation using **Page Object Model (POM), Cucumber feature files, step definitions, reusable Selenium utilities, external test data, TestNG test suites and automated reporting**.

---

## 🚀 Project Overview

The framework is designed to automate web application scenarios using:

* Selenium WebDriver for browser automation
* Java for automation implementation
* Cucumber BDD for behavior-driven test scenarios
* TestNG for test execution and suite management
* Maven for dependency and build management
* Page Object Model for maintainable page-level automation
* Reusable utility classes for common Selenium operations
* External test data using Excel, Properties and Text files
* Extent Reports and Allure Reports for test reporting

---

## 🛠️ Technology Stack

| Technology                | Purpose                         |
| ------------------------- | ------------------------------- |
| Java 21                   | Programming language            |
| Selenium WebDriver 4.46.0 | Web UI automation               |
| Cucumber 7.33.0           | BDD framework                   |
| TestNG 7.10.2             | Test execution                  |
| Maven                     | Build and dependency management |
| Apache POI 5.4.1          | Excel test-data handling        |
| Extent Reports            | Test reporting                  |
| Allure                    | Test reporting                  |
| AShot 1.5.4               | Full-page screenshot support    |
| Git                       | Version control                 |
| GitHub                    | Source code management          |
| Eclipse                   | Development environment         |

---

# 📁 Project Structure

```text
selenium-java-utilities
│
├── src
│   └── test
│       │
│       ├── java
│       │   │
│       │   ├── dummyglue
│       │   │   ├── ExampleStepDef1.java
│       │   │   └── ExampleStepDef2.java
│       │   │
│       │   ├── gluecode
│       │   │   ├── Shared.java
│       │   │   ├── StepDef1.java
│       │   │   ├── StepDef2.java
│       │   │   ├── StepDef3.java
│       │   │   ├── StepDef4.java
│       │   │   └── StepDef5.java
│       │   │
│       │   ├── pages
│       │   │   ├── ConfirmPage.java
│       │   │   └── RegPage.java
│       │   │
│       │   ├── tests
│       │   │   ├── Runner1.java
│       │   │   ├── Runner2.java
│       │   │   ├── Runner3.java
│       │   │   ├── Runner4.java
│       │   │   ├── Runner5.java
│       │   │   └── Runner6.java
│       │   │
│       │   └── utilities
│       │       ├── ActionsUtility.java
│       │       ├── CarouselSliderUtility.java
│       │       ├── ChatBotUtility.java
│       │       ├── CheckBoxUtility.java
│       │       ├── CookiesUtility.java
│       │       ├── DivDropDownUtility.java
│       │       ├── DivTableUtility.java
│       │       ├── ExcelFileUtility.java
│       │       ├── PropertiesFileUtility.java
│       │       ├── RadioButtonUtility.java
│       │       ├── RandomUtility.java
│       │       ├── TextFileUtility.java
│       │       ├── WebSiteUtility.java
│       │       └── WebTableUtility.java
│       │
│       └── resources
│           │
│           ├── batchfiles
│           │   └── loginbatch.bat
│           │
│           ├── dummyfeatures
│           │   ├── dummyexample1.feature
│           │   ├── dummyexample2.feature
│           │   └── dummyexample3.feature
│           │
│           ├── features
│           │   ├── myfeature1.feature
│           │   ├── myfeature2.feature
│           │   ├── myfeature3.feature
│           │   ├── myfeature4.feature
│           │   ├── myfeature5.feature
│           │   ├── myfeature6.feature
│           │   ├── myfeature7.feature
│           │   ├── myfeature8.feature
│           │   └── myfeature9.feature
│           │
│           ├── testdatafiles
│           │   ├── config.properties
│           │   ├── testdata.txt
│           │   └── testdata.xlsx
│           │
│           └── extent.properties
│
├── pom.xml
├── realtest-testng.xml
├── regressiontest-testng.xml
├── retest-testng.xml
├── smoketest-testng.xml
├── .gitignore
├── LICENSE
└── README.md
```

---

# 🏗️ Framework Architecture

The framework follows a layered approach:

```text
                  Feature Files
                       │
                       ▼
                Cucumber Runners
                       │
                       ▼
                 Step Definitions
                       │
             ┌─────────┴─────────┐
             ▼                   ▼
        Page Objects         Utilities
             │                   │
             └─────────┬─────────┘
                       ▼
                Selenium WebDriver
                       │
                       ▼
                  Web Browser
```

### Execution Flow

```text
Feature File
     ↓
Cucumber Runner
     ↓
Step Definition
     ↓
Page Object / Utility
     ↓
Selenium WebDriver
     ↓
Browser
     ↓
Validation
     ↓
Test Reports
```

---

# 🥒 Cucumber BDD

BDD scenarios are maintained in:

```text
src/test/resources/features
```

The project currently contains multiple feature files:

```text
myfeature1.feature
myfeature2.feature
myfeature3.feature
myfeature4.feature
myfeature5.feature
myfeature6.feature
myfeature7.feature
myfeature8.feature
myfeature9.feature
```

Cucumber allows test scenarios to be expressed using readable **Gherkin syntax**.

Example:

```gherkin
Feature: User Registration

  Scenario: Register a new user

    Given user navigates to the registration page
    When user enters valid registration details
    And user submits the registration form
    Then registration should be completed successfully
```

---

# 🔗 Step Definitions

Step definition implementations are maintained under:

```text
src/test/java/gluecode
```

Current classes include:

```text
Shared.java
StepDef1.java
StepDef2.java
StepDef3.java
StepDef4.java
StepDef5.java
```

These classes provide the Java implementation for the steps defined in the Cucumber feature files.

---

# 📄 Page Object Model

Page-specific automation is maintained under:

```text
src/test/java/pages
```

Current page classes include:

```text
RegPage.java
ConfirmPage.java
```

The Page Object Model helps separate page-level locators and actions from test/step-definition logic.

### Benefits

* Improved maintainability
* Reduced code duplication
* Better separation of concerns
* Easier locator maintenance
* Reusable page-level actions

---

# ♻️ Reusable Utilities

Reusable Selenium and test-data functionality is maintained under:

```text
src/test/java/utilities
```

### Available Utilities

| Utility Class           | Purpose                               |
| ----------------------- | ------------------------------------- |
| `ActionsUtility`        | Browser actions and user interactions |
| `CarouselSliderUtility` | Carousel and slider handling          |
| `ChatBotUtility`        | Chatbot UI interactions               |
| `CheckBoxUtility`       | Checkbox handling                     |
| `CookiesUtility`        | Browser cookie handling               |
| `DivDropDownUtility`    | Div-based dropdown handling           |
| `DivTableUtility`       | Div-based table handling              |
| `ExcelFileUtility`      | Excel test-data operations            |
| `PropertiesFileUtility` | Properties-file operations            |
| `RadioButtonUtility`    | Radio-button handling                 |
| `RandomUtility`         | Random test-data generation           |
| `TextFileUtility`       | Text-file operations                  |
| `WebSiteUtility`        | Common website/browser operations     |
| `WebTableUtility`       | HTML web-table handling               |

The utility layer promotes **reusability and reduces duplicate automation code**.

---

# 📊 Test Data Management

External test data is maintained under:

```text
src/test/resources/testdatafiles
```

The project currently contains:

```text
config.properties
testdata.txt
testdata.xlsx
```

### Properties File

`config.properties` is used for configuration-related test data and settings.

### Excel

`testdata.xlsx` can be handled using Apache POI through:

```text
ExcelFileUtility.java
```

### Text File

`testdata.txt` can be accessed using:

```text
TextFileUtility.java
```

Keeping test data outside the automation code helps improve flexibility and maintainability.

---

# 🧪 TestNG Test Suites

The repository contains multiple TestNG suite files:

```text
smoketest-testng.xml
regressiontest-testng.xml
retest-testng.xml
realtest-testng.xml
```

These suites provide separate execution configurations for different testing purposes.

### Smoke Test

```text
smoketest-testng.xml
```

### Regression Test

```text
regressiontest-testng.xml
```

### Retest

```text
retest-testng.xml
```

### Real Test

```text
realtest-testng.xml
```

---

# 📈 Reporting

The framework contains integrations for:

### TestNG Reports

TestNG generates execution reports in:

```text
test-output/
```

Typical generated files include:

```text
index.html
emailable-report.html
testng-results.xml
```

### Extent Reports

The project uses:

```text
extentreports-cucumber7-adapter
```

with:

```text
src/test/resources/extent.properties
```

for Cucumber-compatible Extent reporting.

### Allure Reports

The project includes:

```text
allure-cucumber7-jvm
```

Allure result files are generated in:

```text
allure-results/
```

An Allure report can be viewed locally using:

```bash
allure serve allure-results
```

---

# 📸 Full-Page Screenshot Support

The framework includes **AShot** for full-page screenshot capability when required.

Dependency:

```text
ru.yandex.qatools.ashot:ashot
```

Version:

```text
1.5.4
```

---

# 📦 Maven

Maven is used for dependency management and test execution.

The project uses the following main Maven dependencies:

```text
Selenium Java       4.46.0
TestNG              7.10.2
Cucumber Java       7.33.0
Cucumber TestNG     7.33.0
PicoContainer       7.33.0
Extent Adapter      1.10.1
Allure Cucumber     2.35.2
Apache POI           5.4.1
AShot                1.5.4
```

The Maven compiler is configured for:

```text
Java 21
```

---

# ▶️ How to Run

## Prerequisites

Make sure the following are installed:

* JDK 21
* Maven
* Git
* Eclipse or another Java IDE
* Supported web browser

Verify Java:

```bash
java -version
```

Verify Maven:

```bash
mvn -version
```

---

## Clone the Repository

```bash
git clone <your-github-repository-url>
```

Navigate to the project:

```bash
cd selenium-java-utilities
```

---

## Install Maven Dependencies

```bash
mvn clean install
```

---

## Execute Smoke Tests

```bash
mvn clean test -Dxyz=smoketest-testng.xml
```

## Execute Regression Tests

```bash
mvn clean test -Dxyz=regressiontest-testng.xml
```

## Execute Retest Suite

```bash
mvn clean test -Dxyz=retest-testng.xml
```

## Execute Real Test Suite

```bash
mvn clean test -Dxyz=realtest-testng.xml
```

The `xyz` property corresponds to the TestNG suite selection configured in the Maven Surefire configuration.

---

# 🔄 Git Workflow

The project is maintained using Git and GitHub.

Typical workflow:

```bash
git status
```

Review changes:

```bash
git diff
```

Stage changes:

```bash
git add .
```

Commit:

```bash
git commit -m "Update automation framework"
```

Push:

```bash
git push origin main
```

---

# 🧹 Repository Hygiene

Generated files should generally not be committed to source control.

Recommended entries in `.gitignore` include:

```gitignore
target/
test-output/
allure-results/
```

This keeps the GitHub repository focused on **source code, test resources, configuration and framework implementation** rather than generated execution artifacts.

---

# 🎯 Key Automation Capabilities

This project demonstrates automation of different web UI components and scenarios, including:

* Web forms
* Checkboxes
* Radio buttons
* Dropdowns
* Web tables
* Div-based tables
* Div-based dropdowns
* Browser actions
* Cookies
* Carousel/slider components
* Chatbot UI
* External test data
* Random test-data generation
* Page-level automation
* BDD scenarios
* TestNG suite execution
* Automated reporting
* Screenshot support

---

# 💼 Key Skills Demonstrated

This framework demonstrates practical understanding of:

* Selenium WebDriver
* Java automation
* Cucumber BDD
* Gherkin
* TestNG
* Maven
* Page Object Model
* Reusable framework utilities
* External test-data management
* Apache POI
* Test suite management
* Extent Reports
* Allure Reports
* Git and GitHub
* Framework organization and maintainability

### Framework Design Concepts Demonstrated

**Separation of Concerns**

Feature files, step definitions, page objects, utilities and test data are maintained in separate locations.

**Reusability**

Common Selenium operations are implemented as reusable utility classes.

**Maintainability**

Page-specific operations are organized within page objects.

**Scalability**

The existing structure allows additional feature files, page objects, step definitions and utilities to be added without changing the overall framework design.

---

# 👩‍💻 Author

## Trupti Gabhane

**QA Automation Engineer / SDET**

### Core Skills

`Java` · `Selenium WebDriver` · `Cucumber BDD` · `TestNG` · `Maven` · `Git` · `GitHub` · `Automation Framework`

---

# 📄 License

This project is licensed under the terms specified in the repository's `LICENSE` file.

