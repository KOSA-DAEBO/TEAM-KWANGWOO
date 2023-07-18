package edu.kosa.third.dto;

public class EmpDetailsDto {
	private PosDto posdto;
	private DeptDto deptdto;
	private EmpDto empdto;
	private UsrDto usrdto;

	public EmpDetailsDto(EmpDto empDto, PosDto posDto, DeptDto deptDto, UsrDto usrDto) {
		this.empdto = empDto;
		this.posdto = posDto;
		this.deptdto = deptDto;
		this.usrdto = usrDto;
	}

	public UsrDto getUsrdto() {
		return usrdto;
	}

	public void setUsrdto(UsrDto usrdto) {
		this.usrdto = usrdto;
	}

	public PosDto getPosdto() {
		return posdto;
	}

	public void setPosdto(PosDto posdto) {
		this.posdto = posdto;
	}

	public DeptDto getDeptdto() {
		return deptdto;
	}

	public void setDeptdto(DeptDto deptdto) {
		this.deptdto = deptdto;
	}

	public EmpDto getEmpdto() {
		return empdto;
	}

	public void setEmpdto(EmpDto empdto) {
		this.empdto = empdto;
	}

}
