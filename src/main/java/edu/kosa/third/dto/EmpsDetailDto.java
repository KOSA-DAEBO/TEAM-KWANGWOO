package edu.kosa.third.dto;

public class EmpsDetailDto {
	private PosDto pos;
	private DeptDto dept;
	private EmpDto emp;
	
	public EmpsDetailDto(EmpDto empDto, PosDto posDto, DeptDto deptDto) {
        this.emp= empDto;
        this.pos= posDto;
        this.dept= deptDto;
    }
	public PosDto getPos() {
		return pos;
	}

	public void setPos(PosDto pos) {
		this.pos = pos;
	}

	public DeptDto getDept() {
		return dept;
	}

	public void setDept(DeptDto dept) {
		this.dept = dept;
	}

	public EmpDto getEmp() {
		return emp;
	}

	public void setEmp(EmpDto emp) {
		this.emp = emp;
	}

	
}
