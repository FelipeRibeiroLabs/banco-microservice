package br.com.letscode.transactionms.repository;

import br.com.letscode.transactionms.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllBySenderAccountNumberAndSenderAgency(
            Integer senderAccountNumber,
            Integer senderAgency);

    List<Transaction> findAllByReceiverAccountNumberAndReceiverAgency(
            Integer receiverAccountNumber,
            Integer receiverAgency);
}
