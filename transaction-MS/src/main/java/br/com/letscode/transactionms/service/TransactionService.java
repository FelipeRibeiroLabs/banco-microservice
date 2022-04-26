package br.com.letscode.transactionms.service;

import br.com.letscode.transactionms.dto.FindTransactionRequest;
import br.com.letscode.transactionms.dto.TransactionRequest;
import br.com.letscode.transactionms.dto.TransactionResponse;
import br.com.letscode.transactionms.model.Transaction;
import br.com.letscode.transactionms.repository.TransactionRepository;
import br.com.letscode.transactionms.security.Authenticate;
import br.com.letscode.transactionms.transactionPayLoad.TransactionPayLoad;
import br.com.letscode.transactionms.transactionPayLoad.dto.TransferInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionPayLoad transactionPayLoad;
    private final Authenticate authenticate;

    public String createTransaction(TransactionRequest request, String cpf, String token){
        if(!authenticate.checkAuth(token, cpf)){
            throw new RuntimeException("Usuário não autenticado");
        }

        //todo -> Check if cpf used in authentication has the account placed has sender

        Transaction transaction = new Transaction(request);
        transaction.setTransferedAt(LocalDateTime.now());

        transactionRepository.save(transaction);

        return transactionPayLoad.doTransfer(new TransferInfo(request));
    }

    public Map<String ,List<TransactionResponse>> getAllTransactionsByAccount(FindTransactionRequest request, String cpf, String token){
        if(!authenticate.checkAuth(token, cpf)){
            throw new RuntimeException("Usuário não autenticado");
        }

        List<Transaction> senderTransactions = transactionRepository
                                        .findAllBySenderAccountNumberAndSenderAgency(request.getAccountNumber(), request.getAgencyNumber());

        List<Transaction> receiverTransactions = transactionRepository
                .findAllByReceiverAccountNumberAndReceiverAgency(request.getAccountNumber(), request.getAgencyNumber());

        Map<String, List<TransactionResponse>> transactions = new HashMap<>();
        transactions.put("Sended transactions",
                senderTransactions.stream().map(TransactionResponse::new).collect(Collectors.toList()));
        transactions.put("Received transactions",
                receiverTransactions.stream().map(TransactionResponse::new).collect(Collectors.toList()));



        return transactions;
    }
}
