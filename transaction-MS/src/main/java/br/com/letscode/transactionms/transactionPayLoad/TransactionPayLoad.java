package br.com.letscode.transactionms.transactionPayLoad;

import br.com.letscode.transactionms.transactionPayLoad.dto.TransferInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TransactionPayLoad {

    @Value("${transfer}")
    private String url;

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();

    public String doTransfer(TransferInfo transferInfo){
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<TransferInfo> entity = new HttpEntity<>(transferInfo ,headers);

        ResponseEntity<String> authInfo = restTemplate.exchange(url, HttpMethod.POST,
                entity, String.class);

        return authInfo.getBody();
    }
}
