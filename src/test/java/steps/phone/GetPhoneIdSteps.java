package steps.phone;

import org.springframework.http.HttpMethod;
import utils.CommonPhoneMethod;
import utils.GlobalVariables;
import utils.ResponseServices;
import org.jbehave.core.annotations.Given;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetPhoneIdSteps {
    private String URL = GlobalVariables.getUrl();
    private ResponseEntity<String> response;
    private ResponseServices context;
    public  GetPhoneIdSteps(ResponseServices context){
        this.context = context;
    }
    @Given("I can fetch phone by ID $id")
    public void givenIFetchUserById(String id) throws URISyntaxException, IOException {
        id = String.valueOf(id.equals("idNotExisted")?1222:1);
        String url = URL+"/objects/"+id;
        this.response = CommonPhoneMethod.sendUrlByMethodWithRequestBody(url, HttpMethod.GET,"");
        context.setResponse(response);
    }


}
