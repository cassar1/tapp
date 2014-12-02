$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("betting.feature");
formatter.feature({
  "id": "user-management",
  "description": "",
  "name": "User Management",
  "keyword": "Feature",
  "line": 2
});
formatter.scenario({
  "id": "user-management;successful-registration;;2",
  "description": "",
  "name": "Successful Registration",
  "keyword": "Scenario Outline",
  "line": 13,
  "type": "scenario"
});
formatter.step({
  "name": "I am a user trying to register",
  "keyword": "Given ",
  "line": 5
});
formatter.step({
  "name": "I register with details Jurgen, 12345678,Jurgen,Cassar,25/04/1994,0,48334291014748,05/2017,123",
  "keyword": "When ",
  "line": 6,
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8
  ]
});
formatter.step({
  "name": "I should get the result true",
  "keyword": "Then ",
  "line": 7,
  "matchedColumns": [
    9
  ]
});
formatter.match({
  "location": "StepDefinitions.I_am_trying_to_register()"
});
formatter.result({
  "duration": 95490337,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "details Jurgen",
      "offset": 16
    },
    {
      "val": " 12345678",
      "offset": 31
    },
    {
      "val": "Jurgen",
      "offset": 41
    },
    {
      "val": "Cassar",
      "offset": 48
    },
    {
      "val": "25/04/1994",
      "offset": 55
    },
    {
      "val": "0",
      "offset": 66
    },
    {
      "val": "48334291014748",
      "offset": 68
    },
    {
      "val": "05/2017",
      "offset": 83
    },
    {
      "val": "123",
      "offset": 91
    }
  ],
  "location": "StepDefinitions.I_register_with(String,String,String,String,String,int,String,String,String)"
});
formatter.result({
  "duration": 4681725,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "true",
      "offset": 24
    }
  ],
  "location": "StepDefinitions.I_should_get_result(String)"
});
formatter.result({
  "duration": 2470713,
  "status": "passed"
});
});