package test1;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
//		int count = input.nextInt();
//		int i = 0;
//		int sum = 0;
//		while (i < count) {
//			if (i % 2 == 0) {
//				System.out.println("能被2整除的数" + i);
//				sum += i;
//			}
//			i++;
//		}
//		
//		System.out.println(count + "以内之和为" + sum);
	int count=0;
	for(int i=0;i<=100;i++){
		if(i%2==0){
			count+=i;                                                               
		}
	}
	System.out.println(count);
	
	
	
	
	
	
	
	
	
	
	}
	
	
}
