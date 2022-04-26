package br.com.letscode.transactionms.transactionPayLoad.dto;


import br.com.letscode.transactionms.dto.TransactionRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransferInfo {

    private Integer senderAccountNumber;
    private Integer senderAgency;
    private Integer receiverAccountNumber;
    private Integer receiverAgency;
    private Float value;

    public TransferInfo(TransactionRequest request){
        this.senderAccountNumber = request.getSenderAccountNumber();
        this.senderAgency = request.getSenderAgency();
        this.receiverAccountNumber = request.getReceiverAccountNumber();
        this.receiverAgency = request.getReceiverAgency();
        this.value = request.getValue();
    }
}

