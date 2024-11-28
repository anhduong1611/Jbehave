package steps.phone;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.jbehave.core.annotations.Named;
import utils.CommonPhoneMethod;
import utils.GlobalVariables;
import utils.ResponseServices;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import utils.JsonUtils;
import java.io.IOException;
import java.net.URISyntaxException;

public class AddPhoneSteps {
    public ResponseServices responseServices;
    private final String BASEURL = GlobalVariables.getUrl();
    private ResponseEntity<String> response;
    public AddPhoneSteps(ResponseServices responseServices){
        this.responseServices = responseServices;
    }
    @Given("I can create a phone with request data json")
    @Alias("I can create a phone with $file")
    public void givenICanCreateAPhone(String file) throws URISyntaxException, IOException {
        System.out.println("I can create a phone with request data json");
        String requestBody = JsonUtils.readDataJson(file);
        System.out.println("dataJSON"+requestBody);
        String url = BASEURL+"/objects";
        this.response = CommonPhoneMethod.sendUrlByMethodWithRequestBody(url,HttpMethod.POST,requestBody);
        this.responseServices.setResponse(response);
    }
    @When("I process data")
    public void whenIProccessData() throws JsonProcessingException {
        System.out.println("JsonRecevie"+this.response.getBody());
        CommonPhoneMethod.savePhoneIDToGlobalVar(this.response.getBody());
    }


}
