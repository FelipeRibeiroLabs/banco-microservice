package br.com.letscode.accountms.dto;

import lombok.Data;

@Data
public class AccountRequest {
    private String cpf;
    private String accountType;
}
