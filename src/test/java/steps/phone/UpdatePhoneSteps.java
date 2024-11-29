package steps.phone;

import utils.CommonPhoneMethod;
import utils.GlobalVariables;
import utils.ResponseServices;
import org.jbehave.core.annotations.*;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import utils.JsonUtils;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
//Change repo
public class UpdatePhoneSteps {
    public ResponseServices context;
    private ResponseEntity<String> response;
    public UpdatePhoneSteps(ResponseServices context){
        this.context = context;
    }
    @Given("I can update the phone id $id with $file")
    public void givenICanUpdateThePhoneWithRequestDataUpdateBody(String id,String file) throws URISyntaxException, IOException {
        if(id.equals("idExisted"))
            id = GlobalVariables.getIdPhone();
        else id = "1222";
        String url = GlobalVariables.getUrl() + "/objects/" + id;
        String requestBody = JsonUtils.readDataJson(file);
        this.response = CommonPhoneMethod.sendUrlByMethodWithRequestBody(url,HttpMethod.PUT,requestBody);
        this.context.setResponse(response);
    }

}
