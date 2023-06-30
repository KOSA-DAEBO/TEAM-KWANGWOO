package edu.kosa.third.dto;

public class MoneyDto {
	int mNo, profit, cost, tAmount;
	String cause;

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int gettAmount() {
		return tAmount;
	}

	public void settAmount(int tAmount) {
		this.tAmount = tAmount;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}
}
