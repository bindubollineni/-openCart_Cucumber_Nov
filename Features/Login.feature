Feature: Login with valid credentials

  Scenario: Successful Login with Credentials
    Given user launches browser
    And opens URL "http://opencart.abstracta.us/index.php?route=common/home"
    When user clicks MyAccount link
    And user clicks Login link
    And user enter email id "miyamiya@gmail.com"
    And user enter password "miyamiya1"
    And user clicks Login button
    Then user navigates to MyAccount
