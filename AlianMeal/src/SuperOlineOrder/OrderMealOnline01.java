package SuperOlineOrder;
/**
 * 代码可重用： 
 * 方法的可重用，
 * 		订单状态单独方法获取int
 * 
 * 
 */
import java.util.List;
import java.util.Scanner;

public class OrderMealOnline01 {

//	static ArrayList<Order> orders = new ArrayList<Order>();
	static List<Order> orders=OrderManager.getOrders();
//	static List<Product> p = new ArrayList<Product>();// 菜单
	static List<Product> p=ProductManager.getProducts();
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ifNext = "";
		// 当前购买商品默认为0个,也可是菜单 共享
//		Product p1 = new Product(1, "肉蟹煲", 32);
//		Product p2 = new Product(2, "清鱼汤", 18);
//		Product p3 = new Product(3, "猪蹄", 20);
//		p.add(p1);
//		p.add(p2);
//		p.add(p3);
		int oid = 0;// 订单id
		do {
			showMenu();
			System.out.println("请输入订餐系统选项");
			int choice = sc.nextInt();
			double sum = 0;
			switch (choice) {
			
			case 1:
				OrderManager.OrderMenu(sc, oid, sum);
//				oid = OrderMenu(sc, oid, sum);
				break;
			case 2:
				System.out.println("====================餐袋详情==================");
				OrderManager.AllOrder();
//				AllOrder();
				break;
			case 3:
				System.out.println("签收订单");
				System.out.print("请输入签收的订单号：");
				int did = sc.nextInt();
				OrderManager.ReceiveOrder(did);
//				ReceiveOrder(sc);
				break;
			case 4:
				System.out.println("删除订单");
				System.out.print("请输入删除的订单号：");
				int delId = sc.nextInt();
				OrderManager.DelOrder(delId);
//				DelOrder(sc);
				break;
			case 5:
				System.out.println("我要点赞");
				System.out.println("请输入点赞的菜品名:");
				int praisId = sc.nextInt();
				ProductManager.PraiseMenu(praisId);
//				PraiseMenu(sc);
				break;
			case 6:
				System.out.println("谢谢光临，^,^");
				System.exit(0);
				
				break;
			default:
				System.exit(0);
				break;
			}
			System.out.println("是否继续,继续请按:y/Y,退出系统请按:f/F");
			ifNext = sc.next();
		} while (ifNext.equalsIgnoreCase("y"));
	}

	
	
	
	
	
	public static void showMenu() {
		System.out.println("===================欢迎使用“吃货联盟系统”==================");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("1、我要订餐");
		System.out.println("2、查看餐袋");
		System.out.println("3、签收订单");
		System.out.println("4、删除订单");
		System.out.println("5、我要点赞");
		System.out.println("6、退出系统");
		// 升级
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		
	}
	
	
	
	
	
	
	
	
	
	
//	private static int OrderMenu(Scanner sc, int oid, double sum) {
//		String ifNext;
//		Map<String, Product> pros = new HashMap<String, Product>();
//		System.out.println("订餐页面");
//		System.out.println("请输入订餐人姓名:");
//		String name = sc.next();
////		System.out.println("序号\t菜名\t\t单价\t点赞数");
////		for (int i = 0; i < p.size(); i++) {
////			Product pro = (Product) p.get(i);
////			System.out.println(
////					pro.getPid() + "\t" + pro.getName() + "\t\t" + pro.getPrice() + "\t" + pro.getPraise());
////		}
//		int count = 0;
//		do {
//			System.out.print("请输入要点的菜品编号:");
//			int id = sc.nextInt();
//			System.out.println("请选择需要的份数");
//			int num = sc.nextInt();
//			for (int i = 0; i < p.size(); i++) {
//
//				if (id == ((Product) (p.get(i))).getPid()) {
//					Product pro = new Product();
//					pro = (Product) (p.get(i));
//					System.out.println(pro);
//					pro.setOrderNum(num);
//					pros.put((++count) + "", pro);
//					System.out.println(pros);
//				}
//			}
//
//			System.out.println("是否继续购买？y继续,n退出购买");
//			ifNext = sc.next();
//		} while (ifNext.equalsIgnoreCase("y"));
//		System.out.println(pros);
//		System.out.println("请输入送餐地址:");
//		String address = sc.next();
//		Order o = new Order(oid++, name, address, 0, pros);
//		System.out.print("请输入送餐时间：8~22整数数字");
//		int time = 0;
//		boolean flag = true;
//		do {
//
//			time = sc.nextInt();
//			if (time > 8 && time < 22) {
//				flag = false;
//
//			} else {
//				System.out.println("请重新输入");
//			}
//		} while (flag);
//		o.setTime(time);
//		System.out.println("订餐成功！");
//		System.out.println("您定的是：");
//		for (int i = 1; i <= pros.size(); i++) {
//			System.out.println(i + "\t" + ((Product) (pros.get(i + ""))).getName());
//			sum += (((Product) (pros.get(i + ""))).getPrice()) * (((Product) (pros.get(i + ""))).getOrderNum());
//		}
//		o.setAllPrice(sum);
//		orders.add(o);
//		System.out.println("送餐时间：" + time);
//		System.out.println("餐费：" + sum + "元" + "\t送餐费：" + (sum > 50 ? 0 : 4) + "元（当餐费达50元以上，免送餐）,总计"
//				+ +(sum + (sum > 50 ? 0 : 4)) + "元");
//		return oid;
//	}

