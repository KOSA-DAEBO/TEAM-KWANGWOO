package edu.kosa.third.dto;

public class DeptDto {
	private int deptNo;
	private String deptName;

	public DeptDto() {
		
	}
	
	public DeptDto(int deptNo, String deptName) {
		this.deptName = deptName;
		this.deptNo = deptNo;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
