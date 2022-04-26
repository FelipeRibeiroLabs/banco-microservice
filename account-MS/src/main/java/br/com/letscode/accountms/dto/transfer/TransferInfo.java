package br.com.letscode.accountms.dto.transfer;

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
}
