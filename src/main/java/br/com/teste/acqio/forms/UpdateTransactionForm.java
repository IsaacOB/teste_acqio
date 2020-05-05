package br.com.teste.acqio.forms;

import java.math.BigDecimal;

import br.com.teste.acqio.enums.CardApplicationEnum;
import br.com.teste.acqio.enums.StatusEnum;
import br.com.teste.acqio.models.Transaction;
import br.com.teste.acqio.repositories.TransactionRepository;

public class UpdateTransactionForm {

	private BigDecimal value;
	private CardApplicationEnum cardApplication;
	private StatusEnum status;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public CardApplicationEnum getCardApplication() {
		return cardApplication;
	}

	public void setCardApplication(CardApplicationEnum cardApplication) {
		this.cardApplication = cardApplication;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Transaction update(Long id, TransactionRepository repository) {
		
		Transaction transaction = repository.getOne(id);
		transaction.setCardApplication(this.cardApplication);
		transaction.setStatus(this.status);
		transaction.setValue(this.value);
		
		return transaction;
		
	}

}