//	private static void AllOrder() {
//		System.out.println("序号\t" + "订餐人\t" + "订餐时间\t" + "订餐地址\t" + "订单状态\t" + "总金额\t" + "订餐菜品名\t" + "订餐份数\t");
//		for (int i = 0; i < orders.size(); i++) {
//			System.out.print(orders.get(i).getOid() + "\t" + orders.get(i).getUerName() + "\t"
//					+ orders.get(i).getTime() + "\t" + orders.get(i).getAddress() + "\t"
//					+ (orders.get(i).getState() == 0 ? "已预订" : "已完成") + "\t" + orders.get(i).getAllPrice()
//					+ "\t");
//			for (int j = 0; j < orders.get(i).getProducts().size(); j++) {
//				if (j == 0)
//					System.out.println(((Product) (orders.get(i).getProducts().get((j + 1) + ""))).getName()
//							+ "\t" + ((Product) (orders.get(i).getProducts().get((j + 1) + ""))).getOrderNum()
//							+ "份");
//				if (j > 0) {
//					System.out.print("\t\t\t\t\t\t");
//					System.out.println(((Product) (orders.get(i).getProducts().get((j + 1) + ""))).getName()
//							+ "\t" + ((Product) (orders.get(i).getProducts().get((j + 1) + ""))).getOrderNum()
//							+ "份");
//				}
//			}
//		}
//	}

//	private static void PraiseMenu(Scanner sc) {
//		System.out.println("菜品id\t菜品名\t菜品价格\t菜品点赞");
//		for (int i = 0; i < p.size(); i++) {
//			Product pro = (Product) p.get(i);
//			System.out.println(
//					pro.getPid() + "\t" + pro.getName() + "\t\t" + pro.getPrice() + "\t" + pro.getPraise());
//		}
//		System.out.println("请输入点赞的菜品名:");
//		int praisId = sc.nextInt() - 1;
//		int dos = ((Product) (p.get(praisId))).getPraise() + 1;
//		((Product) (p.get(praisId))).setPraise(dos);
//		System.out.println("=================================");
//		for (int i = 0; i < p.size(); i++) {
//			Product pro = (Product) p.get(i);
//			System.out.println(
//					pro.getPid() + "\t" + pro.getName() + "\t\t" + pro.getPrice() + "\t" + pro.getPraise());
//		}
//	}

//	private static void DelOrder(Scanner sc) {
//		System.out.print("请输入签收的订单号：");
//		int delId = sc.nextInt();
//		Order fla=null;
//		if(orders.get(delId).getState() == 0){
//			
//			fla = orders.remove(delId);
//		}
//		if (fla != null) {
//			System.out.println("删除成功");
//		} else {
//			System.out.println("删除失败");
//		}
//	}

//	private static void ReceiveOrder(Scanner sc) {
//		System.out.print("请输入签收的订单号：");
//		int did = sc.nextInt();
//		if (orders.get(did).getState() == 0) {
//			orders.get(did).setState(1);
//		}
//	}


}
