import java.util.Scanner;

public class WorkHome5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入您的姓名：\t");
		String name = sc.next();
		System.out.println("请输入5门成绩");
		int sum=0;
		int input=0;
		for(int i=0;i<5;i++){
			input=sc.nextInt();
			sum+=input;
			System.out.println("您输入的第"+i+"个数："+input);
		}
		double avg=sum/5;
		System.out.print("您输入的总成绩为"+sum);
		System.out.print("\t成绩平均分为"+avg);
	}	

}
