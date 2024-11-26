Meta:
Narrative:
As a user
I want to delete phone

GivenStories: add_phone_test.story
Scenario: Phone is deleted successfully
Given I can delete the phone id idExisted
Then response message "Delete successfully"

Scenario: Phone is not deleted because id phone not existed
Meta:
@skip
Given I can delete the phone id idNotExisted
Then response message error delete