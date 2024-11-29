package steps.phone;

import com.fasterxml.jackson.core.JsonProcessingException;
import utils.GlobalVariables;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import utils.JsonUtils;

import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetListPhoneSteps {
    private final RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<String> response;
    @Given("I fetch list phone")
    public void givenIFetchListUser() {
            response = restTemplate.getForEntity(GlobalVariables.getUrl()+"/objects", String.class);
    }

    @Then("response list of phones")
    public void thenResponseListOfUser() throws JsonProcessingException {
        assertEquals(200,response.getStatusCodeValue(),"Verify status code is 200");
        HttpHeaders headers = response.getHeaders();
        assertEquals("application/json", Objects.requireNonNull(headers.getContentType()).toString(), "Verify content type");
        Set<String> attributes = Set.of("id","name","data");
        JsonUtils.verifyAttributesJsonArray(response.getBody(),attributes);
    }
}
