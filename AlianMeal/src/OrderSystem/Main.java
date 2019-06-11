package OrderSystem;

import java.util.Scanner;

public class Main {



	public static void main(String[] args) {
		int orderSum=0;//每次订单计数器全局变量
		int everySum=0;
		int priceCount = 0;
		Scanner input = new Scanner(System.in);
		String ifNext = "",ifPurchase="";
		//userNames  orederIds  orderNums orderAddresses supports remarks
		String[] userNames=new String[4];
		String[] timeReachs=new String[4];
		String[] orderAddresses=new String[4];
		String[] remarks=new String[4];
		int[] orederIds=new int[4];
		String[][] dishess=new String[3][3];
		String[][] dishessNames=new String[3][3];
		double[][] dishessPrice=new double[3][3];
		int[][] dishessCount=new int[3][3];
		int[] orderNums=new int[4];
		int[] supports=new int[4];
		int[] states=new int[4];
		
		int[] serials=new int[3];
		String[] dishes=new String[3];
		double[] prices=new double[3];
		for(int i=0 ;i<serials.length;i++){
			serials[i]=i+1;
		}
		dishes[0]="汉堡";dishes[1]="鸡柳";dishes[2]="可乐"; 
		prices[0]=8;prices[1]=6;prices[2]=4;
		showMenu();
		do {
			System.out.println("请输入订餐系统选项");
			int choice = input.nextInt();
			switch(choice){
			case 1:
				System.out.println("------------------我要订餐-----------------------");
				System.out.println("==================菜单列表=========================");
				System.out.println("序号\t\t菜名\t\t价格");
				for(int i=0;i<serials.length;i++){
					System.out.println(serials[i]+"\t\t"+dishes[i]+"\t\t"+prices[i]);
				}
				//userNames  orederIds  orderNums orderAddresses supports remarks
				System.out.println("请输入您的姓名:");
				String name=input.next();
				do{
					System.out.println("请输入您购买的订单序号:");
					int orderId=input.nextInt();
					System.out.println("请输入购买的份数:");
					int purchaceNum=input.nextInt();
					//ordersum第几个订单     everySum 一个订单的计数
					//该订单的所有商品的价格
					//该订单的商品名保存
					dishess[orderSum][everySum]=dishes[orderId-1];
					dishessPrice[orderSum][everySum]=prices[orderId-1];
					dishessCount[orderSum][everySum]=purchaceNum;
					everySum++;
					
					
					//是否需要再次购买 y/n
					System.out.println("是否继续购买,继续Y,输入其他为N");
					ifPurchase=input.next();
				}while(ifPurchase.equalsIgnoreCase("y"));
				
				
				System.out.println("请输入您送货地址方便送到:");
				String address=input.next();
				
				System.out.print("请输入几点送达：");
				String timeReach=input.next();
				
				
				for(int i=0;i<dishessPrice[orderSum].length;i++){
					priceCount+=dishessPrice[orderSum][i]*dishessCount[orderSum][i];
				}
				
				
				//当前购买的价格
				userNames[orderSum]=name;
				orderAddresses[orderSum]=address;
				prices[orderSum]=priceCount;
				timeReachs[orderSum]=timeReach;
				System.out.println("输入您对当前订单的状态，输入：已预订或订单完成");
				String inputStates=input.next();
				states[orderSum] =inputStates.equals("已预订") ? 0 : 1 ;
				if(orderSum<=2){
					orderSum++;
				}
				
				System.out.println("============================打印订单===============================");
				for(int j=0;j<userNames.length;j++){
//					if(userNames[j]!=null){
						System.out.println("用户名："+userNames[j]);
						for(int i=0;i<orderSum;i++){
							if(dishess[j][i]!=null||dishessCount[j][i]!=0){
								System.out.println("购买的产品名："+dishess[j][i]+"\t购买数量为"+dishessCount[j][i]);
							}
						}
						System.out.println("当前总价格为："+priceCount);
						System.out.println("当前订单的地址："+orderAddresses[j]);
						System.out.println("对于当前的状态："+states[j]);
						System.out.println("点赞数"+supports[j]);
//					}
					
				}
				
				break;
			case 2:
				
				break;
			case 3:
				break;
			case 4:
				System.out.println("删除订单");
				break;
			case 5:
				
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
