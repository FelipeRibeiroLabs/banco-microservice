package br.com.letscode.accountms.model;

import br.com.letscode.accountms.dto.AccountRequest;
import br.com.letscode.accountms.enums.AccountType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    private String cpf;
    private Integer accountNumber;
    private Integer agency;
    private Float balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @CreatedDate
    private LocalDateTime created;

    public Account(AccountRequest request){
        this.cpf = request.getCpf();
        this.accountType = AccountType.valueOf(request.getAccountType());
    }
}
