package SuperOlineOrder;
/**
 * ��������ã� 
 * �����Ŀ����ã�
 * 		����״̬����������ȡint
 * 
 * 
 */
import java.util.List;
import java.util.Scanner;

public class OrderMealOnline01 {

//	static ArrayList<Order> orders = new ArrayList<Order>();
	static List<Order> orders=OrderManager.getOrders();
//	static List<Product> p = new ArrayList<Product>();// �˵�
	static List<Product> p=ProductManager.getProducts();
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ifNext = "";
		// ��ǰ������ƷĬ��Ϊ0��,Ҳ���ǲ˵� ����
//		Product p1 = new Product(1, "��з��", 32);
//		Product p2 = new Product(2, "������", 18);
//		Product p3 = new Product(3, "����", 20);
//		p.add(p1);
//		p.add(p2);
//		p.add(p3);
		int oid = 0;// ����id
		do {
			showMenu();
			System.out.println("�����붩��ϵͳѡ��");
			int choice = sc.nextInt();
			double sum = 0;
			switch (choice) {
			
			case 1:
				OrderManager.OrderMenu(sc, oid, sum);
//				oid = OrderMenu(sc, oid, sum);
				break;
			case 2:
				System.out.println("====================�ʹ�����==================");
				OrderManager.AllOrder();
//				AllOrder();
				break;
			case 3:
				System.out.println("ǩ�ն���");
				System.out.print("������ǩ�յĶ����ţ�");
				int did = sc.nextInt();
				OrderManager.ReceiveOrder(did);
//				ReceiveOrder(sc);
				break;
			case 4:
				System.out.println("ɾ������");
				System.out.print("������ɾ���Ķ����ţ�");
				int delId = sc.nextInt();
				OrderManager.DelOrder(delId);
//				DelOrder(sc);
				break;
			case 5:
				System.out.println("��Ҫ����");
				System.out.println("��������޵Ĳ�Ʒ��:");
				int praisId = sc.nextInt();
				ProductManager.PraiseMenu(praisId);
//				PraiseMenu(sc);
				break;
			case 6:
				System.out.println("лл���٣�^,^");
				System.exit(0);
				
				break;
			default:
				System.exit(0);
				break;
			}
			System.out.println("�Ƿ����,�����밴:y/Y,�˳�ϵͳ�밴:f/F");
			ifNext = sc.next();
		} while (ifNext.equalsIgnoreCase("y"));
	}

	
	
	
	
	
	public static void showMenu() {
		System.out.println("===================��ӭʹ�á��Ի�����ϵͳ��==================");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("1����Ҫ����");
		System.out.println("2���鿴�ʹ�");
		System.out.println("3��ǩ�ն���");
		System.out.println("4��ɾ������");
		System.out.println("5����Ҫ����");
		System.out.println("6���˳�ϵͳ");
		// ����
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		
	}
	
	
	
	
	
	
	
	
	
	
