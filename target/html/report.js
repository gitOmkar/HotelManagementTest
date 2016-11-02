$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MyFirstFeatureFile.feature");
formatter.feature({
  "id": "my-first-feature-or-user-story",
  "description": "",
  "name": "My First Feature or User Story",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "my-first-feature-or-user-story;my-first-scenario",
  "tags": [
    {
      "name": "@Wiki",
      "line": 3
    }
  ],
  "description": "",
  "name": "My First Scenario",
  "keyword": "Scenario",
  "line": 4,
  "type": "scenario"
});
formatter.step({
  "name": "I am on website",
  "keyword": "Given ",
  "line": 5
});
formatter.step({
  "name": "I click on link",
  "keyword": "When ",
  "line": 6
});
formatter.step({
  "name": "Navigated page should be correct",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "location": "Steps.i_am_on_website()"
});
formatter.result({
  "duration": 4897667720,
  "status": "passed"
});
formatter.match({
  "location": "Steps.i_click_on_link()"
});
formatter.result({
  "duration": 476878984,
  "status": "passed"
});
formatter.match({
  "location": "Steps.navigated_page_should_be_correct()"
});
formatter.result({
  "duration": 466453538,
  "status": "passed"
});
});