package cn.jiZhang.book.domain;

public class Book {
	// 金钱，时间，原因
	private int id;
	private double price;
	private String time;
	private String reason;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", price=" + price + ", time=" + time
				+ ", reason=" + reason + "]";
	}

}