//	private static int OrderMenu(Scanner sc, int oid, double sum) {
//		String ifNext;
//		Map<String, Product> pros = new HashMap<String, Product>();
//		System.out.println("����ҳ��");
//		System.out.println("�����붩��������:");
//		String name = sc.next();
////		System.out.println("���\t����\t\t����\t������");
////		for (int i = 0; i < p.size(); i++) {
////			Product pro = (Product) p.get(i);
////			System.out.println(
////					pro.getPid() + "\t" + pro.getName() + "\t\t" + pro.getPrice() + "\t" + pro.getPraise());
////		}
//		int count = 0;
//		do {
//			System.out.print("������Ҫ��Ĳ�Ʒ���:");
//			int id = sc.nextInt();
//			System.out.println("��ѡ����Ҫ�ķ���");
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
//			System.out.println("�Ƿ��������y����,n�˳�����");
//			ifNext = sc.next();
//		} while (ifNext.equalsIgnoreCase("y"));
//		System.out.println(pros);
//		System.out.println("�������Ͳ͵�ַ:");
//		String address = sc.next();
//		Order o = new Order(oid++, name, address, 0, pros);
//		System.out.print("�������Ͳ�ʱ�䣺8~22��������");
//		int time = 0;
//		boolean flag = true;
//		do {
//
//			time = sc.nextInt();
//			if (time > 8 && time < 22) {
//				flag = false;
//
//			} else {
//				System.out.println("����������");
//			}
//		} while (flag);
//		o.setTime(time);
//		System.out.println("���ͳɹ���");
//		System.out.println("�������ǣ�");
//		for (int i = 1; i <= pros.size(); i++) {
//			System.out.println(i + "\t" + ((Product) (pros.get(i + ""))).getName());
//			sum += (((Product) (pros.get(i + ""))).getPrice()) * (((Product) (pros.get(i + ""))).getOrderNum());
//		}
//		o.setAllPrice(sum);
//		orders.add(o);
//		System.out.println("�Ͳ�ʱ�䣺" + time);
//		System.out.println("�ͷѣ�" + sum + "Ԫ" + "\t�Ͳͷѣ�" + (sum > 50 ? 0 : 4) + "Ԫ�����ͷѴ�50Ԫ���ϣ����Ͳͣ�,�ܼ�"
//				+ +(sum + (sum > 50 ? 0 : 4)) + "Ԫ");
//		return oid;
//	}

//	private static void AllOrder() {
//		System.out.println("���\t" + "������\t" + "����ʱ��\t" + "���͵�ַ\t" + "����״̬\t" + "�ܽ��\t" + "���Ͳ�Ʒ��\t" + "���ͷ���\t");
//		for (int i = 0; i < orders.size(); i++) {
//			System.out.print(orders.get(i).getOid() + "\t" + orders.get(i).getUerName() + "\t"
//					+ orders.get(i).getTime() + "\t" + orders.get(i).getAddress() + "\t"
//					+ (orders.get(i).getState() == 0 ? "��Ԥ��" : "�����") + "\t" + orders.get(i).getAllPrice()
//					+ "\t");
//			for (int j = 0; j < orders.get(i).getProducts().size(); j++) {
//				if (j == 0)
//					System.out.println(((Product) (orders.get(i).getProducts().get((j + 1) + ""))).getName()
//							+ "\t" + ((Product) (orders.get(i).getProducts().get((j + 1) + ""))).getOrderNum()
//							+ "��");
//				if (j > 0) {
//					System.out.print("\t\t\t\t\t\t");
//					System.out.println(((Product) (orders.get(i).getProducts().get((j + 1) + ""))).getName()
//							+ "\t" + ((Product) (orders.get(i).getProducts().get((j + 1) + ""))).getOrderNum()
//							+ "��");
//				}
//			}
//		}
//	}

//	private static void PraiseMenu(Scanner sc) {
//		System.out.println("��Ʒid\t��Ʒ��\t��Ʒ�۸�\t��Ʒ����");
//		for (int i = 0; i < p.size(); i++) {
//			Product pro = (Product) p.get(i);
//			System.out.println(
//					pro.getPid() + "\t" + pro.getName() + "\t\t" + pro.getPrice() + "\t" + pro.getPraise());
//		}
//		System.out.println("��������޵Ĳ�Ʒ��:");
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
//		System.out.print("������ǩ�յĶ����ţ�");
//		int delId = sc.nextInt();
//		Order fla=null;
//		if(orders.get(delId).getState() == 0){
//			
//			fla = orders.remove(delId);
//		}
//		if (fla != null) {
//			System.out.println("ɾ���ɹ�");
//		} else {
//			System.out.println("ɾ��ʧ��");
//		}
//	}

//	private static void ReceiveOrder(Scanner sc) {
//		System.out.print("������ǩ�յĶ����ţ�");
//		int did = sc.nextInt();
//		if (orders.get(did).getState() == 0) {
//			orders.get(did).setState(1);
//		}
//	}


}
