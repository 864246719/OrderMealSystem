import java.util.Scanner;

public class WorkHome4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请分别输入5个数字：");
		double input=0;
		double min=0,max=0;
		for(int i=0;i<5;i++){
		 System.out.print("您输入的第"+(i+1)+"个数字:");
		 input = sc.nextDouble();
		 if(i==0){
			 min=input;
			 max=input;
		 }
		 if(input<min){
			 min=input;
		 }
		 if(input>max){
			 max=input;
		 }
		}
		System.out.println("最小值："+min+"\t最大值："+max);
	}

}
