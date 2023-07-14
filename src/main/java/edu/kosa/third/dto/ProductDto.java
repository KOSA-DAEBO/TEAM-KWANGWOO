package edu.kosa.third.dto;

public class ProductDto {
	private int productNo, totalPrice;
	private String productName, imagePath;

	public ProductDto() {};
	
	public ProductDto(int productNo, int totalPrice, String productName, String imagePath) {
		this.productNo = productNo;
		this.totalPrice = totalPrice;
		this.productName = productName;
		this.imagePath = imagePath;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
