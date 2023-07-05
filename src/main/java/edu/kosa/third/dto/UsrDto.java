package edu.kosa.third.dto;

public class UsrDto {
	private String usrId, pwd;
	private int hex;
	private boolean status;

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getHex() {
		return hex;
	}

	public void setHex(int hex) {
		this.hex = hex;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
