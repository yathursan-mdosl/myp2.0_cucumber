Feature: myp2 login
  Scenario: This is login scenario in myp2
    Given user is on login page
    When the user enter valid username and password
    And clicks on login button
    Then the user should navigated to home page

#  Scenario: This is logout button exists scenario
#    Given user is on login page
#    When the user enter valid username and password
#    And clicks on login button
#    Then the user should navigated to home page
#    Then Logout button should exist
