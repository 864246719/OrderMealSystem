package OrderSystem;

import java.util.Scanner;

import javax.net.ssl.SSLEngineResult.Status;

public class OrderMealOnline {

	public static void main(String[] args) {
		String ifNext = "";
		String state = "";// 保存状态
		Scanner input = new Scanner(System.in);

		int orderNum = 0;// 订单计数器

		int[][] orederCopies = new int[4][4]; // 订单份数
		String[][] orderDishes = new String[4][4];//
		double[][] orderPrices = new double[4][4];
		int[] ordertime = new int[4];
		String[] orderAddress = new String[4];
		int[] orderSumPrices = new int[4];// 单次订单价格
		for(int i=0;i<orderSumPrices.length;i++){
			if(orderSumPrices[i]>=100){
				orderSumPrices[i]-=30;
			}
		}
		String[] userNames = new String[4];
		String[] orders = new String[4];
		int[] orderStatuss = new int[4];

		
		
		// 订单
		int[] indexs = { 1, 2, 3 };
		String[] dishes = { "肉蟹煲", "清鱼汤", "猪蹄" };
		double[] prices = { 108, 65, 54 };
		int[] orderPraise = new int[4];// 点赞
		

		do {
			showMenu();
			int count = 0;
			System.out.println("请输入订餐系统选项");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("订单");
				orderNum = OrderMenu(input, orderNum, orederCopies, orderDishes, orderPrices, ordertime, orderAddress,
						orderSumPrices, userNames, orderStatuss, indexs, dishes, prices, orderPraise, count);
				break;
			case 2:
				System.out.println("====================餐袋详情==================");
				state = SelectAllMenu(state, orderNum, orederCopies, orderDishes, ordertime, orderAddress,
						orderSumPrices, userNames, orderStatuss);
				break;
			case 3:
				System.out.println("签收订单");
				receiveOrder(input, userNames, orderStatuss);
				break;
			case 4:
				System.out.println("删除订单");
				DeleteOrderById(input, orderNum, orederCopies, orderDishes, orderPrices, ordertime, orderAddress,
						orderSumPrices, userNames, orders, orderStatuss);
				break;
			case 5:
				System.out.println("我要点赞");
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
			System.out.println("是否继续,继续请按:y/Y,退出系统请按:f/F");
			ifNext = input.next();
		} while (ifNext.equalsIgnoreCase("y"));
	}

