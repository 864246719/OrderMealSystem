import java.util.Scanner;

public class WorkHome5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("����������������\t");
		String name = sc.next();
		System.out.println("������5�ųɼ�");
		int sum=0;
		int input=0;
		for(int i=0;i<5;i++){
			input=sc.nextInt();
			sum+=input;
			System.out.println("������ĵ�"+i+"������"+input);
		}
		double avg=sum/5;
		System.out.print("��������ܳɼ�Ϊ"+sum);
		System.out.print("\t�ɼ�ƽ����Ϊ"+avg);
	}	

}
