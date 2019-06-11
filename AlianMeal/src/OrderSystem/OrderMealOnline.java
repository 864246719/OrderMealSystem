package OrderSystem;

import java.util.Scanner;

import javax.net.ssl.SSLEngineResult.Status;

public class OrderMealOnline {

	public static void main(String[] args) {
		String ifNext = "";
		String state = "";// ����״̬
		Scanner input = new Scanner(System.in);

		int orderNum = 0;// ����������

		int[][] orederCopies = new int[4][4]; // ��������
		String[][] orderDishes = new String[4][4];//
		double[][] orderPrices = new double[4][4];
		int[] ordertime = new int[4];
		String[] orderAddress = new String[4];
		int[] orderSumPrices = new int[4];// ���ζ����۸�
		for(int i=0;i<orderSumPrices.length;i++){
			if(orderSumPrices[i]>=100){
				orderSumPrices[i]-=30;
			}
		}
		String[] userNames = new String[4];
		String[] orders = new String[4];
		int[] orderStatuss = new int[4];

		
		
		// ����
		int[] indexs = { 1, 2, 3 };
		String[] dishes = { "��з��", "������", "����" };
		double[] prices = { 108, 65, 54 };
		int[] orderPraise = new int[4];// ����
		

		do {
			showMenu();
			int count = 0;
			System.out.println("�����붩��ϵͳѡ��");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("����");
				orderNum = OrderMenu(input, orderNum, orederCopies, orderDishes, orderPrices, ordertime, orderAddress,
						orderSumPrices, userNames, orderStatuss, indexs, dishes, prices, orderPraise, count);
				break;
			case 2:
				System.out.println("====================�ʹ�����==================");
				state = SelectAllMenu(state, orderNum, orederCopies, orderDishes, ordertime, orderAddress,
						orderSumPrices, userNames, orderStatuss);
				break;
			case 3:
				System.out.println("ǩ�ն���");
				receiveOrder(input, userNames, orderStatuss);
				break;
			case 4:
				System.out.println("ɾ������");
				DeleteOrderById(input, orderNum, orederCopies, orderDishes, orderPrices, ordertime, orderAddress,
						orderSumPrices, userNames, orders, orderStatuss);
				break;
			case 5:
				System.out.println("��Ҫ����");
				state = MenuPraise(state, input, orderNum, orederCopies, orderDishes, ordertime, orderAddress,
						orderSumPrices, userNames, orders, orderStatuss, orderPraise);
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.exit(0);
				break;
			}
			System.out.println("�Ƿ����,�����밴:y/Y,�˳�ϵͳ�밴:f/F");
			ifNext = input.next();
		} while (ifNext.equalsIgnoreCase("y"));
	}

	private static String MenuPraise(String state, Scanner input, int orderNum, int[][] orederCopies,
			String[][] orderDishes, int[] ordertime, String[] orderAddress, int[] orderSumPrices, String[] userNames,
			String[] orders, int[] orderStatuss, int[] orderPraise) {
		System.out.println("��������޵Ķ����ţ�");
		System.out.print("���\t������\t\t����ʱ�䣨x��00��\t���͵�ַ\t�ܽ��\t����״̬\t������\t��������\t\t��������");
		for (int i = 0; i <= orderNum - 1; i++) {
			if (userNames[i] != null) {
				if (orderStatuss[i] == 1) {
					state = "�����";
				} else if (orderStatuss[i] == 0) {
					state = "��Ԥ��";
				}
				System.out.print("\n" + i + "\t" + userNames[i] + "\t\t" + ordertime[i] + "\t\t" + orderAddress[i]
						+ "\t" + orderSumPrices[i] + "\t" + orders[i] + "\t" + orderPraise[i]);
				for (int j = 0; j < orderDishes[i].length; j++) {
					if (orderDishes[i][j] != null) {
						if (j == 0) {
							System.out.println("\t" + orderDishes[i][j] + "\t\t" + orederCopies[i][j]);
						} else {
							System.out.println("\t\t\t\t\t\t\t\t\t" + orderDishes[i][j] + "\t\t" + orederCopies[i][j]);
						}
					}
				}
			}
		}
		System.out.print("��ǰ�Ķ�������ѡ��");
		int choose1 = input.nextInt();
		orderPraise[choose1]++;

		System.out.println("=========================��ǰ�ĵ��޲鿴��");

		System.out.print("���\t������\t\t����ʱ�䣨x��00��\t���͵�ַ\t�ܽ��\t����״̬\t������\t��������\t\t��������");
		for (int i = 0; i <= orderNum - 1; i++) {
			if (userNames[i] != null) {
				if (ordertime[i] == 1) {
					state = "�����";
				} else if (ordertime[i] == 0) {
					state = "��Ԥ��";
				}
				if (orderSumPrices[i] < 30) {
					orderSumPrices[i] = orderSumPrices[i] + 5;
				}
				System.out.print("\n" + i + "\t" + userNames[i] + "\t\t" + ordertime[i] + "\t\t" + orderAddress[i]
						+ "\t" + orderSumPrices[i] + "\t" + orders[i] + "\t" + orderPraise[i]);
				for (int j = 0; j < orderDishes[i].length; j++) {
					if (orderDishes[i][j] != null) {
						if (j == 0) {
							System.out.println("\t" + orderDishes[i][j] + "\t\t" + orederCopies[i][j]);
						} else {
							System.out.println("\t\t\t\t\t\t\t\t\t" + orderDishes[i][j] + "\t\t" + orederCopies[i][j]);
						}
					}
				}
			}
		}
		return state;
	}

	private static void DeleteOrderById(Scanner input, int orderNum, int[][] orederCopies, String[][] orderDishes,
			double[][] orderPrices, int[] ordertime, String[] orderAddress, int[] orderSumPrices, String[] userNames,
			String[] orders, int[] orderStatuss) {
		System.out.println("������Ҫɾ���Ķ�����");
		int choose = input.nextInt();
		if (choose >= 0 && choose < orderNum && orderStatuss[choose] == 1) {
			/**
			 * int[][] orederCopies = new int[4][4]; String[][] orderDishes =
			 * new String[4][4]; double[][] orderPrices = new double[4][4];
			 * int[] ordertime = new int[4]; String[] orderAddress = new
			 * String[4]; int[] orderSumPrices = new int[4]; String[] userNames
			 * = new String[4]; String[] orders=new String[4]; int[]
			 * orderStatuss=new int[4];
			 */
			for (int i = choose; i < orderNum - 1; i++) {
				ordertime[i] = ordertime[i + 1];
				userNames[i] = userNames[i + 1];
				orderAddress[i] = orderAddress[i + 1];
				orderSumPrices[i] = orderSumPrices[i + 1];
				orders[i] = orders[i + 1];
				orderStatuss[i] = orderStatuss[i + 1];
				orderPrices[i][orderPrices[i].length] = orderPrices[i + 1][orderPrices[i].length];
				orederCopies[i][orederCopies[i].length] = orederCopies[i + 1][orederCopies[i].length];
				orderDishes[i][orderDishes[i].length] = orderDishes[i + 1][orderDishes[i].length];
			}
			userNames[orderNum - 1] = null;
			ordertime[orderNum - 1] = 0;
			orderAddress[orderNum - 1] = "";
			orderSumPrices[orderNum - 1] = 0;
			orders[orderNum - 1] = null;
			orderStatuss[orderNum - 1] = 0;
			for (int i = 0; i < orderPrices[orderNum - 1].length; i++) {
				orderPrices[orderNum - 1][i] = 0;
				orederCopies[orderNum - 1][i] = 0;
				orderDishes[orderNum - 1][i] = "";
			}

			System.out.println("ɾ���ɹ���");
		} else {
			System.out.println("����������,����ɾ���ö���");
		}
	}

	private static int OrderMenu(Scanner input, int orderNum, int[][] orederCopies, String[][] orderDishes,
			double[][] orderPrices, int[] ordertime, String[] orderAddress, int[] orderSumPrices, String[] userNames,
			int[] orderStatuss, int[] indexs, String[] dishes, double[] prices, int[] orderPraise, int count) {
		String ifNext;
		// do{
		// ��ӡmenu
		System.out.println("�������\t����\t\t�۸�");
		for (int i = 0; i < indexs.length; i++) {
			System.out.println(indexs[i] + "\t" + dishes[i] + "\t\t" + prices[i]);
		}

		System.out.println("�����붩���˵�������");
		String name = input.next();
		userNames[orderNum] = name;
		double priceNow=0;
		do {
			
			System.out.println("�����붩����ţ�");
			int orderIndex = input.nextInt();
			System.out.println("�����붩�ͷ�����");
			int copies = input.nextInt();
			orederCopies[orderNum][count] = copies;
			orderDishes[orderNum][count] = dishes[orderIndex - 1];
			orderPrices[orderNum][count] = prices[orderIndex - 1] * copies;
			System.out.println("�������\"" + dishes[orderIndex - 1] + "\"������");
			System.out.println("�Ƿ������ͣ�y/n");
			System.out.println("*************��ϵͳ�**********����������ܽ���100,��30Ԫ");
			//��ǰ�����۸�
			for(int i=0;i<=count;i++){
				priceNow+=orderPrices[orderNum][i];
			}
			System.out.println("��ǰ�Ѷ��۸�"+priceNow);
			if(priceNow>=100){
				System.out.println("��ϲ���Ķ�����������,^_^");
			}else{
				System.out.println("Ŀǰ����������");
			}
			System.out.println("���ж��Ƿ������y/n");
			ifNext = input.next();
			count++;
		} while (ifNext.equalsIgnoreCase("y"));

		System.out.println("���ѳɹ�����");
		System.out.print("���������Ķ���ʱ�䣺");
		int time = input.nextInt();
		if (time < 20 && time > 8) {
			ordertime[orderNum] = time;
		}
		System.out.println("���������Ķ��͵�ַ��");
		String address = input.next();
		orderAddress[orderNum] = address;
		System.out.println("��л���Ķ��ͣ����������Ķ������ݣ�");
		int sum = 0;
		for (int i = 0; i <= count; i++) {
			sum += orderPrices[orderNum][i];
			orderSumPrices[orderNum] = sum;
		}

		System.out.println("����ǰ�Ķ���Ϊ��" + orderSumPrices[orderNum]);
		orderStatuss[orderNum] = 0;
		orderPraise[orderNum] = 0;
		System.out.println("���˴εĶ���������");
		System.out.println("������\t\t�������\t");
		for (int i = 0; i < orderDishes[orderNum].length; i++) {
			if (orderDishes[orderNum][i] != null)
				System.out.println(orderDishes[orderNum][i] + "\t\t" + orederCopies[orderNum][i]);
		}
		System.out.println("���ǽ�Ϊ" + name + "������ʹлл�´ι���");
		// System.out.println("�Ƿ񷵻������棬y/n");
		// ifNext = input.next();
		orderNum++;
		// }while(ifNext.equalsIgnoreCase("y"));
		return orderNum;
	}

	private static String SelectAllMenu(String state, int orderNum, int[][] orederCopies, String[][] orderDishes,
			int[] ordertime, String[] orderAddress, int[] orderSumPrices, String[] userNames, int[] orderStatuss) {
		/**
		 * int [][] orederCopies=new int[4][4]; String[][] orderDishes=new
		 * String[4][4]; double[][] orderPrices=new double[4][4]; int[]
		 * ordertime=new int[4]; String[] orderAddress=new String[4]; int[]
		 * orderSumPrices=new int[4]; String[] userNames=new String[4];
		 */

		System.out.print("���\t������\t\t����ʱ�䣨x��00��\t���͵�ַ\t�ܽ��\t����״̬\t��������\t\t��������");

		for (int i = 0; i <= orderNum; i++) {

			if (userNames[i] != null) {
				if (orderStatuss[i] == 1) {
					state = "�����";
				} else if (orderStatuss[i] == 0) {
					state = "��Ԥ��";
				}
				System.out.print("\n" + i + "\t" + userNames[i] + "\t\t" + ordertime[i] + "\t\t" + orderAddress[i]
						+ "\t" + orderSumPrices[i] + "\t" + state);
				for (int j = 0; j < orderDishes[i].length; j++) {
					if (orderDishes[i][j] != null) {
						if (j == 0) {
							System.out.println("\t" + orderDishes[i][j] + "\t\t" + orederCopies[i][j]);
						} else {
							System.out.println("\t\t\t\t\t\t\t\t" + orderDishes[i][j] + "\t\t" + orederCopies[i][j]);
						}
					}
				}
			}
		}
		return state;
	}

	private static void receiveOrder(Scanner input, String[] userNames, int[] orderStatuss) {
		System.out.println("��ѡ��Ҫǩ�յĵ���");
		System.out.println("ϵͳ���ڲ���Ŀǰ���Ķ���״̬~~~~~~~~~~~~~~~~~~~~~~~���Ե�");
		int orderChoose = input.nextInt();
		if (userNames[orderChoose] != null && orderStatuss[orderChoose] == 0) {
			orderStatuss[orderChoose] = 1;
			System.out.println("���Ķ�������Ԥ��������ǩ��");
			System.out.println("...");
			System.out.println("���Ķ����Ѿ���ɣ���л����~");
		} else {
			System.out.println("���ж����Ѿ���ɣ�û�п�ǩ��");
		}
	}

	public static void showMenu() {
		System.out.println("----------------��ӭʹ�á��Ի�����ϵͳ��--------------------");
		System.out.println("====================================================");
		System.out.println("1����Ҫ����");
		System.out.println("2���鿴�ʹ�");
		System.out.println("3��ǩ�ն���");
		System.out.println("4��ɾ������");
		System.out.println("5����Ҫ����");
		System.out.println("6���˳�ϵͳ");
		System.out.println("=====================================================");
	}

}
