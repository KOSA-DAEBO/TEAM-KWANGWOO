package edu.kosa.third.dto;

public class UsrDto {
	private String usrId;
	private String pwd;
	private String salt;
	private String status;
	private String usrimage;
	private String usrthumbnail;
	
	
	public UsrDto(String usrId, String pwd, String salt, String status) {
		this.usrId = usrId;
		this.pwd = pwd;
		this.salt = salt;
		this.status = status;
	}

	public UsrDto() {

	}

	
	public String getUsrimage() {
		return usrimage;
	}

	public void setUsrimage(String usrimage) {
		this.usrimage = usrimage;
	}

	public String getUsrthumbnail() {
		return usrthumbnail;
	}

	public void setUsrthumbnail(String usrthumbnail) {
		this.usrthumbnail = usrthumbnail;
	}

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
