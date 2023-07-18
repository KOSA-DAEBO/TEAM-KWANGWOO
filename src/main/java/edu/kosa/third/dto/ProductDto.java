package edu.kosa.third.dto;

public class ProductDto {
	private int productNo, totalPrice;
	private String productName, imagePath, thumbnailPath;

	public ProductDto() {};

	public ProductDto(int productNo, int totalPrice, String productName, String imagePath, String thumbnailPath) {
		this.productNo = productNo;
		this.totalPrice = totalPrice;
		this.productName = productName;
		this.imagePath = imagePath;
		this.thumbnailPath = thumbnailPath;
	}

	public ProductDto(String productName, String saveImage, String saveThumbImage) {
		this.productName = productName;
		this.imagePath = saveImage;
		this.thumbnailPath = saveThumbImage;
	}

	public ProductDto(int productNo, String productName, String saveImage, String saveThumbImage) {
		this.productNo = productNo;
		this.productName = productName;
		this.imagePath = saveImage;
		this.thumbnailPath = saveThumbImage;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
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
