README – QA Automation Framework: Parabank

Project Description
This project is a complete QA Automation framework built in Java, using Selenium WebDriver, TestNG, Allure Reporting, Docker + Selenium Grid, Log4j2, and a Page Object Model (POM) architecture. The framework automates functional flows in the Parabank demo application, covering scenarios such as:
•	Login
•	Funds Transfer
•	Opening a New Account
•	Updating User Profile
•	Dashboard Navigation
•	User Registration

The framework includes Allure annotations such as @Epic, @Feature, @Story, @Description, and @Severity for professional and structured reporting.

Technologies Used
•	Java 17
•	Selenium WebDriver 4.36
•	TestNG 7.7
•	Allure Reporting
•	Docker + Selenium Grid
•	GitHub Actions (CI/CD)
•	Log4j2 for logging

Framework Features
•	Page Object Model (POM) architecture
•	Utility classes:
o	WaitUtils – stable synchronization
o	AssertionUtils – consistent validations
o	TestDataUtils – test data management
•	Integration with Selenium Grid for distributed execution
•	Automatic reporting with Allure
•	Allure annotations for each test:
o	Epic
o	Feature
o	Story
o	Description
o	Severity (CRITICAL, NORMAL, MINOR, etc.)

Implemented Tests
•	LoginTests
•	AccountsTests
•	OpenAccountTests
•	TransferTests
•	BillPayTests
•	HomeTest
•	RegisterTests
•	UpdateProfileTest

Total real tests: 8 (Allure may display more due to reruns → see Known Issues.)

Known Issues – Parabank Application Bugs (UI)
The Parabank application contains several UI bugs that affect automation. One of them is documented in the project as BUG 1234.md.

BUG 1234 – Login Page DOM Hidden / Filtered by Cloudflare
Status: BLOCKER Impact: Login tests + all tests depending on login
Symptoms:
•	NoSuchElementException for input[name='username']
•	Automatic redirect to /overview.htm
•	Page source differs from visible UI
•	Selenium WebDriver cannot see username/password fields
Affected Tests:
•	verifyLoginSuccessful
•	verifyLoginFailsWithWrongCredentials
Documentation:
This bug is documented in BUG 1234.md inside the project. In an enterprise environment, it would be reported in Jira.

BUG – Account Dropdown Sometimes Empty
Status: CRITICAL Impact: Open Account + Transfer Funds
Symptoms:
•	#fromAccountId dropdown contains 0 options
•	Inconsistent behavior
Affected Tests:
•	verifyOpenNewAccountIsSuccessful
•	verifyTransferIsSuccessful

BUG – Confirmation Messages Are Inconsistent
Status: NORMAL Impact: Open Account + Transfer Funds + Bill Pay
Symptoms:
•	Messages differ between executions
•	Sometimes incomplete
•	Transfer confirmation may be “Transfer Complete”, “Success”, “Transfer”, etc.


Affected Tests:
•	verifyOpenNewAccountIsSuccessful
•	verifyTransferIsSuccessful
•	verifyBillPaymentIsSuccessful

BUG – Duplicate Test Cases in Allure Report
Status: MINOR Impact: Reporting
Symptoms:
•	Allure displays 10 test cases, but only 8 exist
•	Duplicate JSON files in allure-results
•	Cause: automatic rerun + Cloudflare redirects
QA Decision:
•	Run with mvn clean test to avoid duplicates
•	Clean the allure-results folder before execution

Test Status
Fully Blocked Tests
•	LoginTests (2 tests)

Partially Affected Tests
•	OpenAccountTests
•	TransferTests
•	BillPayTests

Stable Tests
•	HomeTest
•	RegisterTests
•	UpdateProfileTest

Project Structure
Cod
UIAutomationParabank/
├── src/
│   ├── main/java/com.victoria.parabank/
│   │   ├── base
│   │   ├── drivers
│   │   ├── utils
│   │   └── pages
│   ├── test/java/com.victoria.parabank/
│   │   ├── base
│   │   ├── tests
│   │   └── utils
│   └── resources/
│       ├── config.properties
│       ├── environment.properties
│       └── testng.xml
├── pom.xml
├── docker-compose.yml
├── BUG-1234.md
├── README_ro.md
├── README_eng.md
└── .gitignore

Conclusion
This framework demonstrates:
•	A robust, scalable, and well structured QA Automation architecture
•	Professional handling of real application bugs through Known Issues
•	Documentation of a real defect in BUG 1234.md
•	Advanced reporting using Allure
•	Integration with Selenium Grid and CI/CD
•	Clear and complete project documentation