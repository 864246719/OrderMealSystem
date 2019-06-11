import java.util.Scanner;

public class WorkHome3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入计算式,请输入");
		System.out.print("请输入第一个数字：");
		double firstNum = sc.nextDouble();
		System.out.print("请输入运算符：");
		String next = sc.next();
		System.out.print("请输入第二个数字：");
		double secondNum = sc.nextDouble();
		double result = 0;
		if(next.equals("+")){
			result=firstNum+secondNum;
		}else if(next.equals("-")){
			result=firstNum-secondNum;
		}else if(next.equals("*")){
			result=firstNum*secondNum;
		}else if(next.equals("/")){
			if(secondNum!=0){
				result=firstNum/secondNum;
			}else{
				
				System.out.print("重新输入第二个数字：");
				
				do{
					secondNum = sc.nextInt();
					System.out.print("输入为0，请重新输入！");
				}while(secondNum==0);
				result=firstNum/secondNum;
			}
		}
		System.out.print(result);
	}

}
