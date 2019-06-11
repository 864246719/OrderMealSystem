package SuperOlineOrder;

import java.util.HashMap;
import java.util.Map;

public class Order {
	
	
	private int oid;
	private String uerName;// 订单客户
	private int time;// 订单时间
	private String address;// 订单地址
	private int state;// 订单状态 o已预订 1完成
	private Map<String, Product> products;// 订单菜品
	private double allPrice;// 订单总价

	public Order() {
		super();
	}

	public Order(int oid, String uerName, String address, int state, Map<String, Product> pros) {
		super();
		this.oid = oid;
		this.uerName = uerName;

		this.address = address;
		this.state = state;
		this.products = pros;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public double getAllPrice() {
		return allPrice;
	}

	public void setAllPrice(double allPrice) {
		this.allPrice = allPrice;
	}

	public String getUerName() {
		return uerName;
	}

	public void setUerName(String uerName) {
		this.uerName = uerName;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		if (time > 8 && time < 22) {
			this.time = time;
		} else {
			System.out.println("时间不对,请重新输入");
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Map<String, Product> getProducts() {
		return products;
	}

	public void setProducts(HashMap<String, Product> products) {
		this.products = products;
	}

}
