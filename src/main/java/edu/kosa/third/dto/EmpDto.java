package edu.kosa.third.dto;

import java.sql.Date;

public class EmpDto {
	private int empNo, annualLeave, deptNo, posNo;
	private Date empBirth, hireDate;
	private String usrId, empName, empEmail, empTel, empAddr , empGender;
	private boolean empStatus, role;

	public EmpDto() {
		
	}
	
	public EmpDto(int empNo, int annualLeave, int deptNo, int posNo, Date empBirth, Date hireDate, String empName, String empEmail, String empTel, String empAddr, boolean empStatus, boolean role, String empGender) {
		this.empNo = empNo;
		this.annualLeave = annualLeave; //연차일수
		this.deptNo = deptNo;
		this.posNo = posNo;
		this.empBirth = empBirth;
		this.hireDate = hireDate;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empTel = empTel;
		this.empAddr = empAddr;
		this.empStatus = empStatus;
		this.role = role;
		this.empGender = empGender;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}


	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public int getPosNo() {
		return posNo;
	}

	public void setPosNo(int posNo) {
		this.posNo = posNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public int getAnnualLeave() {
		return annualLeave;
	}

	public void setAnnualLeave(int annualLeave) {
		this.annualLeave = annualLeave;
	}

	public Date getEmpBirth() {
		return empBirth;
	}

	public void setEmpBirth(Date empBirth) {
		this.empBirth = empBirth;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
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

	public String isEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
}
