package br.com.letscode.userms.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class GetAuth {

    @Value("${auth.gerar}")
    private String url;

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();

    public String authenticate(String cpf){

        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<String> authInfo = restTemplate.exchange(url + cpf, HttpMethod.GET,
                entity, String.class);

        return authInfo.getBody();
    }

    public Boolean checkAuth(String token){
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<Boolean> authInfo = restTemplate.exchange(url, HttpMethod.GET,
                entity, Boolean.class, token);

        return authInfo.getBody();
    }
}