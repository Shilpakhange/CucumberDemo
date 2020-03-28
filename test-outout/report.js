$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/Shilpa Khandge/eclipse-workspace/CucumberDemo/src/main/java/Features/Hooks.feature");
formatter.feature({
  "line": 1,
  "name": "FreeCRM application test",
  "description": "",
  "id": "freecrm-application-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 29935847200,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "FreeCRM create a new task test",
  "description": "",
  "id": "freecrm-application-test;freecrm-create-a-new-task-test",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@First"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user is on tasks page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user enters title and completion",
  "rows": [
    {
      "cells": [
        "shilpa",
        "50"
      ],
      "line": 7
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user verifies task is created for the below title",
  "rows": [
    {
      "cells": [
        "shilpa"
      ],
      "line": 9
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "HooksSteps.user_is_on_tasks_page()"
});
formatter.result({
  "duration": 1035560500,
  "status": "passed"
});
formatter.match({
  "location": "HooksSteps.user_enters_title_and_completion(DataTable)"
});
formatter.result({
  "duration": 2127238800,
  "status": "passed"
});
formatter.match({
  "location": "HooksSteps.user_verifies_task_is_created_for_the_below_title(DataTable)"
});
formatter.result({
  "duration": 2837303700,
  "status": "passed"
});
formatter.after({
  "duration": 708368000,
  "status": "passed"
});
});