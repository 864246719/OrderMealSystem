
public class WorkHome2 {

	public static void main(String[] args) {
		int evenSum=0;
		int oddSum=0;
		for (int i = 0; i <=100; i++) {
			if(i%2==0){
				evenSum+=i;
			}
			if(i%2!=0){
				oddSum+=i;
			}
		}
		System.out.println("偶数之和为："+evenSum+"\t奇数之和为："+oddSum);
	}
}
