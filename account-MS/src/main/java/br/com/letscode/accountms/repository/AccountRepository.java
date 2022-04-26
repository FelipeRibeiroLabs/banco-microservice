package br.com.letscode.accountms.repository;

import br.com.letscode.accountms.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByCpf(String cpf);

    Account findByAccountNumberAndAgency(Integer accountNumber, Integer agency);
}
