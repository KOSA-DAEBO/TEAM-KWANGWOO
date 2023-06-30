package edu.kosa.third.dto;

import java.sql.Date;

public class LeaveDto {
	int leaveNo, levStatus;
	Date startDay, endDay;
	String reason;

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
