Feature: Search and place the order fro products


@OffersPage
Scenario Outline: Search Experience for product search in both home and offers page

Given User is on GreenCart Landing page
When User searched with Shortname <Name> and extracted actual name of product
Then user searched for <Name> Shortname in offer page
And validate product name in offers page match with landing page

Examples: 
| Name |
| Tom  |
| Beet |
