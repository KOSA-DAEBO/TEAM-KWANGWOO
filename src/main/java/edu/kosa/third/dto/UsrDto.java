package edu.kosa.third.dto;

public class UsrDto {
	private String usrid;
	private String pwd;
	private String salt;
	private String status;

	public UsrDto(String usrid, String pwd, String salt, String status) {
		this.usrid = usrid;
		this.pwd = pwd;
		this.salt = salt;
		this.status = status;
	}

	public String getUsrid() {
		return usrid;
	}

	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}


	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
