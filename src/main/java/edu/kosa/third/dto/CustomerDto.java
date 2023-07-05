package edu.kosa.third.dto;

import java.sql.Date;

public class CustomerDto {
	private int customerNo;
	private String customerEmail, customerTel, customerAddr, customerName, usrId;
	private boolean customerGender;
	private Date customerBirth;

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerTel() {
		return customerTel;
	}

	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}

	public String getCustomerAddr() {
		return customerAddr;
	}

	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public boolean isCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(boolean customerGender) {
		this.customerGender = customerGender;
	}

	public Date getCustomerBirth() {
		return customerBirth;
	}

	public void setCustomerBirth(Date customerBirth) {
		this.customerBirth = customerBirth;
	}
}
