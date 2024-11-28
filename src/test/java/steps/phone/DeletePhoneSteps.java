package steps.phone;

import utils.CommonPhoneMethod;
import utils.GlobalVariables;
import utils.ResponseServices;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeletePhoneSteps {
    private String url = GlobalVariables.getUrl();
    private RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<String> response;
    private ResponseServices context;
    public DeletePhoneSteps(ResponseServices context){
        this.context = context;
    }
    @Given("I can delete the phone id $id")
    public void givenICanDeleteThePhoneIdIdexisted(String id) throws URISyntaxException, IOException {
        if(id.equals("idExisted"))
            id = GlobalVariables.getIdPhone();
        this.response= CommonPhoneMethod.sendUrlByMethodWithRequestBody(url+"/objects/"+id,HttpMethod.DELETE,"");
        this.context.setResponse(response);
    }

    @Then("response message \"Delete successfully\"")
    public void thenResponseMessageDeleteSuccessfully() {
        assertEquals(200,response.getStatusCodeValue(),"Verify status code is 200");
        HttpHeaders headers = response.getHeaders();
        assertEquals("application/json",headers.getContentType().toString(), "Verify content type");
    }
}
