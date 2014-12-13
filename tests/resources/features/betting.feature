Feature: User Management

Scenario Outline: Successful Registration
Given I am a user trying to register
When I register providing  <type> information
Then I should be told that the registration was successful

Examples:
|type|
|correct|

Scenario Outline: Incorrect registration data
Given I am a user trying to register with incorrect data
When I fill in a form with correct data
And I change the <fieldname> field to have incorrect input <inp>
Then I should be told that the data in <fieldname> is incorrect

Examples:
|fieldname		|inp|
|first_name		|15Jfg|
|last_name		|15Jfg|
|dob			|06/12/2005|
|credit_card_num|123565879|
|expiry_date	|12/2013|

Scenario Outline: Successful bet of free account
Given I am a user with a free account
When I try to place a bet of 5 euros
Then I should be told the bet was <success> placed

Examples:
|success|
|successfully|

Scenario Outline: Verify maximum bets for free accounts
Given I am a user with a <type> account
When I try to place a bet of <amt> euros
Then I should be told the bet was successfully placed
When I try to place a bet of <amt> euros
Then I should be told the bet was successfully placed
When I try to place a bet of <amt> euros
Then I should be told that I have reached the maximum number of bets

Examples:
|amt|
|5|

Scenario Outline: Verify maximum cumulative bet for premium accounts
Given I am a user with a premium account
When I try to place a bet of <amt1> euros
Then I should be told the bet was successfully placed
When I try to place a bet of <amt2> euros
Then I should be told that I have reached the maximum cumulative betting amount

Examples:
|amt1|amt2|
|5000|1|


Scenario: Verify access restriction for guest users
Given I am a user who has not yet logged on
When I try to access the betting screen
Then I should be refused access

Scenario Outline: Verify that free users can only place low-risk bets
Given I am a free-account user
When I try to place a <risklevel> bet of 5 euros
Then I should be <expected> to bet

Examples:
|risklevel|expected|
|low|allowed|
|medium|not allowed|
|high|not allowed|
