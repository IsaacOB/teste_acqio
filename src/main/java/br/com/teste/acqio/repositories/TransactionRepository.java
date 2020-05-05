package br.com.teste.acqio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.acqio.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
