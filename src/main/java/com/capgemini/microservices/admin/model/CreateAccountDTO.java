package com.capgemini.microservices.admin.model;

public class CreateAccountDTO {

	private String accountHolderName;
	private String idProofNo;
	private String IFSCCode;
	private String accountNumber;
	private String pincode;
	private String phoneNo;
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getIdProofNo() {
		return idProofNo;
	}
	public void setIdProofNo(String idProofNo) {
		this.idProofNo = idProofNo;
	}
	public String getIFSCCode() {
		return IFSCCode;
	}
	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}
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
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "CreateAccountDTO [accountHolderName=" + accountHolderName + ", idProofNo=" + idProofNo + ", IFSCCode="
				+ IFSCCode + ", accountNumber=" + accountNumber + ", pincode=" + pincode + ", phoneNo=" + phoneNo + "]";
	}
	
	
}
