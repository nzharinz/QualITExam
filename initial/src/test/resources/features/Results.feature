Feature:  I want to be able to view Bullseye results in lotto webpage

  Scenario: Log into an existing lotto account
    Given I am in "https://mylotto.co.nz/"
    When I click 'Results'
    And Select 'Bullseye'
    Then I see the Winning Number displayed