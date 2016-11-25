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
    Given Input correct login and incorrect pass
    When I click login button
    Then I see text Неверный пароль. Повторите попытку.

  Scenario: EmptyPassword
    Given I open main page
    Given I go to auth page
    Given Input correct login
    When I click login button
    Then I see text Введите пароль.