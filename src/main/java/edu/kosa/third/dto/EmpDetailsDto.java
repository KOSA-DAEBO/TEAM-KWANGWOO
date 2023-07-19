package edu.kosa.third.dto;

public class EmpDetailsDto {
	private PosDto posDto;
	private DeptDto deptDto;
	private EmpDto empDto;
	private UsrDto usrDto;

	public EmpDetailsDto(PosDto posDto, DeptDto deptDto) {
		this.posDto = posDto;
		this.deptDto = deptDto;
	}

	public EmpDetailsDto(UsrDto usrDto, EmpDto empDto) {
		this.usrDto = usrDto;
		this.empDto = empDto;
	}


	public EmpDetailsDto(PosDto posDto, DeptDto deptDto, UsrDto usrDto) {
		this.deptDto = deptDto;
		this.posDto = posDto;
		this.usrDto = usrDto;
	}

	public PosDto getPosDto() {
		return posDto;
	}

	public void setPosDto(PosDto posDto) {
		this.posDto = posDto;
	}

	public DeptDto getDeptDto() {
		return deptDto;
	}

	public void setDeptDto(DeptDto deptDto) {
		this.deptDto = deptDto;
	}

	public EmpDto getEmpDto() {
		return empDto;
	}

	public void setEmpDto(EmpDto empDto) {
		this.empDto = empDto;
	}

	public UsrDto getUsrDto() {
		return usrDto;
	}

	public void setUsrDto(UsrDto usrDto) {
		this.usrDto = usrDto;
	}

	
}
