# Melda.io Test Automation

## 📖 Overview
This repository is dedicated to Melda.io's end-to-end (E2E) test automation, leveraging **Java**, **Selenium**, **TestNG**, and **Allure** to improve the efficiency and reliability of software testing.

## 🗂️ Project Structure
🗂️ **Project Structure**  
- **src/main/java**: Main automation scripts  
  - **base**: Core setup (e.g., `BaseTest`, `BaseLibrary`)
  - **pages**: Page Object Model structure (e.g., `LoginPage`, `HomePage`)
- **src/test/java**: Test cases (e.g., `LoginTests`, `RegisterTests`)

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

pom.xml: Manages dependencies and plugins.

##🛠️ Troubleshooting

Ensure Maven dependencies are installed.
Check Jenkins and Allure setup for CI/CD integration.

##👥 Contributors
@bilaydacevik  

##📜 License
This project is licensed under the MIT License.

   