	private static String MenuPraise(String state, Scanner input, int orderNum, int[][] orederCopies,
			String[][] orderDishes, int[] ordertime, String[] orderAddress, int[] orderSumPrices, String[] userNames,
			String[] orders, int[] orderStatuss, int[] orderPraise) {
		System.out.println("请输入点赞的订单号：");
		System.out.print("序号\t订餐人\t\t订餐时间（x：00）\t订餐地址\t总金额\t订单状态\t点赞量\t订单餐名\t\t订单份数");
		for (int i = 0; i <= orderNum - 1; i++) {
			if (userNames[i] != null) {
				if (orderStatuss[i] == 1) {
					state = "已完成";
				} else if (orderStatuss[i] == 0) {
					state = "已预订";
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
		System.out.print("当前的订单表，请选择：");
		int choose1 = input.nextInt();
		orderPraise[choose1]++;

		System.out.println("=========================当前的点赞查看：");

		System.out.print("序号\t订餐人\t\t订餐时间（x：00）\t订餐地址\t总金额\t订单状态\t点赞量\t订单餐名\t\t订单份数");
		for (int i = 0; i <= orderNum - 1; i++) {
			if (userNames[i] != null) {
				if (ordertime[i] == 1) {
					state = "已完成";
				} else if (ordertime[i] == 0) {
					state = "已预订";
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
		System.out.println("请输入要删除的订单号");
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

			System.out.println("删除成功！");
		} else {
			System.out.println("因不满足条件,不能删除该订单");
		}
	}

	private static int OrderMenu(Scanner input, int orderNum, int[][] orederCopies, String[][] orderDishes,
			double[][] orderPrices, int[] ordertime, String[] orderAddress, int[] orderSumPrices, String[] userNames,
			int[] orderStatuss, int[] indexs, String[] dishes, double[] prices, int[] orderPraise, int count) {
		String ifNext;
		// do{
		// 打印menu
		System.out.println("订单序号\t菜名\t\t价格");
		for (int i = 0; i < indexs.length; i++) {
			System.out.println(indexs[i] + "\t" + dishes[i] + "\t\t" + prices[i]);
		}

		System.out.println("请输入订单人的姓名：");
		String name = input.next();
		userNames[orderNum] = name;
		double priceNow=0;
		do {
			
			System.out.println("请输入订单序号：");
			int orderIndex = input.nextInt();
			System.out.println("请输入订餐份数：");
			int copies = input.nextInt();
			orederCopies[orderNum][count] = copies;
			orderDishes[orderNum][count] = dishes[orderIndex - 1];
			orderPrices[orderNum][count] = prices[orderIndex - 1] * copies;
			System.out.println("您已添加\"" + dishes[orderIndex - 1] + "\"到订单");
			System.out.println("是否继续点餐，y/n");
			System.out.println("*************本系统活动**********：如果订单总金额超过100,减30元");
			//当前订单价格
			for(int i=0;i<=count;i++){
				priceNow+=orderPrices[orderNum][i];
			}
			System.out.println("当前已定价格："+priceNow);
			if(priceNow>=100){
				System.out.println("恭喜您的订单满足活动条件,^_^");
			}else{
				System.out.println("目前不满足活动条件");
			}
			System.out.println("请判断是否继续，y/n");
			ifNext = input.next();
			count++;
		} while (ifNext.equalsIgnoreCase("y"));

		System.out.println("您已成功订单");
		System.out.print("请输入您的订单时间：");
		int time = input.nextInt();
		if (time < 20 && time > 8) {
			ordertime[orderNum] = time;
		}
		System.out.println("请输入您的订餐地址：");
		String address = input.next();
		orderAddress[orderNum] = address;
		System.out.println("感谢您的订餐，以下是您的订餐内容：");
		int sum = 0;
		for (int i = 0; i <= count; i++) {
			sum += orderPrices[orderNum][i];
			orderSumPrices[orderNum] = sum;
		}

		System.out.println("您当前的订单为：" + orderSumPrices[orderNum]);
		orderStatuss[orderNum] = 0;
		orderPraise[orderNum] = 0;
		System.out.println("您此次的订单包含：");
		System.out.println("订单名\t\t购买份数\t");
		for (int i = 0; i < orderDishes[orderNum].length; i++) {
			if (orderDishes[orderNum][i] != null)
				System.out.println(orderDishes[orderNum][i] + "\t\t" + orederCopies[orderNum][i]);
		}
		System.out.println("我们将为" + name + "更快的送达，谢谢下次光临");
		// System.out.println("是否返回主界面，y/n");
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

		System.out.print("序号\t订餐人\t\t订餐时间（x：00）\t订餐地址\t总金额\t订单状态\t订单餐名\t\t订单份数");

		for (int i = 0; i <= orderNum; i++) {

			if (userNames[i] != null) {
				if (orderStatuss[i] == 1) {
					state = "已完成";
				} else if (orderStatuss[i] == 0) {
					state = "已预订";
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
		System.out.println("请选择要签收的单号");
		System.out.println("系统正在查阅目前您的订单状态~~~~~~~~~~~~~~~~~~~~~~~请稍等");
		int orderChoose = input.nextInt();
		if (userNames[orderChoose] != null && orderStatuss[orderChoose] == 0) {
			orderStatuss[orderChoose] = 1;
			System.out.println("您的订单处于预定，可以签收");
			System.out.println("...");
			System.out.println("您的订单已经完成，感谢订单~");
		} else {
			System.out.println("所有订单已经完成，没有可签收");
		}
	}

	public static void showMenu() {
		System.out.println("----------------欢迎使用“吃货联盟系统”--------------------");
		System.out.println("====================================================");
		System.out.println("1、我要订餐");
		System.out.println("2、查看餐袋");
		System.out.println("3、签收订单");
		System.out.println("4、删除订单");
		System.out.println("5、我要点赞");
		System.out.println("6、退出系统");
		System.out.println("=====================================================");
	}

}
