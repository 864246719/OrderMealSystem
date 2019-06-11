package SuperOlineOrder;

import java.util.HashMap;
import java.util.Map;

public class Order {
	
	
	private int oid;
	private String uerName;// �����ͻ�
	private int time;// ����ʱ��
	private String address;// ������ַ
	private int state;// ����״̬ o��Ԥ�� 1���
	private Map<String, Product> products;// ������Ʒ
	private double allPrice;// �����ܼ�

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
			System.out.println("ʱ�䲻��,����������");
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
