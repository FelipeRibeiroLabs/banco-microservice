package br.com.letscode.accountms.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class Authenticate {

    @Value("${auth.checktoken}")
    private String url;


    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();

    public Boolean checkAuth(String token, String cpf){
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<Boolean> authInfo = restTemplate.exchange(url + "token" + token + "/cpf" + cpf, HttpMethod.GET,
                entity, Boolean.class);

        return authInfo.getBody();
    }
}
