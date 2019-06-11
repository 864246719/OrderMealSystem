package test1;

import java.util.Scanner;

public class ComputerComplete {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		System.out.println("请输入计算机编程大赛的成绩");
//		int score = sc.nextInt();
//		switch(score){
//		case 1: 
//			System.out.println("麻省理工大学组织的一个月夏令营");
//			break;
//		case 2: 
//			System.out.println("惠普笔记本一台");
//			break;
//		case 3: 
//			System.out.println("移动硬盘");
//			break;
//		default: 
//			System.out.println("没有任何奖励");
//		}
		
//		switch(score/10){
//		case 6:
//			System.out.println("及格");
//			break;
//		case 7:
//			System.out.println("中等");
//			break;
//		case 8:
//			System.out.println("良好");
//			break;
//		case 9:
//			System.out.println("优秀");
//			break;
//		case 10:
//			System.out.println("满分");
//			break;
//		default:
//			System.out.println("差");
//			break;
//		}
//		System.out.println("请输入");
//		int i=0;
//		while(i<50){
//			System.out.println("打印第"+i+"遍");
//			i++;
//		}
//		System.out.println("请输入张浩的 学习任务是否合格，合格/不合格");
//		String input = sc.next();
//		while(input.equals("不合格")){
//			System.out.println("请输入时间点：上午/中午/下午");
//			String input1 = sc.next();
//			while(input1.equals("上午")){
//				System.out.println("阅读教材");
//				break;
//			}
//			while(input1.equals("中午")){
//				System.out.println("学习理论部分");
//				break;
//			}
//			while(input1.equals("下午")){
//				System.out.println("上机编程，掌握代码部分");
//				break;
//			}
//			break;
//		}
//		while(input.equals("合格")){
//			System.out.println("不需要任何任务");
//			break;
//		}
//		System.out.println("请输入y/n");
		/*boolean b=false;
		while(!b){
			
			
			System.out.println("请输入是否合格：");
			String next = sc.next();
			 b=next.equalsIgnoreCase("y") ? true: false;
		}*/
		
		String next1;
		do{
			System.out.println("学习ing");
			System.out.println("是否继续学习，y/n");
			 next1 = sc.next();
		}while(next1.equalsIgnoreCase("y"));
		System.out.println("不学习了");
		
		
		
	}

}
