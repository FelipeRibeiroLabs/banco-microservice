package br.com.letscode.transactionms.dto;

import br.com.letscode.transactionms.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionRequest {

    private Integer senderAccountNumber;
    private Integer senderAgency;
    private Integer receiverAccountNumber;
    private Integer receiverAgency;

    private String transferType;
    private Float value;

    public TransactionRequest(Transaction request){
        this.senderAccountNumber = request.getSenderAccountNumber();
        this.senderAgency = request.getSenderAgency();
        this.receiverAccountNumber = request.getReceiverAccountNumber();
        this.receiverAgency = request.getReceiverAgency();
        this.transferType = String.valueOf(request.getTransferType());
        this.value = request.getValue();
    }
}
