package com.capgemini.microservices.history.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection="bank")
public class UsersAccount {

	private String accountNumber;
	private String pincode;
	private String accountHolderName;
	private String IFSCCode;
	private String idProofNo;
	private double accBalance;
	private String phoneNo;
	private Date createdOn;
	
	@Id
	private String accountId;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getIFSCCode() {
		return IFSCCode;
	}

	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}

	public String getIdProofNo() {
		return idProofNo;
	}

	public void setIdProofNo(String idProofNo) {
		this.idProofNo = idProofNo;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String id) {
		this.accountId = id;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "UsersAccount [accountNumber=" + accountNumber + ", pincode=" + pincode + ", accountHolderName="
				+ accountHolderName + ", IFSCCode=" + IFSCCode + ", idProofNo=" + idProofNo + ", accBalance="
				+ accBalance + ", phoneNo=" + phoneNo + ", createdOn=" + createdOn + ", id=" + accountId + "]";
	}
}
	