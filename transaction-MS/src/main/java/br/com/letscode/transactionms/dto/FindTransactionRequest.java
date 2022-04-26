package br.com.letscode.transactionms.dto;

import lombok.Data;

@Data
public class FindTransactionRequest {

    private Integer accountNumber;
    private Integer agencyNumber;
}
