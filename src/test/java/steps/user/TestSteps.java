package steps.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import utils.JsonUtils;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSteps {
    private static String URL = "https://api.restful-api.dev";
    private ResponseEntity<String> response;
    private RestTemplate restTemplate = new RestTemplate();
    @Given("I can fetch user by ID $id")
    public void givenIFetchUserById(String id) {
        id = String.valueOf(id.equals("idNotExisted")?1222:1);
        String url = URL+"/objects/"+id;


        try {
            response = restTemplate.getForEntity(url, String.class);
        } catch (HttpClientErrorException e) {
            response = ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString()); // Lưu lại phản hồi lỗi nếu có
        }
    }

    @Then("response user information")
    public void thenResponseUserInformation() throws JsonProcessingException {
        assertEquals(200,response.getStatusCodeValue(),"Verify status code is 200");
        assertEquals("application/json",response.getHeaders().getContentType().toString(),"Verify content type");
        Set<String> attributes = Set.of("id","name","data");
        JsonUtils.verifyAttributeExist(response.getBody(),attributes);
    }
    @Then("response message error \"Object with id was not found\"")
    public void thenResponseMessageErrorObjectWithIdWasNotFound() {
        assertEquals(404, response.getStatusCodeValue(), "Verify status code is 404");
    }
}
