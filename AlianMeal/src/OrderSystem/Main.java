package OrderSystem;

import java.util.Scanner;

public class Main {



	public static void main(String[] args) {
		int orderSum=0;//ÿ�ζ���������ȫ�ֱ���
		int everySum=0;
		int priceCount = 0;
		Scanner input = new Scanner(System.in);
		String ifNext = "",ifPurchase="";
		//userNames  orederIds  orderNums orderAddresses supports remarks
		String[] userNames=new String[4];
		String[] timeReachs=new String[4];
		String[] orderAddresses=new String[4];
		String[] remarks=new String[4];
		int[] orederIds=new int[4];
		String[][] dishess=new String[3][3];
		String[][] dishessNames=new String[3][3];
		double[][] dishessPrice=new double[3][3];
		int[][] dishessCount=new int[3][3];
		int[] orderNums=new int[4];
		int[] supports=new int[4];
		int[] states=new int[4];
		
		int[] serials=new int[3];
		String[] dishes=new String[3];
		double[] prices=new double[3];
		for(int i=0 ;i<serials.length;i++){
			serials[i]=i+1;
		}
		dishes[0]="����";dishes[1]="����";dishes[2]="����"; 
		prices[0]=8;prices[1]=6;prices[2]=4;
		showMenu();
		do {
			System.out.println("�����붩��ϵͳѡ��");
			int choice = input.nextInt();
			switch(choice){
			case 1:
				System.out.println("------------------��Ҫ����-----------------------");
				System.out.println("==================�˵��б�=========================");
				System.out.println("���\t\t����\t\t�۸�");
				for(int i=0;i<serials.length;i++){
					System.out.println(serials[i]+"\t\t"+dishes[i]+"\t\t"+prices[i]);
				}
				//userNames  orederIds  orderNums orderAddresses supports remarks
				System.out.println("��������������:");
				String name=input.next();
				do{
					System.out.println("������������Ķ������:");
					int orderId=input.nextInt();
					System.out.println("�����빺��ķ���:");
					int purchaceNum=input.nextInt();
					//ordersum�ڼ�������     everySum һ�������ļ���
					//�ö�����������Ʒ�ļ۸�
					//�ö�������Ʒ������
					dishess[orderSum][everySum]=dishes[orderId-1];
					dishessPrice[orderSum][everySum]=prices[orderId-1];
					dishessCount[orderSum][everySum]=purchaceNum;
					everySum++;
					
					
					//�Ƿ���Ҫ�ٴι��� y/n
					System.out.println("�Ƿ��������,����Y,��������ΪN");
					ifPurchase=input.next();
				}while(ifPurchase.equalsIgnoreCase("y"));
				
				
				System.out.println("���������ͻ���ַ�����͵�:");
				String address=input.next();
				
				System.out.print("�����뼸���ʹ");
				String timeReach=input.next();
				
				
				for(int i=0;i<dishessPrice[orderSum].length;i++){
					priceCount+=dishessPrice[orderSum][i]*dishessCount[orderSum][i];
				}
				
				
				//��ǰ����ļ۸�
				userNames[orderSum]=name;
				orderAddresses[orderSum]=address;
				prices[orderSum]=priceCount;
				timeReachs[orderSum]=timeReach;
				System.out.println("�������Ե�ǰ������״̬�����룺��Ԥ���򶩵����");
				String inputStates=input.next();
				states[orderSum] =inputStates.equals("��Ԥ��") ? 0 : 1 ;
				if(orderSum<=2){
					orderSum++;
				}
				
				System.out.println("============================��ӡ����===============================");
				for(int j=0;j<userNames.length;j++){
//					if(userNames[j]!=null){
						System.out.println("�û�����"+userNames[j]);
						for(int i=0;i<orderSum;i++){
							if(dishess[j][i]!=null||dishessCount[j][i]!=0){
								System.out.println("����Ĳ�Ʒ����"+dishess[j][i]+"\t��������Ϊ"+dishessCount[j][i]);
							}
						}
						System.out.println("��ǰ�ܼ۸�Ϊ��"+priceCount);
						System.out.println("��ǰ�����ĵ�ַ��"+orderAddresses[j]);
						System.out.println("���ڵ�ǰ��״̬��"+states[j]);
						System.out.println("������"+supports[j]);
//					}
					
				}
				
				break;
			case 2:
				
				break;
			case 3:
				break;
			case 4:
				System.out.println("ɾ������");
				break;
			case 5:
				
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.exit(0);
					break;
			}
			System.out.println("�Ƿ����,�����밴:y/Y,�˳�ϵͳ�밴:f/F");
			ifNext = input.next();
		} while (ifNext.equalsIgnoreCase("y"));
	}

	public static void showMenu() {
		System.out.println("----------------��ӭʹ�á��Ի�����ϵͳ��--------------------");
		System.out.println("====================================================");
		System.out.println("1����Ҫ����");
		System.out.println("2���鿴�ʹ�");
		System.out.println("3��ǩ�ն���");
		System.out.println("4��ɾ������");
		System.out.println("5����Ҫ����");
		System.out.println("6���˳�ϵͳ");
		System.out.println("=====================================================");
	}
	
	
}
