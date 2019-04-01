package com.capgemini.microservices.admin.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection="history")
public class PaymentHistory {
private Date createdOn;
private Date amountDepositedOn;
private Date amountWithdrawnOn;
private double amountDeposited;
private double amountWithdrawn;
private String amountSentTo;
private double currentBalance;
private String amountReceivedFrom;

@Id
private String accountNumber;

public String getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
public Date getCreatedOn() {
	return createdOn;
}
public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
}
public Date getAmountDepositedOn() {
	return amountDepositedOn;
}
public void setAmountDepositedOn(Date amountDepositedOn) {
	this.amountDepositedOn = amountDepositedOn;
}
public Date getAmountWithdrawnOn() {
	return amountWithdrawnOn;
}
public void setAmountWithdrawnOn(Date amountWithdrawnOn) {
	this.amountWithdrawnOn = amountWithdrawnOn;
}
public double getAmountDeposited() {
	return amountDeposited;
}
public void setAmountDeposited(double amountDeposited) {
	this.amountDeposited = amountDeposited;
}
public double getAmountWithdrawn() {
	return amountWithdrawn;
}
public void setAmountWithdrawn(double amountWithdrawn) {
	this.amountWithdrawn = amountWithdrawn;
}
public String getAmountSentTo() {
	return amountSentTo;
}
public void setAmountSentTo(String amountSentTo) {
	this.amountSentTo = amountSentTo;
}

public double getCurrentBalance() {
	return currentBalance;
}
public void setCurrentBalance(double currentBalance) {
	this.currentBalance = currentBalance;
}

public String getAmountReceivedFrom() {
	return amountReceivedFrom;
}
public void setAmountReceivedFrom(String amountReceivedFrom) {
	this.amountReceivedFrom = amountReceivedFrom;
}
@Override
public String toString() {
	return "PaymentHistory [createdOn=" + createdOn + ", amountDepositedOn=" + amountDepositedOn
			+ ", amountWithdrawnOn=" + amountWithdrawnOn + ", amountDeposited=" + amountDeposited + ", amountWithdrawn="
			+ amountWithdrawn + ", amountSentTo=" + amountSentTo + ", accountNumber=" + accountNumber
			+ ", currentBalance=" + currentBalance + ", amountReceivedFrom=" + amountReceivedFrom + "]";
}


}
