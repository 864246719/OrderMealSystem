package SuperOlineOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {

	private static List<Product> p = new ArrayList<Product>();// �˵�
	
	static{
		Product p1 = new Product(1, "��з��", 32);
		Product p2 = new Product(2, "������", 18);
		Product p3 = new Product(3, "����", 20);
		p.add(p1);
		p.add(p2);
		p.add(p3);
	}
	
	public static List<Product> getProducts(){
		return p;
	}
	
	
	
	public static void ShowProducts(){
		System.out.println("���\t����\t\t����\t������");
		for (int i = 0; i < p.size(); i++) {
			Product pro = (Product) p.get(i);
			System.out.println(
					pro.getPid() + "\t" + pro.getName() + "\t\t" + pro.getPrice() + "\t" + pro.getPraise());
		}
	}
	
	
	public static void PraiseMenu(int praisId) {
		System.out.println("��Ʒid\t��Ʒ��\t��Ʒ�۸�\t��Ʒ����");
		for (int i = 0; i < p.size(); i++) {
			Product pro = (Product) p.get(i);
			System.out.println(
					pro.getPid() + "\t" + pro.getName() + "\t\t" + pro.getPrice() + "\t" + pro.getPraise());
		}
//		System.out.println("��������޵Ĳ�Ʒ��:");
//		int praisId = sc.nextInt() - 1;
		int dos = ((Product) (p.get(praisId-1))).getPraise() + 1;
		((Product) (p.get(praisId))).setPraise(dos);
		System.out.println("=================================");
		for (int i = 0; i < p.size(); i++) {
			Product pro = (Product) p.get(i);
			System.out.println(
					pro.getPid() + "\t" + pro.getName() + "\t\t" + pro.getPrice() + "\t" + pro.getPraise());
		}
	}
	
	
	
}
