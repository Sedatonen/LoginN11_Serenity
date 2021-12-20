Feature: Login n11.com with facebook

  Scenario:users login to n11 with facebook
    Given user launch browser and open the n11 main page
    When user login n11 with facebook valid credentials
    Then user verify the logged in successfully
