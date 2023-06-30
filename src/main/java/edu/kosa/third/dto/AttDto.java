package edu.kosa.third.dto;

import java.sql.Timestamp;
import java.sql.Date;

public class AttDto {
	int attNo;
	Date nowDate;
	Timestamp startTime, endTime;
	String attStatus;

	public int getAttNo() {
		return attNo;
	}

	public void setAttNo(int attNo) {
		this.attNo = attNo;
	}

	public Date getNowDate() {
		return nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getAttStatus() {
		return attStatus;
	}

	public void setAttStatus(String attStatus) {
		this.attStatus = attStatus;
	}
}
