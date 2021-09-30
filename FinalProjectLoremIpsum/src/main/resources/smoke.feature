Feature: Smoke
  As a user
  I want to test main functions of the site
  So that I can be sure that sites main functionality works correctly

  Scenario Outline: Verify word
    Given User opens '<homePage>' page
    When User switches language to 'Russian'
    Then User checks that the first paragraph contains the word '<expectedWord>'

    Examples:
      | homePage                | expectedWord |
      | https://www.lipsum.com/ | рыба         |


  Scenario Outline: Verify default setting result
    Given User opens '<homePage>' page
    When User clicks on 'Generate Lorem Ipsum' button
    Then User checks that the first paragraph starts with text '<expectedText>'

    Examples:
      | homePage                | expectedText                                            |
      | https://www.lipsum.com/ | Lorem ipsum dolor sit amet, consectetur adipiscing elit |