This Project is based on TestNG framework with Page Object Model pattern in Selenium.
it has got two below Page classes, where all the methods and controls for respective webpages are defined.

1)LoginPage

2)HomePage

Test cases are written in FunctionTests file which eventually access Page classes in order to execute specific test.

For building and managing dependencies we have used Maven.
This test suite can be executed with testing.xml (TestNG) configuration file and it allows to execute test cases parallel on chrome 
and Firefox browser.
