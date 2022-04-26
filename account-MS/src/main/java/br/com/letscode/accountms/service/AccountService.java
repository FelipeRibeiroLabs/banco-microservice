package br.com.letscode.accountms.service;

import br.com.letscode.accountms.dto.AccountRequest;
import br.com.letscode.accountms.dto.AccountResponse;
import br.com.letscode.accountms.dto.transfer.TransferInfo;
import br.com.letscode.accountms.model.Account;
import br.com.letscode.accountms.repository.AccountRepository;
import br.com.letscode.accountms.security.Authenticate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final Authenticate authenticate;

    public List<AccountResponse> allAccountsByCpf(String cpf, String token){
        if(!authenticate.checkAuth(token, cpf)){
            throw new RuntimeException("Usuário não autenticado");
        }
        return accountRepository.findAllByCpf(cpf).stream().map(AccountResponse::new).collect(Collectors.toList());
    }

    public AccountResponse createAccount(AccountRequest request, String token){
        if(!authenticate.checkAuth(token, request.getCpf())){
            throw new RuntimeException("Usuário não autenticado");
        }

        Account account = new Account(request);
        account.setAgency((int) (Math.random()*(9999-1000+1) + 1000));
        account.setAccountNumber((int) (Math.random()*(999999-100000+1) + 100000));
        account.setBalance(100f);
        account.setCreated(LocalDateTime.now());
        accountRepository.save(account);

        return new AccountResponse(account);
    }

    public String transfer(TransferInfo transferInfo) {
        Account transferSender = accountRepository.findByAccountNumberAndAgency(transferInfo.getSenderAccountNumber(), transferInfo.getSenderAgency());
        Account transferReceiver = accountRepository.findByAccountNumberAndAgency(transferInfo.getReceiverAccountNumber(), transferInfo.getReceiverAgency());

        Float senderBalance = transferSender.getBalance();

        if(senderBalance < transferInfo.getValue()){
            throw new RuntimeException("Insufficient funds!");
        }

        transferSender.setBalance(senderBalance - transferInfo.getValue());
        transferReceiver.setBalance(transferReceiver.getBalance() + transferInfo.getValue());

        accountRepository.save(transferSender);
        accountRepository.save(transferReceiver);

        return "Transfer succeed!";
    }
}
