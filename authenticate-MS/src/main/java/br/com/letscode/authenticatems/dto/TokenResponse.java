package br.com.letscode.authenticatems.dto;

import br.com.letscode.authenticatems.model.Token;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class TokenResponse {

    private String token;
    private String cpf;
    private Timestamp expiration;

    public TokenResponse(Token token){
        this.token = token.getToken();
        this.cpf = token.getCpf();
        this.expiration = token.getExpiration();
    }
}
