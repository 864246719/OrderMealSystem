import java.util.Scanner;

public class WorkHome3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("���������ʽ,������");
		System.out.print("�������һ�����֣�");
		double firstNum = sc.nextDouble();
		System.out.print("�������������");
		String next = sc.next();
		System.out.print("������ڶ������֣�");
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
				
				System.out.print("��������ڶ������֣�");
				
				do{
					secondNum = sc.nextInt();
					System.out.print("����Ϊ0�����������룡");
				}while(secondNum==0);
				result=firstNum/secondNum;
			}
		}
		System.out.print(result);
	}

}
