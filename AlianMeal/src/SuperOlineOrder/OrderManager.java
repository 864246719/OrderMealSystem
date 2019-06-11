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
		System.out.println("���\t" + "������\t" + "����ʱ��\t" + "���͵�ַ\t" + "����״̬\t" + "�ܽ��\t" + "���Ͳ�Ʒ��\t" + "���ͷ���\t");
		for (int i = 0; i < orders.size(); i++) {
			System.out.print(orders.get(i).getOid() + "\t" + orders.get(i).getUerName() + "\t"
					+ orders.get(i).getTime() + "\t" + orders.get(i).getAddress() + "\t"
					+ (orders.get(i).getState() == 0 ? "��Ԥ��" : "�����") + "\t" + orders.get(i).getAllPrice()
					+ "\t");
			for (int j = 0; j < orders.get(i).getProducts().size(); j++) {
				if (j == 0)
					System.out.println(((Product) (orders.get(i).getProducts().get((j + 1) + ""))).getName()
							+ "\t" + ((Product) (orders.get(i).getProducts().get((j + 1) + ""))).getOrderNum()
							+ "��");
				if (j > 0) {
					System.out.print("\t\t\t\t\t\t");
					System.out.println(((Product) (orders.get(i).getProducts().get((j + 1) + ""))).getName()
							+ "\t" + ((Product) (orders.get(i).getProducts().get((j + 1) + ""))).getOrderNum()
							+ "��");
				}
			}
		}
	}

	
	
	public  static void DelOrder(int delId) {
//		System.out.print("������ǩ�յĶ����ţ�");
//		int delId = sc.nextInt();
		Order fla=null;
		if(orders.get(delId).getState() == 0){
			
			fla = orders.remove(delId);
		}
		if (fla != null) {
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("ɾ��ʧ��");
		}
	}
	
	
	public static void ReceiveOrder(int did) {
//		System.out.print("������ǩ�յĶ����ţ�");
//		int did = sc.nextInt();
		if (((Order)(orders.get(did))).getState() == 0) {
			orders.get(did).setState(1);
			System.out.println("ǩ�ճɹ���^,^");
		}else{
			System.out.println("�����������,����ǩ�գ�");
		}
	}
	
	
	public static int OrderMenu(Scanner sc, int oid, double sum) {
		String ifNext;
		Map<String, Product> pros = new HashMap<String, Product>();
		System.out.println("����ҳ��");
		System.out.println("�����붩��������:");
		String name = sc.next();
//		System.out.println("���\t����\t\t����\t������");
//		for (int i = 0; i < p.size(); i++) {
//			Product pro = (Product) p.get(i);
//			System.out.println(
//					pro.getPid() + "\t" + pro.getName() + "\t\t" + pro.getPrice() + "\t" + pro.getPraise());
//		}
		ProductManager.ShowProducts();
		int count = 0;
		do {
			System.out.print("������Ҫ��Ĳ�Ʒ���:");
			int id = sc.nextInt();
			System.out.println("��ѡ����Ҫ�ķ���");
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

			System.out.println("�Ƿ��������y����,n�˳�����");
			ifNext = sc.next();
		} while (ifNext.equalsIgnoreCase("y"));
		System.out.println(pros);
		System.out.println("�������Ͳ͵�ַ:");
		String address = sc.next();
		Order o = new Order(oid++, name, address, 0, pros);
		System.out.print("�������Ͳ�ʱ�䣺8~22��������");
		int time = 0;
		boolean flag = true;
		do {

			time = sc.nextInt();
			if (time > 8 && time < 22) {
				flag = false;

			} else {
				System.out.println("����������");
			}
		} while (flag);
		o.setTime(time);
		System.out.println("���ͳɹ���");
		System.out.println("�������ǣ�");
		for (int i = 1; i <= pros.size(); i++) {
			System.out.println(i + "\t" + ((Product) (pros.get(i + ""))).getName());
			sum += (((Product) (pros.get(i + ""))).getPrice()) * (((Product) (pros.get(i + ""))).getOrderNum());
		}
		o.setAllPrice(sum);
		orders.add(o);
		System.out.println("�Ͳ�ʱ�䣺" + time);
		System.out.println("�ͷѣ�" + sum + "Ԫ" + "\t�Ͳͷѣ�" + (sum > 50 ? 0 : 4) + "Ԫ�����ͷѴ�50Ԫ���ϣ����Ͳͣ�,�ܼ�"
				+ +(sum + (sum > 50 ? 0 : 4)) + "Ԫ");
		return oid;
	}
}
