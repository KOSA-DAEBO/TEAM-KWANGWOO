package edu.kosa.third.dto;

public class ItemDto {
	private int itemNo, cost, price, stock, itemClsNo;
	private String itemName;
	
	public ItemDto() {};
	
	public ItemDto(String itemName, int cost, int price, int itemClsNo) {
		this.itemName = itemName;
		this.cost = cost;
		this.price = price;
		this.itemClsNo = itemClsNo;
	}
	
	public int getItemClsNo() {
		return itemClsNo;
	}

	public void setItemClsNo(int itemClsNo) {
		this.itemClsNo = itemClsNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
