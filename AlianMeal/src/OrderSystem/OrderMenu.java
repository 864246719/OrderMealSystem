package OrderSystem;

import java.util.Scanner;

public class OrderMenu {
	// 任务
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1、定义用于存储菜品的数组
		String[] cpNames = { "特色红烧肉", "麻辣小龙虾", "深海鳕鱼" };
		double[] cpPrices = { 58.5, 188.0, 666 };
		int[] cpPraise = new int[3];// 菜品点赞

		// 2、定义与存储用户订单信息的数组
		// 订单人名称 所选菜品 送餐时间 送餐地址 订单状态：0已预定，1已完成 总金额
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
				System.out.println("输入0返回主菜单，输入其他退出：");
				choose=sc.nextInt();
				if(choose!=0){
					flag=false;
				}
			}
		} while (flag);

	}
}
