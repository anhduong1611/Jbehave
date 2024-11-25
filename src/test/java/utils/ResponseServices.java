package utils;

import org.springframework.http.ResponseEntity;

public class ResponseServices {
    private ResponseEntity<String> response;
    public ResponseEntity<String> getResponse() {
        return response;
    }
    public void setResponse(ResponseEntity<String> response) {
        this.response = response;
    }
}
