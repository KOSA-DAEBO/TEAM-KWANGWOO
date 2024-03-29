package edu.kosa.third.dto;

public class UsrDto {
	private String usrId;
	private String pwd;
	private String salt;
	private String status;
	private String imagePath;
	private String thumbnailPath;
	
	
	public UsrDto(String usrId, String pwd, String salt, String status) {
		this.usrId = usrId;
		this.pwd = pwd;
		this.salt = salt;
		this.status = status;
	}

	public UsrDto() {

	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
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
