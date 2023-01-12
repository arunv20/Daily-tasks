package com.te.validation.validation;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Data
@Component
@NoArgsConstructor
public class AadhaarApi {

    private final  String API_KEY = "";
    private final  String API_URL = "https://aadhaarapi.com/validate";



    public boolean validateAadhaarNumber(Integer aadhaarNumber) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + "?aadhaarNumber=" + aadhaarNumber + "&apiKey=" + API_KEY;
        try {
            String response = restTemplate.getForObject(url, String.class);
            assert response != null;
            return response.contains("valid");
        } catch (Exception e) {
            return false;
        }
    }

}
