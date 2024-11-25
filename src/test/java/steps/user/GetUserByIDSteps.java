package steps.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import utils.JsonUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetUserByIDSteps {
    private Response apiResponse ;
    @Given("I am in search user page")
    public void givenIAmInSearchUserPage() {
        System.out.println("I am in search user page");
    }

    @Given("the field search display")
    public void givenTheFieldSearchDisplay() {
        System.out.println("the field search display");
    }
    @When("I enter id $id into search field and enter search button")
    public void whenIenterId(@Named("id") String id) {
        String baseUrl = "https://1a4f0b17-e75c-4c45-a15a-3e5ebaf2df14.mock.pstmn.io/user/";
        apiResponse = RestAssured
                .given()
                .baseUri(baseUrl)
                .pathParam("id", id)
                .when()
                .get("{id}");
    }

    @Then("the user information correctly displayed")
    public void thenTheUserInformationCorrectlyDisplayed() throws IOException, URISyntaxException {
        System.out.println("Then the user information correctly displayed");
        assertEquals(200,apiResponse.statusCode(),"Verify status code is 200");
        String expectedData = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("dataTest/userID123.json").toURI())));
        String actualData = apiResponse.getBody().asString();
        JsonUtils.verifyDataMatches(actualData,expectedData);
    }

    @Then("the result indicate \"No found the user because id not existed\"")
    public void thenTheResultIndicateNoFoundTheUserBecauseIdNotExisted() throws IOException, URISyntaxException {
        assertEquals(404,apiResponse.statusCode(),"Verify status code is 404");
        String expectedData = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("dataTest/userMessageIDnotExisted.json").toURI())));
        String actualData = apiResponse.getBody().asString();
        JsonUtils.verifyDataMatches(actualData,expectedData);
    }



}
