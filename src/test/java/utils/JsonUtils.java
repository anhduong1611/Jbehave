package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static void verifyDataMatches(String actualData,String expectedData) throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode  actualObject = objectMapper.readTree(actualData);
        JsonNode  expectedObject = objectMapper.readTree(expectedData);
        assertEquals(actualObject.get("name"),expectedObject.get("name"),"API response attribute name correct ");
        assertEquals(actualObject.get("data"),expectedObject.get("data"),"API response attribute data correct ");
    }
    public static void verifyAttributeExist(String responseBody, Set<String> attributes) throws JsonProcessingException  {
        JsonNode data = objectMapper.readTree(responseBody);
        for (String attribute : attributes) {
            assertTrue(data.has(attribute), "Verify phone should have '" + attribute + "'");
        }
    }
    public static void verifyAttributesJsonArray(String response,Set<String> attributes) throws JsonProcessingException {
        List<Map<String, Object>> phones = objectMapper.readValue(response, new TypeReference<List<Map<String, Object>>>() {});
        for (Map<String, Object> phone : phones) {
            verifyAttributesInMap(phone, attributes);
        }
    }
    public static String readDataJson(String fileName) throws URISyntaxException, IOException {
        String data = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(fileName).toURI())));
        return data;
    }
    private static void verifyAttributesInMap(Map<String, Object> object, Set<String> requiredAttributes) {
        for (String attribute : requiredAttributes) {
            assertTrue(object.containsKey(attribute), "The attribute '" + attribute + "' is missing in the object: " + object);
        }
    }



}
