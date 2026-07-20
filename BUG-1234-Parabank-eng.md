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

## Notes
This issue has been documented as a Known Issue in the README file.