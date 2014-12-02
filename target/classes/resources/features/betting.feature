
Feature: User Management

Scenario Outline: Successful Registration
Given I am a user trying to register
When I register with details <username>, <password>,<first>,<last>,<dob>,<type>,<credit_num>,<expiry>,<cvv>
Then I should get the result <result>


Examples:

|username|password|first |last  |dob       |type |credit_num    |expiry |cvv|result|
|Jurgen	 |12345678|Jurgen|Cassar|25/04/1994|0	 |48334291014748|05/2017|123|true  |

