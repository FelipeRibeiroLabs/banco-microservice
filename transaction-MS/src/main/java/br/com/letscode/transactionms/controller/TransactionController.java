package br.com.letscode.transactionms.controller;

import br.com.letscode.transactionms.dto.FindTransactionRequest;
import br.com.letscode.transactionms.dto.TransactionRequest;
import br.com.letscode.transactionms.dto.TransactionResponse;
import br.com.letscode.transactionms.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/create")
    public String createTransaction(@RequestBody TransactionRequest request,
                                                 @RequestParam String cpf,
                                                 @RequestParam String token){
        return transactionService.createTransaction(request, cpf, token);
    }

    @GetMapping
    public Map<String, List<TransactionResponse>> getAllTransactionsByAccount(
            @RequestBody FindTransactionRequest request,
            @RequestParam String cpf,
            @RequestParam String token){
        return transactionService.getAllTransactionsByAccount(request, cpf, token);
    }
}
