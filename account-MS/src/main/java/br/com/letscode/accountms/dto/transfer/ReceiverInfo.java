package br.com.letscode.accountms.dto.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReceiverInfo {

    private Integer accountNumber;
    private Integer agency;
}
