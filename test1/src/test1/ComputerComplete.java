package test1;

import java.util.Scanner;

public class ComputerComplete {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		System.out.println("������������̴����ĳɼ�");
//		int score = sc.nextInt();
//		switch(score){
//		case 1: 
//			System.out.println("��ʡ����ѧ��֯��һ��������Ӫ");
//			break;
//		case 2: 
//			System.out.println("���ձʼǱ�һ̨");
//			break;
//		case 3: 
//			System.out.println("�ƶ�Ӳ��");
//			break;
//		default: 
//			System.out.println("û���κν���");
//		}
		
//		switch(score/10){
//		case 6:
//			System.out.println("����");
//			break;
//		case 7:
//			System.out.println("�е�");
//			break;
//		case 8:
//			System.out.println("����");
//			break;
//		case 9:
//			System.out.println("����");
//			break;
//		case 10:
//			System.out.println("����");
//			break;
//		default:
//			System.out.println("��");
//			break;
//		}
//		System.out.println("������");
//		int i=0;
//		while(i<50){
//			System.out.println("��ӡ��"+i+"��");
//			i++;
//		}
//		System.out.println("�������źƵ� ѧϰ�����Ƿ�ϸ񣬺ϸ�/���ϸ�");
//		String input = sc.next();
//		while(input.equals("���ϸ�")){
//			System.out.println("������ʱ��㣺����/����/����");
//			String input1 = sc.next();
//			while(input1.equals("����")){
//				System.out.println("�Ķ��̲�");
//				break;
//			}
//			while(input1.equals("����")){
//				System.out.println("ѧϰ���۲���");
//				break;
//			}
//			while(input1.equals("����")){
//				System.out.println("�ϻ���̣����մ��벿��");
//				break;
//			}
//			break;
//		}
//		while(input.equals("�ϸ�")){
//			System.out.println("����Ҫ�κ�����");
//			break;
//		}
//		System.out.println("������y/n");
		/*boolean b=false;
		while(!b){
			
			
			System.out.println("�������Ƿ�ϸ�");
			String next = sc.next();
			 b=next.equalsIgnoreCase("y") ? true: false;
		}*/
		
		String next1;
		do{
			System.out.println("ѧϰing");
			System.out.println("�Ƿ����ѧϰ��y/n");
			 next1 = sc.next();
		}while(next1.equalsIgnoreCase("y"));
		System.out.println("��ѧϰ��");
		
		
		
	}

}
