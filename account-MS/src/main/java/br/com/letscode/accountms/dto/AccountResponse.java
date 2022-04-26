package br.com.letscode.accountms.dto;

import br.com.letscode.accountms.model.Account;
import lombok.Data;

@Data
public class AccountResponse {

    private String cpf;
    private String accountType;
    private Integer accountNumber;
    private Integer agency;

    public AccountResponse(Account request){
        this.cpf = request.getCpf();
        this.accountType = String.valueOf(request.getAccountType());
        this.accountNumber = request.getAccountNumber();
        this.agency = request.getAgency();
    }
}
