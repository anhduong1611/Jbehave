package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;

public class CommonPhoneMethod {
    public static ResponseEntity<String>  sendUrlByMethodWithRequestBody(String url, HttpMethod method, String requestBody) throws URISyntaxException, IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<String> request = new HttpEntity<>(requestBody,headers);
        try {
            response = restTemplate.exchange(url, method, request, String.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            response = ResponseEntity.status(e.getStatusCode()).body("{\"error\": \"error"+e.getStatusCode()+"\"}");
            System.out.println(response.getBody());
        } catch (Exception e) {
            response = ResponseEntity.status(500).body("{\"error\": \"Internal Server Error\"}");
        }
        System.out.println("response.getBody(): "+response.getBody());
        return  response;
    }
    public static void savePhoneIDToGlobalVar(String response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response);
        String id = rootNode.get("id").asText();
        GlobalVariables.setIdPhone(id);
    }
}
