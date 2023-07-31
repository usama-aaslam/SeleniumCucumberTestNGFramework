@FunctionalTest
Feature: Swag Labs login Feature

  ## With Example Keyword
  @SmokeTest @RegressionTest
  Scenario Outline: Swag lab login Test Scenario
    Given User is already on login page
    When title of login page is Swag Labs
    Then User enter "<username>" & "<password>"
    Then User click on login button
    And User will be redirected to CRM Home page
    Then Close the browser

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |

    # Without Example Keyword
  @RegressionTest
  Scenario: Swag Labs login With invalid Credentials
    Given User is already on login page
    When title of login page is Swag Labs
    Then User enter "standard_user_invalid" & "secret_sauce"
    Then User click on login button
    Then Close the browser

