package edu.kosa.third.dto;


import java.sql.Date;

public class CustomerDto {

  private int customerNo;
  private String usrId;
  private String customerEmail;
  private String customerTel;
  private String customerGender;
  private Date customerBirth;
  private String customerAddr;
  private String customerName;
  
  public CustomerDto() {
	  
  }

  public CustomerDto(int customerNo, String usrId, String customerEmail, String customerTel, String customerGender, Date customerBirth, String customerAddr, String customerName) {
    this.customerNo = customerNo;
    this.usrId = usrId;
    this.customerEmail = customerEmail;
    this.customerTel = customerTel;
    this.customerGender = customerGender;
    this.customerBirth = customerBirth;
    this.customerAddr = customerAddr;
    this.customerName = customerName;
  }

  public CustomerDto(String customName, String customAddr, String customTel, String customEmail, int customNo) {
	  this.customerName = customName;
	  this.customerAddr = customAddr;
	  this.customerTel = customTel;
	  this.customerEmail = customEmail;
	  this.customerNo = customNo;
	  
}

public CustomerDto(int customNo) {
	this.customerNo = customNo;
}

public int getCustomerNo() {
    return customerNo;
  }

  public void setCustomerNo(int customerNo) {
    this.customerNo = customerNo;
  }


public String getUsrId() {
    return usrId;
  }

  public void setUsrId(String usrId) {
    this.usrId = usrId;
  }


  public String getCustomerEmail() {
    return customerEmail;
  }

  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
  }


  public String getCustomerTel() {
    return customerTel;
  }

  public void setCustomerTel(String customerTel) {
    this.customerTel = customerTel;
  }


  public String getCustomerGender() {
    return customerGender;
  }


  public void setCustomerGender(String customerGender) {
    this.customerGender = customerGender;
  }


  public Date getCustomerBirth() {
    return customerBirth;
  }

  public void setCustomerBirth(Date customerBirth) {
    this.customerBirth = customerBirth;
  }


  public String getCustomerAddr() {
    return customerAddr;
  }

  public void setCustomerAddr(String customerAddr) {
    this.customerAddr = customerAddr;
  }


  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

}
