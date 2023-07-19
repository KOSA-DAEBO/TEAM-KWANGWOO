package edu.kosa.third.dto;

import java.sql.Date;

public class SalDto {
	private int salNo, amount, empNo;
	private String usrId;
	private Date payDay;

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public int getSalNo() {
		return salNo;
	}

	public void setSalNo(int salNo) {
		this.salNo = salNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getPayDay() {
		return payDay;
	}

	public void setPayDay(Date payDay) {
		this.payDay = payDay;
	}
	
}
