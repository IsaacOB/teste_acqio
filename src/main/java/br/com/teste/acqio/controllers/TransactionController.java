package br.com.teste.acqio.controllers;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.teste.acqio.dtos.TransactionDTO;
import br.com.teste.acqio.forms.TransactionForm;
import br.com.teste.acqio.forms.UpdateTransactionForm;
import br.com.teste.acqio.models.Transaction;
import br.com.teste.acqio.repositories.TransactionRepository;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionRepository repository;

	@GetMapping
	public List<TransactionDTO> transactionList() {
		List<Transaction> transactions = repository.findAll();
		return TransactionDTO.convert(transactions);
	}

	@PostMapping
	public ResponseEntity<TransactionDTO> createNewTransaction(@RequestBody @Valid TransactionForm form,
			UriComponentsBuilder builder) {
		Transaction transaction = form.convert();
		repository.save(transaction);

		URI uri = builder.path("/transaction/{id}").buildAndExpand(transaction.getId()).toUri();
		return ResponseEntity.created(uri).body(new TransactionDTO(transaction));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TransactionDTO> updateTransaction(@PathVariable Long id,
			@RequestBody @Valid UpdateTransactionForm form) {

		Transaction update = form.update(id, repository);

		return ResponseEntity.ok(new TransactionDTO(update));
	}

}
