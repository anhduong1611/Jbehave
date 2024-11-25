package steps.user;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetUserListSteps {
    private RestTemplate restTemplate = new RestTemplate();
    private static String URL = "https://1a4f0b17-e75c-4c45-a15a-3e5ebaf2df14.mock.pstmn.io/getList";
    private ResponseEntity<String> response;
    @Given("I fetch data from the API Get List")
    public void givenIFetchDataFromTheApiAtUrl() {
        System.out.println("I open API at " + URL);
        response = restTemplate.getForEntity(URL, String.class);
        assertEquals(200, response.getStatusCode(),"Verify status code is 200");
    }
    @When("I process the data")
    public void whenIProcessTheData() {
        System.out.println("Response Body: " + response.getBody());
    }

    @Then("I verify the results")
    public void thenIVerifyTheResults() throws IOException, URISyntaxException {
        System.out.println("I verify the results");
//        String expectedData = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("dataTest/listUser.json").toURI())));
//        String actualData = apiResponse.getBody().asString();
//        JsonUtils.verifyDataMatches(actualData,expectedData);
        HttpHeaders headers = response.getHeaders();
        assertEquals("application/json; charset=utf-8", headers.getContentType(), "Verify content type");
    }
}
