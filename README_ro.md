README – QA Automation Framework: Parabank

Descriere proiect
Acest proiect reprezintă un framework complet de QA Automation dezvoltat în Java, utilizând Selenium WebDriver, TestNG, Allure Reporting, Docker + Selenium Grid, Log4j2 și o arhitectură Page Object Model (POM). Framework-ul automatizează fluxuri funcționale din aplicația demo Parabank, acoperind scenarii precum:
•	Login
•	Transfer de fonduri
•	Deschiderea unui cont nou
•	Actualizarea profilului
•	Navigarea în dashboard
•	Înregistrarea unui utilizator

Framework-ul include adnotări Allure precum @Epic, @Feature, @Story, @Description, @Severity, pentru o raportare profesionistă și structurată.

⚙️ Tehnologii utilizate
•	Java 17
•	Selenium WebDriver 4.36
•	TestNG 7.7
•	Allure Reporting
•	Docker + Selenium Grid
•	GitHub Actions (CI/CD)
•	Log4j2 pentru logging

Funcționalități framework
•	Arhitectură Page Object Model (POM)
•	Clase utilitare:
o	WaitUtils – sincronizări stabile
o	AssertionUtils – validări consistente
o	TestDataUtils – gestionarea datelor de test
•	Integrare cu Selenium Grid pentru execuții distribuite
•	Raportare automată cu Allure
•	Adnotări Allure pentru fiecare test:
o	Epic
o	Feature
o	Story
o	Description
o	Severity Levels (CRITICAL, NORMAL, MINOR etc.)

Testele implementate
•	LoginTests
•	AccountsTests
•	OpenAccountTests
•	TransferTests
•	BillPayTests
•	HomeTest
•	RegisterTests
•	UpdateProfileTest
Total teste reale: 8 Allure poate afișa mai multe din cauza rerulărilor → vezi secțiunea Known Issues.

Known Issues – Parabank Application Bugs (UI)
Aplicația Parabank prezintă mai multe bug-uri care afectează automatizarea UI. Unul dintre ele este documentat în proiect ca BUG 1234.md.
BUG 1234 – Login page DOM este ascuns / filtrat de Cloudflare
Status: BLOCKER Impact: Login tests + toate testele care depind de login

Simptome:
•	NoSuchElementException pentru input[name='username']
•	Redirecționare automată către /overview.htm
•	Page source diferit față de UI
•	Selenium WebDriver nu vede câmpurile username/password
Teste afectate:
•	verifyLoginSuccessful
•	verifyLoginFailsWithWrongCredentials

Documentare:
Bug-ul este documentat în fișierul BUG 1234.md din proiect. Într-un proiect enterprise, ar fi raportat în Jira.
BUG: Dropdown-ul de conturi este uneori gol
Status: CRITICAL Impact: Open Account + Transfer Funds

Simptome:
•	Dropdown-ul #fromAccountId are 0 opțiuni
•	Comportament inconsistent
Teste afectate:
•	verifyOpenNewAccountIsSuccessful
•	verifyTransferIsSuccessful

BUG: Mesajele de confirmare sunt inconsistente
Status: NORMAL Impact: Open Account + Transfer Funds + Bill Pay
Simptome:
•	Mesaje diferite între execuții
•	Uneori incomplete
•	Transfer confirmation poate fi “Transfer Complete”, “Success”, “Transfer”, etc.

Teste afectate:
•	verifyOpenNewAccountIsSuccessful
•	verifyTransferIsSuccessful
•	verifyBillPaymentIsSuccessful

BUG: Duplicate în Allure Report
Status: MINOR Impact: Raportare

Simptome:
•	Allure afișează 10 test cases, dar există doar 8
•	Fișiere duplicate în allure-results
•	Cauză: rerun automat + redirecționări Cloudflare

Decizie QA:
•	Se rulează cu mvn clean test pentru a evita duplicatele
•	Folderul allure-results se curăță înainte de execuție

Status Teste
Teste complet blocate
•	LoginTests (2 teste)
Teste afectate parțial
•	OpenAccountTests
•	TransferTests
•	BillPayTests
Teste stabile
•	HomeTest
•	RegisterTests
•	UpdateProfileTest

Structura proiectului
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

Concluzie
Framework-ul demonstrează:
•	Implementarea unui framework robust, scalabil și bine structurat
•	Gestionarea profesionistă a bug-urilor reale prin Known Issues
•	Documentarea unui bug real în fișierul BUG 1234.md
•	Utilizarea Allure pentru raportare avansată
•	Integrare cu Selenium Grid și CI/CD
•	Documentare completă și clară.
