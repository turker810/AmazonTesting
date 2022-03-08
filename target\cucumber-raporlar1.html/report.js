$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/uiFeature/us02.feature");
formatter.feature({
  "name": "Verify if a user will be able to sign in with a invalid username and invalid password.",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@us02"
    }
  ]
});
formatter.scenario({
  "name": "User will be able to sign in with invalid credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@us02"
    }
  ]
});
formatter.step({
  "name": "User navigates to \"https://www.amazon.com/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "US02StepDef.user_navigates_to(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on sign in button",
  "keyword": "Then "
});
formatter.match({
  "location": "US02StepDef.user_clicks_on_sign_in_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User types invalid credentials",
  "keyword": "Then "
});
formatter.match({
  "location": "US02StepDef.user_types_invalid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on submit button",
  "keyword": "When "
});
formatter.match({
  "location": "US02StepDef.user_clicks_on_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verifies that user can not sign in",
  "keyword": "And "
});
formatter.match({
  "location": "US02StepDef.user_verifies_that_nosign_in()"
});
formatter.result({
  "status": "passed"
});
});