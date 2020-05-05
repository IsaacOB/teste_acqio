package br.com.teste.acqio.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.teste.acqio.enums.CardApplicationEnum;
import br.com.teste.acqio.enums.StatusEnum;
import br.com.teste.acqio.models.Transaction;

public class TransactionDTO {

	private Long id;
	private LocalDate date;
	private LocalDateTime time;
	private BigDecimal value;
	private CardApplicationEnum cardApplication;
	private StatusEnum status;

	public TransactionDTO(Transaction transaction) {

		this.id = transaction.getId();
		this.date = transaction.getDate();
		this.time = transaction.getTime();
		this.value = transaction.getValue();
		this.cardApplication = transaction.getCardApplication();
		this.status = transaction.getStatus();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

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

	public static List<TransactionDTO> convert(List<Transaction> transactions) {
		return transactions.stream().map(TransactionDTO::new).collect(Collectors.toList());
	}

}
