Meta:

Narrative:
As a user
I want to find the phone by ID

Scenario: Phone is found by ID
Meta:
Given I can fetch phone by ID idExisted
Then response phone information

Scenario: Phone is not found by ID because ID not existed
Meta:
Given I can fetch phone by ID idNotExisted
Then response message error notFound