
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
		System.out.println("ż��֮��Ϊ��"+evenSum+"\t����֮��Ϊ��"+oddSum);
	}
}
