package OrderSystem;

import java.util.Scanner;

public class OrderMenu {
	// ����
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1���������ڴ洢��Ʒ������
		String[] cpNames = { "��ɫ������", "����С��Ϻ", "�����" };
		double[] cpPrices = { 58.5, 188.0, 666 };
		int[] cpPraise = new int[3];// ��Ʒ����

		// 2��������洢�û�������Ϣ������
		// ���������� ��ѡ��Ʒ �Ͳ�ʱ�� �Ͳ͵�ַ ����״̬��0��Ԥ����1����� �ܽ��
		String[] dcNames = new String[5];
		String[] dcDishMsg = new String[5];
		int[] dcSendTime = new int[5];
		String[] dcAddress = new String[5];
		int[] dcState = new int[5];
		double[] dcPayMoney = new double[5];

		boolean flag = true;
		int choose = 0;
		do {
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				System.out.println("1");
				break;
			case 2:
				System.out.println("2");
				break;
			case 3:
				System.out.println("3");
				break;
			case 4:
				System.out.println("4");
				break;
			case 5:
				System.out.println("5");
				break;
			default:
				flag = false;
			}
			if(flag){
				System.out.println("����0�������˵������������˳���");
				choose=sc.nextInt();
				if(choose!=0){
					flag=false;
				}
			}
		} while (flag);

	}
}
