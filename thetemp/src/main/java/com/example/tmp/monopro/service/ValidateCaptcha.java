package com.example.tmp.monopro.service;



import com.example.tmp.monopro.dto.CaptchaResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;


@Service
public class ValidateCaptcha {
    static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(ValidateCaptcha.class.getName());
    @Value("${google.recaptcha.verification.endpoint}")
    String GOOGLE_RECAPTCHA_ENDPOINT;
    @Value("${google.recaptcha.secret}")
    String RECAPTCHA_SECRET;



    public boolean validateCaptcha(String captchaResponse){
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
        requestMap.add("secret", RECAPTCHA_SECRET);
        requestMap.add("response", captchaResponse);
        LOGGER.log(Level.INFO, "Going to validate the captcha response = {0}", captchaResponse);
        CaptchaResponse apiResponse = restTemplate.postForObject(GOOGLE_RECAPTCHA_ENDPOINT, requestMap, CaptchaResponse.class);
        if(apiResponse == null){
            return false;
        }

        return Boolean.TRUE.equals(apiResponse.isSuccess());
    }

}



