$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("betting.feature");
formatter.feature({
  "id": "user-management",
  "description": "",
  "name": "User Management",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "user-management;successful-registration;;2",
  "description": "",
  "name": "Successful Registration",
  "keyword": "Scenario Outline",
  "line": 10,
  "type": "scenario"
});
formatter.step({
  "name": "I am a user trying to register",
  "keyword": "Given ",
  "line": 4
});
formatter.step({
  "name": "I register providing  correct information",
  "keyword": "When ",
  "line": 5,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "I should be told that the registration was successful",
  "keyword": "Then ",
  "line": 6
});
formatter.match({
  "location": "StepDefinitions.I_am_trying_to_register()"
});
formatter.result({
  "duration": 11559756617,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.I_register_with()"
});
formatter.result({
  "duration": 1905496651,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.I_should_get_result()"
});
formatter.result({
  "duration": 1275413039,
  "status": "passed"
});
formatter.scenario({
  "id": "user-management;incorrect-registration-data;;2",
  "description": "",
  "name": "Incorrect registration data",
  "keyword": "Scenario Outline",
  "line": 20,
  "type": "scenario"
});
formatter.step({
  "name": "I am a user trying to register with incorrect data",
  "keyword": "Given ",
  "line": 13
});
formatter.step({
  "name": "I fill in a form with correct data",
  "keyword": "When ",
  "line": 14
});
formatter.step({
  "name": "I change the first_name field to have incorrect input 15Jfg",
  "keyword": "And ",
  "line": 15,
  "matchedColumns": [
    0,
    1
  ]
});
formatter.step({
  "name": "I should be told that the data in first_name is incorrect",
  "keyword": "Then ",
  "line": 16,
  "matchedColumns": [
    0
  ]
});
formatter.match({
  "location": "StepDefinitions.I_am_a_user_trying_to_register_with_incorrect_data()"
});
formatter.result({
  "duration": 3726520855,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.I_fill_in_a_form_with_correct_data()"
});
formatter.result({
  "duration": 1536997886,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "first_name",
      "offset": 13
    },
    {
      "val": "15Jfg",
      "offset": 54
    }
  ],
  "location": "StepDefinitions.I_change_field_to_have_incorrect_input(String,String)"
});
formatter.result({
  "duration": 391180747,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "first_name",
      "offset": 34
    }
  ],
  "location": "StepDefinitions.I_should_be_told_that_the_data_in_cvv_is_incorrect(String)"
});
formatter.result({
  "duration": 1240351724,
  "status": "passed"
});
formatter.scenario({
  "id": "user-management;incorrect-registration-data;;3",
  "description": "",
  "name": "Incorrect registration data",
  "keyword": "Scenario Outline",
  "line": 21,
  "type": "scenario"
});
formatter.step({
  "name": "I am a user trying to register with incorrect data",
  "keyword": "Given ",
  "line": 13
});
formatter.step({
  "name": "I fill in a form with correct data",
  "keyword": "When ",
  "line": 14
});
formatter.step({
  "name": "I change the last_name field to have incorrect input 15Jfg",
  "keyword": "And ",
  "line": 15,
  "matchedColumns": [
    0,
    1
  ]
});
formatter.step({
  "name": "I should be told that the data in last_name is incorrect",
  "keyword": "Then ",
  "line": 16,
  "matchedColumns": [
    0
  ]
});
formatter.match({
  "location": "StepDefinitions.I_am_a_user_trying_to_register_with_incorrect_data()"
});
formatter.result({
  "duration": 4099801256,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.I_fill_in_a_form_with_correct_data()"
});
formatter.result({
  "duration": 1484568113,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "last_name",
      "offset": 13
    },
    {
      "val": "15Jfg",
      "offset": 53
    }
  ],
  "location": "StepDefinitions.I_change_field_to_have_incorrect_input(String,String)"
});
formatter.result({
  "duration": 439930587,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "last_name",
      "offset": 34
    }
  ],
  "location": "StepDefinitions.I_should_be_told_that_the_data_in_cvv_is_incorrect(String)"
});
formatter.result({
  "duration": 1272366285,
  "status": "passed"
});
formatter.scenario({
  "id": "user-management;incorrect-registration-data;;4",
  "description": "",
  "name": "Incorrect registration data",
  "keyword": "Scenario Outline",
  "line": 22,
  "type": "scenario"
});
formatter.step({
  "name": "I am a user trying to register with incorrect data",
  "keyword": "Given ",
  "line": 13
});
formatter.step({
  "name": "I fill in a form with correct data",
  "keyword": "When ",
  "line": 14
});
formatter.step({
  "name": "I change the dob field to have incorrect input 06/12/2005",
  "keyword": "And ",
  "line": 15,
  "matchedColumns": [
    0,
    1
  ]
});
formatter.step({
  "name": "I should be told that the data in dob is incorrect",
  "keyword": "Then ",
  "line": 16,
  "matchedColumns": [
    0
  ]
});
formatter.match({
  "location": "StepDefinitions.I_am_a_user_trying_to_register_with_incorrect_data()"
});
formatter.result({
  "duration": 4153408589,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.I_fill_in_a_form_with_correct_data()"
});
formatter.result({
  "duration": 1451027052,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "dob",
      "offset": 13
    },
    {
      "val": "06/12/2005",
      "offset": 47
    }
  ],
  "location": "StepDefinitions.I_change_field_to_have_incorrect_input(String,String)"
});
formatter.result({
  "duration": 411504037,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "dob",
      "offset": 34
    }
  ],
  "location": "StepDefinitions.I_should_be_told_that_the_data_in_cvv_is_incorrect(String)"
});
formatter.result({
  "duration": 1267615438,
  "status": "passed"
});
formatter.scenario({
  "id": "user-management;incorrect-registration-data;;5",
  "description": "",
  "name": "Incorrect registration data",
  "keyword": "Scenario Outline",
  "line": 23,
  "type": "scenario"
});
formatter.step({
  "name": "I am a user trying to register with incorrect data",
  "keyword": "Given ",
  "line": 13
});
formatter.step({
  "name": "I fill in a form with correct data",
  "keyword": "When ",
  "line": 14
});
formatter.step({
  "name": "I change the credit_card_num field to have incorrect input 123565879",
  "keyword": "And ",
  "line": 15,
  "matchedColumns": [
    0,
    1
  ]
});
formatter.step({
  "name": "I should be told that the data in credit_card_num is incorrect",
  "keyword": "Then ",
  "line": 16,
  "matchedColumns": [
    0
  ]
});
formatter.match({
  "location": "StepDefinitions.I_am_a_user_trying_to_register_with_incorrect_data()"
});
formatter.result({
  "duration": 4132823370,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.I_fill_in_a_form_with_correct_data()"
});
formatter.result({
  "duration": 1515169067,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "credit_card_num",
      "offset": 13
    },
    {
      "val": "123565879",
      "offset": 59
    }
  ],
  "location": "StepDefinitions.I_change_field_to_have_incorrect_input(String,String)"
});
formatter.result({
  "duration": 438781584,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "credit_card_num",
      "offset": 34
    }
  ],
  "location": "StepDefinitions.I_should_be_told_that_the_data_in_cvv_is_incorrect(String)"
});
formatter.result({
  "duration": 1272833918,
  "status": "passed"
});
formatter.scenario({
  "id": "user-management;incorrect-registration-data;;6",
  "description": "",
  "name": "Incorrect registration data",
  "keyword": "Scenario Outline",
  "line": 24,
  "type": "scenario"
});
formatter.step({
  "name": "I am a user trying to register with incorrect data",
  "keyword": "Given ",
  "line": 13
});
formatter.step({
  "name": "I fill in a form with correct data",
  "keyword": "When ",
  "line": 14
});
formatter.step({
  "name": "I change the expiry_date field to have incorrect input 12/2013",
  "keyword": "And ",
  "line": 15,
  "matchedColumns": [
    0,
    1
  ]
});
formatter.step({
  "name": "I should be told that the data in expiry_date is incorrect",
  "keyword": "Then ",
  "line": 16,
  "matchedColumns": [
    0
  ]
});
formatter.match({
  "location": "StepDefinitions.I_am_a_user_trying_to_register_with_incorrect_data()"
});
formatter.result({
  "duration": 3541122247,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.I_fill_in_a_form_with_correct_data()"
});
formatter.result({
  "duration": 1505466575,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "expiry_date",
      "offset": 13
    },
    {
      "val": "12/2013",
      "offset": 55
    }
  ],
  "location": "StepDefinitions.I_change_field_to_have_incorrect_input(String,String)"
});
formatter.result({
  "duration": 306453959,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "expiry_date",
      "offset": 34
    }
  ],
  "location": "StepDefinitions.I_should_be_told_that_the_data_in_cvv_is_incorrect(String)"
});
formatter.result({
  "duration": 1316991764,
  "status": "passed"
});
formatter.scenario({
  "id": "user-management;successful-bet-of-free-account;;2",
  "description": "",
  "name": "Successful bet of free account",
  "keyword": "Scenario Outline",
  "line": 33,
  "type": "scenario"
});
formatter.step({
  "name": "I am a user with a free account",
  "keyword": "Given ",
  "line": 27
});
formatter.step({
  "name": "I try to place a bet of 5 euros",
  "keyword": "When ",
  "line": 28
});
formatter.step({
  "name": "I should be told the bet was successfully placed",
  "keyword": "Then ",
  "line": 29,
  "matchedColumns": [
    0
  ]
});
formatter.match({
  "location": "StepDefinitions.I_am_a_user_with_a_free_account()"
});
formatter.result({
  "duration": 4746238187,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 24
    }
  ],
  "location": "StepDefinitions.I_try_to_place_a_bet_of_euros(int)"
});
formatter.result({
  "duration": 842499623,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.I_should_be_told_that_the_bet_was_placed_successfully()"
});
formatter.result({
  "duration": 54197229,
  "status": "passed"
});
formatter.scenario({
  "id": "user-management;verify-maximum-bets-for-free-accounts;;2",
  "description": "",
  "name": "Verify maximum bets for free accounts",
  "keyword": "Scenario Outline",
  "line": 46,
  "type": "scenario"
});
formatter.step({
  "name": "I am a user with a \u003ctype\u003e account",
  "keyword": "Given ",
  "line": 36
});
formatter.step({
  "name": "I try to place a bet of 5 euros",
  "keyword": "When ",
  "line": 37,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "I should be told the bet was successfully placed",
  "keyword": "Then ",
  "line": 38
});
formatter.step({
  "name": "I try to place a bet of 5 euros",
  "keyword": "When ",
  "line": 39,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "I should be told the bet was successfully placed",
  "keyword": "Then ",
  "line": 40
});
formatter.step({
  "name": "I try to place a bet of 5 euros",
  "keyword": "When ",
  "line": 41,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "I should be told that I have reached the maximum number of bets",
  "keyword": "Then ",
  "line": 42
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 24
    }
  ],
  "location": "StepDefinitions.I_try_to_place_a_bet_of_euros(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinitions.I_should_be_told_that_the_bet_was_placed_successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 24
    }
  ],
  "location": "StepDefinitions.I_try_to_place_a_bet_of_euros(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinitions.I_should_be_told_that_the_bet_was_placed_successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 24
    }
  ],
  "location": "StepDefinitions.I_try_to_place_a_bet_of_euros(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinitions.I_should_be_told_that_I_have_reached_the_maximum_number_of_bets()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "id": "user-management;verify-maximum-cumulative-bet-for-premium-accounts;;2",
  "description": "",
  "name": "Verify maximum cumulative bet for premium accounts",
  "keyword": "Scenario Outline",
  "line": 57,
  "type": "scenario"
});
formatter.step({
  "name": "I am a user with a premium account",
  "keyword": "Given ",
  "line": 49
});
formatter.step({
  "name": "I try to place a bet of 5000 euros",
  "keyword": "When ",
  "line": 50,
  "matchedColumns": [
    0
  ]
});
formatter.step({
  "name": "I should be told the bet was successfully placed",
  "keyword": "Then ",
  "line": 51
});
formatter.step({
  "name": "I try to place a bet of 1 euros",
  "keyword": "When ",
  "line": 52,
  "matchedColumns": [
    1
  ]
});
formatter.step({
  "name": "I should be told that I have reached the maximum cumulative betting amount",
  "keyword": "Then ",
  "line": 53
});
formatter.match({
  "location": "StepDefinitions.I_am_a_user_with_a_premium_account()"
});
formatter.result({
  "duration": 4726002801,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5000",
      "offset": 24
    }
  ],
  "location": "StepDefinitions.I_try_to_place_a_bet_of_euros(int)"
});
formatter.result({
  "duration": 870904308,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.I_should_be_told_that_the_bet_was_placed_successfully()"
});
formatter.result({
  "duration": 61723085,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 24
    }
  ],
  "location": "StepDefinitions.I_try_to_place_a_bet_of_euros(int)"
});
formatter.result({
  "duration": 687861713,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.I_should_be_told_that_I_have_reached_the_maximum_cumulative_betting_amount()"
});
formatter.result({
  "duration": 1249309037,
  "status": "passed"
});
});