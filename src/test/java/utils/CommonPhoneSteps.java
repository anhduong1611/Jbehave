package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CommonPhoneSteps {
    public ResponseServices responseServices;
    private ResponseEntity<String> response;

    public CommonPhoneSteps(ResponseServices responseServices) {
        this.responseServices = responseServices;
    }

    @Then("response message error $action")
    @Alias("show message $action")
    public void thenResponseMessageErrorUpdate() throws JsonProcessingException {
        this.response = this.responseServices.getResponse();
        System.out.println(response.getBody());
        assertEquals(404,response.getStatusCodeValue(),"Verify status code is 200");
        Set<String> attributes = Set.of("error");
        JsonUtils.verifyAttributeExist(response.getBody(),attributes);
    }
    @Then("response phone information")
    @Alias("response is valid")
    public void thenResponsePhoneInformation() throws JsonProcessingException {
        this.response = this.responseServices.getResponse();
        System.out.println(response.getBody());
        assertEquals(200,response.getStatusCodeValue(),"Verify status code is 200");
        assertEquals("application/json", Objects.requireNonNull(response.getHeaders().getContentType()).toString(),"Verify content type");
        Set<String> attributes = Set.of("id","name","data");
        JsonUtils.verifyAttributeExist(response.getBody(), attributes);
    }

    @Then("response correct data phone $file")
    public void thenResponseCorrectDataPhone(String file) throws URISyntaxException, IOException {
        this.response = this.responseServices.getResponse();
        System.out.println(response.getBody());
        String actualData = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(file).toURI())));
        JsonUtils.verifyDataMatches(actualData,this.response.getBody());
    }



}
