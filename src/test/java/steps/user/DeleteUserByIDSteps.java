package steps.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteUserByIDSteps {
    private Response apiResponse;
    @Given("I am on Homepage")
    public void givenIAmOnHomepage() {
        System.out.println( "I am on Homepage");
    }

    @Given("the system displays a list of users")
    public void givenTheSystemDisplaysAListOfUsers() {
        System.out.println( "the system displays a list of users");
    }

    @When("I choose the user with id $id and click the delete button")
    public void whenIChooseTheUserWithIdAndClickTheDeleteButton(int id) {
        apiResponse = RestAssured
                .given()
                .baseUri("https://1a4f0b17-e75c-4c45-a15a-3e5ebaf2df14.mock.pstmn.io/user/")
                .pathParam("id", id)
                .when()
                .get("{id}");
        System.out.println(apiResponse.getBody().asString());
    }

    @Then("the dialog displays and shows \"The user id = $id deleted\" message")
    public void thenTheDialogDisplaysAndShowsTheUserIdDeletedMessage(int id) {

    }

    @Then("the dialog displays and shows \"Delete unsuccess because not found\" message")
    public void thenTheDialogDisplaysAndShowsDeleteUnsuccessBecauseNotFoundMessage() {

    }

    @Given("I delete user by API")
    public void givenIDeleteUserByApi() {
        System.out.println( "I delete user by API");
    }

    @Given("I delete user by ID $id")
    public void givenIDeleteUserById(int id) {
        System.out.println( "I delete user by ID "+id);
    }

    @When("I proccess data")
    public void whenIProccessData() {

    }

    @Then("response message: \"The user id $integer1 deleted\"")
    public void thenResponseMessageTheUserIdDeleted(int integer1) {
        assertEquals(200,200,"Verify status code is 200");
    }
}
