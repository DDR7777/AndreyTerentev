Feature: Ex1 test

  Scenario: Different Elements Page test
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "Different elements" button in Service dropdown
    Then "Different Elements" page should be opened
    When I select 'Water' checkbox
    And I select 'Wind' checkbox
    And I select 'Selen' radio
    And I select 'Yellow' dropdown
    Then 1 log row has "Water: condition changed to true" text in log section
    And 1 log row has "Wind: condition changed to true" text in log section
    And 1 log row has "metal: value changed to Selen" text in log section
    And 1 log row has "Colors: value changed to Yellow" text in log section

