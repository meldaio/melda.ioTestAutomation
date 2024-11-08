# Melda.io Test Automation
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF9E2C?style=for-the-badge&logo=testng&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit&logoColor=white)
![Allure](https://img.shields.io/badge/Allure-E94D5F?style=for-the-badge&logo=allure&logoColor=white)
![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white)  

## 📖 Overview
This repository is dedicated to Melda.io's end-to-end (E2E) test automation, leveraging **Java**, **Selenium**, **TestNG**, and **Allure** to improve the efficiency and reliability of software testing.

This project is created as part of the **Techcareer.net E2E Test Automation Workshop**. In this 10-hour workshop, participants learn the essentials of E2E testing, focusing on:
- Understanding E2E testing concepts.
- Speeding up automation processes and integrating them into real-world projects.
- Utilizing testing tools in practical scenarios to enhance efficiency and accuracy.

## 🗂️ Project Structure

```
src
├── main
│   ├── java
│   │   ├── base
│   │   │   ├── BaseLibrary.java
│   │   │   ├── BaseTest.java
│   │   │   └── Data.java
│   │   └── pages
│   │       ├── HomePage.java
│   │       ├── LoginPage.java
│   │       ├── MainPage.java
│   │       └── RegisterPage.java
├── test
│   └── java
│       ├── LoginTests.java
│       └── RegisterTests.java
└── pom.xml
```

## 📥 Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Bilaydacevik/melda.ioTestAutomation.git

2. Import into your IDE (e.g., IntelliJ IDEA).

## 🛠️ Usage
   Run tests with the following command:
   ```
    mvn test
   
   ```
 ## Reports
 Allure is used to generate detailed test execution reports. To view reports locally:

 ```
bash
allure serve

```
## 🔧 Configuration
Dependencies
 The pom.xml file manages project dependencies and plugins. Key dependencies include:
Selenium WebDriver for browser automation.
TestNG and JUnit for testing framework support.
Allure TestNG for reporting.
AspectJ Weaver for AOP (Aspect-Oriented Programming) support.
Maven handles the automatic downloading and configuration of these dependencies.

## 📊 Allure Reports and Jenkins Integration
This project utilizes **Allure** for creating detailed test execution reports. Allure reports provide insights into test results, including passed, failed, and skipped test cases. Reports can be generated and viewed locally using:

```bash
# Generate Allure report
allure serve
```

For CI/CD, the project is compatible with **Jenkins**. Jenkins can automate test runs, generate Allure reports after each build, and provide a historical view of test stability, which is essential for maintaining high software quality standards.


## 🛠️ Troubleshooting

Ensure Maven dependencies are installed.
Check Jenkins and Allure setup for CI/CD integration.

## 👥 Contributors
[bilaydacevik]([https://github.com/ChatGTHB](https://github.com/Bilaydacevik))

## 📜 License
This project is licensed under the MIT License.

   

