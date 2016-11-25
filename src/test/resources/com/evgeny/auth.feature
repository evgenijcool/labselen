Feature: Auth

  Scenario: SuccessAuth
    Given I open main page
    Given I go to auth page
    Given Input correct login and pass
    When I click login button
    Then I see my profile

  Scenario: WrongPassAuth
    Given I open main page
    Given I go to auth page
    Given Input correct login
    Given Input incorrect pass
    Given Ask to input CAPTCHA if needed
    When I click login button
    Then I see text неверен

  Scenario: EmptyPassword
    Given I open main page
    Given I go to auth page
    Given Ask to input CAPTCHA if needed
    When I click login button
    Then I see text значение необходимо