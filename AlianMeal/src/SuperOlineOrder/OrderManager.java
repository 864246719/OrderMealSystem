package SuperOlineOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OrderManager {

	
	private static List<Order> orders = new ArrayList<Order>();
	static List<Product> p=ProductManager.getProducts();
	public static List<Order> getOrders(){
		return  orders;
	}
	
	
	
	public static void AllOrder() {
		System.out.println("序号\t" + "订餐人\t" + "订餐时间\t" + "订餐地址\t" + "订单状态\t" + "总金额\t" + "订餐菜品名\t" + "订餐份数\t");
		for (int i = 0; i < orders.size(); i++) {
			System.out.print(orders.get(i).getOid() + "\t" + orders.get(i).getUerName() + "\t"
					+ orders.get(i).getTime() + "\t" + orders.get(i).getAddress() + "\t"
					+ (orders.get(i).getState() == 0 ? "已预订" : "已完成") + "\t" + orders.get(i).getAllPrice()
					+ "\t");
			for (int j = 0; j < orders.get(i).getProducts().size(); j++) {
				if (j == 0)
					System.out.println(((Product) (orders.get(i).getProducts().get((j + 1) + ""))).getName()
							+ "\t" + ((Product) (orders.get(i).getProducts().get((j + 1) + ""))).getOrderNum()
							+ "份");
				if (j > 0) {
					System.out.print("\t\t\t\t\t\t");
					System.out.println(((Product) (orders.get(i).getProducts().get((j + 1) + ""))).getName()
							+ "\t" + ((Product) (orders.get(i).getProducts().get((j + 1) + ""))).getOrderNum()
							+ "份");
				}
			}
		}
	}

	
	
	public  static void DelOrder(int delId) {
//		System.out.print("请输入签收的订单号：");
//		int delId = sc.nextInt();
		Order fla=null;
		if(orders.get(delId).getState() == 0){
			
			fla = orders.remove(delId);
		}
		if (fla != null) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}
	
	
	public static void ReceiveOrder(int did) {
//		System.out.print("请输入签收的订单号：");
//		int did = sc.nextInt();
		if (((Order)(orders.get(did))).getState() == 0) {
			orders.get(did).setState(1);
			System.out.println("签收成功，^,^");
		}else{
			System.out.println("订单处已完成,不能签收！");
		}
	}
	
	
	public static int OrderMenu(Scanner sc, int oid, double sum) {
		String ifNext;
		Map<String, Product> pros = new HashMap<String, Product>();
		System.out.println("订餐页面");
		System.out.println("请输入订餐人姓名:");
		String name = sc.next();
//		System.out.println("序号\t菜名\t\t单价\t点赞数");
//		for (int i = 0; i < p.size(); i++) {
//			Product pro = (Product) p.get(i);
//			System.out.println(
//					pro.getPid() + "\t" + pro.getName() + "\t\t" + pro.getPrice() + "\t" + pro.getPraise());
//		}
		ProductManager.ShowProducts();
		int count = 0;
		do {
			System.out.print("请输入要点的菜品编号:");
			int id = sc.nextInt();
			System.out.println("请选择需要的份数");
			int num = sc.nextInt();
			for (int i = 0; i < p.size(); i++) {

				if (id == ((Product) (p.get(i))).getPid()) {
					Product pro = new Product();
					pro = (Product) (p.get(i));
					System.out.println(pro);
					pro.setOrderNum(num);
					pros.put((++count) + "", pro);
					System.out.println(pros);
				}
			}

			System.out.println("是否继续购买？y继续,n退出购买");
			ifNext = sc.next();
		} while (ifNext.equalsIgnoreCase("y"));
		System.out.println(pros);
		System.out.println("请输入送餐地址:");
		String address = sc.next();
		Order o = new Order(oid++, name, address, 0, pros);
		System.out.print("请输入送餐时间：8~22整数数字");
		int time = 0;
		boolean flag = true;
		do {

			time = sc.nextInt();
			if (time > 8 && time < 22) {
				flag = false;

			} else {
				System.out.println("请重新输入");
			}
		} while (flag);
		o.setTime(time);
		System.out.println("订餐成功！");
		System.out.println("您定的是：");
		for (int i = 1; i <= pros.size(); i++) {
			System.out.println(i + "\t" + ((Product) (pros.get(i + ""))).getName());
			sum += (((Product) (pros.get(i + ""))).getPrice()) * (((Product) (pros.get(i + ""))).getOrderNum());
		}
		o.setAllPrice(sum);
		orders.add(o);
		System.out.println("送餐时间：" + time);
		System.out.println("餐费：" + sum + "元" + "\t送餐费：" + (sum > 50 ? 0 : 4) + "元（当餐费达50元以上，免送餐）,总计"
				+ +(sum + (sum > 50 ? 0 : 4)) + "元");
		return oid;
	}
}
