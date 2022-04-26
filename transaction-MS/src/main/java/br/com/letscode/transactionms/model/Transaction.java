package br.com.letscode.transactionms.model;

import br.com.letscode.transactionms.dto.TransactionRequest;
import br.com.letscode.transactionms.enums.TransferType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    private Integer senderAccountNumber;
    private Integer senderAgency;
    private Integer receiverAccountNumber;
    private Integer receiverAgency;

    private TransferType transferType;
    private Float value;

    @CreatedDate
    private LocalDateTime transferedAt;

    public Transaction(TransactionRequest request){
        this.senderAccountNumber = request.getSenderAccountNumber();
        this.senderAgency = request.getSenderAgency();
        this.receiverAccountNumber = request.getReceiverAccountNumber();
        this.receiverAgency = request.getReceiverAgency();
        this.transferType = TransferType.valueOf(request.getTransferType());
        this.value = request.getValue();
    }
}