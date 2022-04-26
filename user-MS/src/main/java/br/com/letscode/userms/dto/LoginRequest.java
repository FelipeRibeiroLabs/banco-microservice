package br.com.letscode.userms.dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String cpf;
    private String password;
}
