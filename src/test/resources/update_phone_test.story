Meta:
@skip
Narrative:
As a user
I want to update phone
!-- Given when then and
GivenStories: add_phone_test.story
Scenario: Phone is updated successfully
Given I can update the phone id idExisted with <fileJson>
When I process data
Then response phone information
And response correct data phone <fileJson>
Examples:
| fileJson   |
|------------|
| dataTest/updatePhoneData.json|

Scenario: Phone is not updated because id phone not existed
Given I can update the phone id idNotExisted with <fileJson>
Then response message error update

Examples:
| fileJson   |
|------------|
| dataTest/updatePhoneData.json|