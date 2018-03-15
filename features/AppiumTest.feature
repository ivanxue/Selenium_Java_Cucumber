Feature: Appium Demo Test
  Scenario: Appium Demo Test
    Given I launch the iOS app
    Then I can see the table
    And Table row count is 18 and first row is "Action Sheets"
    When I click the first row
    Then Table cell value is "Okay / Cancel"