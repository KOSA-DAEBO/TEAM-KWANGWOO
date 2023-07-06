package edu.kosa.third.dto;


import java.sql.Date;

public class CustomerDto {

  private String customerno;
  private String usrid;
  private String customeremail;
  private String customertel;
  private String customergender;
  private Date customerbirth;
  private String customeraddr;
  private String customername;

  public CustomerDto(String customerno, String usrid, String customeremail, String customertel, String customergender, Date customerbirth, String customeraddr, String customername) {
    this.customerno = customerno;
    this.usrid = usrid;
    this.customeremail = customeremail;
    this.customertel = customertel;
    this.customergender = customergender;
    this.customerbirth = customerbirth;
    this.customeraddr = customeraddr;
    this.customername = customername;
  }

  public String getCustomerno() {
    return customerno;
  }

  public void setCustomerno(String customerno) {
    this.customerno = customerno;
  }


  public String getUsrid() {
    return usrid;
  }

  public void setUsrid(String usrid) {
    this.usrid = usrid;
  }


  public String getCustomeremail() {
    return customeremail;
  }

  public void setCustomeremail(String customeremail) {
    this.customeremail = customeremail;
  }


  public String getCustomertel() {
    return customertel;
  }

  public void setCustomertel(String customertel) {
    this.customertel = customertel;
  }


  public String getCustomergender() {
    return customergender;
  }


  public void setCustomergender(String customergender) {
    this.customergender = customergender;
  }


  public Date getCustomerbirth() {
    return customerbirth;
  }

  public void setCustomerbirth(Date customerbirth) {
    this.customerbirth = customerbirth;
  }


  public String getCustomeraddr() {
    return customeraddr;
  }

  public void setCustomeraddr(String customeraddr) {
    this.customeraddr = customeraddr;
  }


  public String getCustomername() {
    return customername;
  }

  public void setCustomername(String customername) {
    this.customername = customername;
  }

}
