
# BUG-1234: Parabank login page does not expose username/password fields to Selenium WebDriver

**Type:** Bug  
**Priority:** High  
**Status:** Blocked – Application Bug

## Description
Parabank login page nu expune câmpurile `username` și `password` către Selenium WebDriver.  
DOM-ul returnat către WebDriver este incomplet și protejat de Cloudflare.

## Steps to Reproduce
1. Deschide aplicația Parabank.
2. Rulează testul de login cu Selenium WebDriver.
3. Observă că elementul `input[name='username']` nu există în DOM.

## Actual Result
- Redirecționare automată către `/overview.htm`.
- DOM incomplet, elementele de login lipsesc.

## Expected Result
- Formularul de login să fie disponibil în DOM.
- Selenium să poată interacționa cu câmpurile `username` și `password`.

## Impact
- Testele de login nu pot fi automatizate.
- Testele care depind de login sunt blocate.

# BUG-1234: Parabank login page does not expose username/password fields to Selenium WebDriver

**Type:** Bug  
**Priority:** High  
**Status:** Blocked – Application Bug

## Description
The Parabank login page does not expose the `username` and `password` fields to Selenium WebDriver.  
The DOM returned to WebDriver is incomplete and protected by Cloudflare.

## Steps to Reproduce
1. Open the Parabank application.
2. Run the login test with Selenium WebDriver.
3. Observe that the element `input[name='username']` does not exist in the DOM.

## Actual Result
- Automatic redirect to `/overview.htm`.
- Incomplete DOM, login elements missing.

## Expected Result
- The login form should be available in the DOM.
- Selenium should be able to interact with the `username` and `password` fields.

## Impact
- Login tests cannot be automated.
- Tests depending on login are blocked.

**Environment:** Chrome 150 / Selenium 4.36 / Windows 11

## Attachments
- Screenshot of the login page
- Selenium execution log (`NoSuchElementException`)

## Attachments
- Screenshot cu pagina de login
- Log de execuție Selenium (`NoSuchElementException`)  

## Notes
This issue has been documented as a Known Issue in the README file.