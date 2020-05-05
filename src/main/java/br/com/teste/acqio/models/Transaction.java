package br.com.teste.acqio.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.teste.acqio.enums.CardApplicationEnum;
import br.com.teste.acqio.enums.StatusEnum;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate date = LocalDate.now();
	private LocalDateTime time = LocalDateTime.now();
	private BigDecimal value;

	@Enumerated(EnumType.STRING)
	private CardApplicationEnum cardApplication;
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	public Transaction() {
		
	}
	
	public Transaction(BigDecimal value, CardApplicationEnum cardApplication, StatusEnum status) {
		super();
		this.value = value;
		this.cardApplication = cardApplication;
		this.status = status;
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

}
