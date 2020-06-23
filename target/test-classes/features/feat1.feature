Feature: Search in google for Cucumber and Selenium

  @regression
  Scenario: Search for Cucumber
    Given Go to google page
    When Enter search "cucumber"

    @regression
  Scenario: Search for Selenium
    Given Go to google page
    When Enter search "selenium"
