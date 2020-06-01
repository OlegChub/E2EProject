# new feature
# Tags: optional

Feature: Login

  Scenario Outline: Login with wrong credentials
    Given user is on the main page
    And user clicks on Enter button
    When user login into application with login <login> and pass <password>
    Then Entrance is "false"

    Examples:
   |login         |password  |
   |Hoplla@tut.by |Pass12345 |
   |Solpla@tut.by |12345     |