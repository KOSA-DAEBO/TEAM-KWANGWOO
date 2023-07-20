package edu.kosa.third.dto;

import java.sql.Date;

public class EmpDto {
	private int empNo, annualLeave, deptNo, posNo, salary;

	private Date empBirth, hireDate, departureDate;
	private String usrId, empName, empEmail, empTel, empAddr, empGender, imagePath;
	private boolean empStatus, role;

	public EmpDto(int empNo, int annualLeave, int deptNo, int posNo, int salary, Date empBirth, Date hireDate,
			Date departureDate, String usrId, String empName, String empEmail, String empTel, String empAddr,
			String empGender, boolean empStatus, boolean role) {

		this.empNo = empNo;
		this.annualLeave = annualLeave;
		this.deptNo = deptNo;
		this.posNo = posNo;
		this.salary = salary;
		this.empBirth = empBirth;
		this.hireDate = hireDate;
		this.departureDate = departureDate;
		this.usrId = usrId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empTel = empTel;
		this.empAddr = empAddr;
		this.empGender = empGender;
		this.empStatus = empStatus;
		this.role = role;
	}
	
	public EmpDto(int empNo, int annualLeave, int deptNo, int posNo, int salary, Date empBirth, Date hireDate,
			Date departureDate, String usrId, String empName, String empEmail, String empTel, String empAddr,
			String empGender, boolean empStatus, boolean role, String imagePath) {
		
		this.empNo = empNo;
		this.annualLeave = annualLeave;
		this.deptNo = deptNo;
		this.posNo = posNo;
		this.salary = salary;
		this.empBirth = empBirth;
		this.hireDate = hireDate;
		this.departureDate = departureDate;
		this.usrId = usrId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empTel = empTel;
		this.empAddr = empAddr;
		this.empGender = empGender;
		this.empStatus = empStatus;
		this.role = role;
		this.imagePath = imagePath;
	}

	public EmpDto(String empAddr, String empTel, String empEmail) {
		this.empAddr = empAddr;
		this.empTel = empTel;
		this.empEmail = empEmail;
	}

	public EmpDto(String empAddr, String empTel, String empEmail, int empNo) {
		this.empAddr = empAddr;
		this.empTel = empTel;
		this.empEmail = empEmail;
		this.empNo = empNo;
	}

	public EmpDto() {

	}

	public EmpDto(String empName, int deptNo, int posNo, int salary, int empNo) {
		this.empName = empName;
		this.deptNo = deptNo;
		this.posNo = posNo;
		this.salary = salary;
		this.empNo = empNo;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

}
