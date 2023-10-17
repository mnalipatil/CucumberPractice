@ui @healthcheck
Feature: E-commerce Project Website Health Checkup

@ProdSearch
Scenario: User is able to open the browser. nevigate to the URL and search for Product
Given user opened browser
When user navigate to the home application url
Then user search for product "Jeans"
Then Search result page is displayed wth page title keyword contains "Jeans"
