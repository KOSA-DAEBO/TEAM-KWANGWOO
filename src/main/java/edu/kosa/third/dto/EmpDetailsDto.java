package edu.kosa.third.dto;

public class EmpDetailsDto {
	private PosDto posdto;
	private DeptDto deptdto;
	private EmpDto empdto;
	
	public EmpDetailsDto(EmpDto empDto, PosDto posDto, DeptDto deptDto) {
        this.empdto= empDto;
        this.posdto= posDto;
        this.deptdto= deptDto;
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
