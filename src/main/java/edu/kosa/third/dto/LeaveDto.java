package edu.kosa.third.dto;

import java.sql.Date;

public class LeaveDto {
	private int leaveNo, levStatus, typeNo, empNo;
	private Date startDay, endDay;
	private String reason, usrId;

	
	public LeaveDto() {
	}

	public LeaveDto(int leaveNo, int levStatus, int typeNo, int empNo, Date startDay, Date endDay, String reason,
			String usrId) {
		super();
		this.leaveNo = leaveNo;
		this.levStatus = levStatus;
		this.typeNo = typeNo;
		this.empNo = empNo;
		this.startDay = startDay;
		this.endDay = endDay;
		this.reason = reason;
		this.usrId = usrId;
	}

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

	public int getTypeNo() {
		return typeNo;
	}

	public void setTypeNo(int typeNo) {
		this.typeNo = typeNo;
	}


	public int getLeaveNo() {
		return leaveNo;
	}

	public void setLeaveNo(int leaveNo) {
		this.leaveNo = leaveNo;
	}

	public int getLevStatus() {
		return levStatus;
	}

	public void setLevStatus(int levStatus) {
		this.levStatus = levStatus;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
