package steps.phone;

import com.fasterxml.jackson.core.JsonProcessingException;
import utils.GlobalVariables;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import utils.JsonUtils;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetListPhoneSteps {

    private RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<String> response;
    private String URL = GlobalVariables.getUrl();
    @Given("I fetch list phone")
    public void givenIFetchListUser() {
            response = restTemplate.getForEntity(URL+"/objects", String.class);
    }

    @Then("response list of phones")
    public void thenResponseListOfUser() throws JsonProcessingException {
        assertEquals(200,response.getStatusCodeValue(),"Verify status code is 200");
        HttpHeaders headers = response.getHeaders();
        assertEquals("application/json",headers.getContentType().toString(), "Verify content type");
        Set<String> attributes = Set.of("id","name","data");
        JsonUtils.verifyAttributesJsonArray(response.getBody(),attributes);
    }
}
