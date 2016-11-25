Feature: Search

  Scenario: Empty search
    Given I open main page
    When Click search button
    Then I see text Служебная страница
    Then I see text Поиск

  Scenario Outline: Real search
    Given I open main page
    And Input <query> into search
    When Click search button
    Then I see text <found>
    Examples:
    | query   | found  |
    | Сергей Лукьяненко | Лукьяненко, Сергей Васильевич |
    | Жаба | Жабы |
    | ыпрфдпдфрпдлпрдпдывпрывдпрвдыжывждджып | Соответствий запросу не найдено |