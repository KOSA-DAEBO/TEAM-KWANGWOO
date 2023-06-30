package edu.kosa.third.dto;

public class EmpDto {
	int empNo, empAge;
	String empName, empEmail, empTel, empAddr;
	boolean empStatus, role, empGender;

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpTel() {
		return empTel;
	}

	public void setEmpTel(String empTel) {
		this.empTel = empTel;
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	public boolean isEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(boolean empStatus) {
		this.empStatus = empStatus;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public boolean isEmpGender() {
		return empGender;
	}

	public void setEmpGender(boolean empGender) {
		this.empGender = empGender;
	}
}
