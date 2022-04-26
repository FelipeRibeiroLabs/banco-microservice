package br.com.letscode.accountms.controller;

import br.com.letscode.accountms.dto.AccountRequest;
import br.com.letscode.accountms.dto.AccountResponse;
import br.com.letscode.accountms.dto.transfer.TransferInfo;
import br.com.letscode.accountms.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public AccountResponse createAccount(@RequestBody AccountRequest request, @RequestParam String token){
        return accountService.createAccount(request, token);
    }

    @GetMapping()
    public List<AccountResponse> getAllAccounts(@RequestParam String cpf, @RequestParam String token){
        return accountService.allAccountsByCpf(cpf, token);
    }

    @PostMapping("/transfer")
    public String transfer(@RequestBody TransferInfo transferInfo){
        return accountService.transfer(transferInfo);
    }
}
