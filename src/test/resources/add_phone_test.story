Meta:
@skip
Narrative:
As a user
I want to add phone
Scenario: Phone is successfully added
Given I can create a phone with <fileJson>
When I process data
Then response is valid
And response correct data phone <fileJson>

Examples:
| fileJson   |
|------------|
| dataTest/addPhoneData2.json|
!-- | dataTest/addPhoneData2.json|



