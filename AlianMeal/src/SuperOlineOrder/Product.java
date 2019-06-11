package SuperOlineOrder;
/**
 * 
 *
 */
public class Product {
	private int pid;
	private String name; // 菜名
	private double price;
	private int orderNum;// 菜品的份数
	private int praise;// 点赞

	public Product() {
		super();
	}

	public Product(int pid, String name, double price) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
	}

	// public void show(){
	// System.out.println();
	// }
	//

}
