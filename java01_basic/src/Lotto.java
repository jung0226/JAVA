import java.util.Scanner;
import java.util.Arrays;
class  Lotto
{
	public static void main(String[] args) 
	{
		
		Scanner scan = new Scanner(System.in);
		
		do{
			System.out.print("���� �� = ");
			int game= scan.nextInt();
			//���� ����
			for(int cnt=1;cnt<=game;cnt++){//���� �� ��ŭ �ݺ�
				//�ζǹ�ȣ ������ �迭
				int lotto[] = new int[7];

				//�ζ�
				for(int i=0; i<lotto.length; i++){
					lotto[i]=(int)(Math.random()*45)+1;

					//�ߺ��˻�
					for(int j=0; j<i; j++){
						if(lotto[j] == lotto[i]){
							i--;
							break;
						}//if
					}//�ߺ��˻� for		
				}//for

				//����
				/*
				for(int row=0; row<lotto.length-2;row++){
					for(int col=0;col<lotto.length-2;col++){
						if(lotto[col]>lotto[col+1]){
							int temp=lotto[col];
							lotto[col]=lotto[col+1];
							lotto[col+1]=temp;
						}
					}
					
				}*/
				Arrays.sort(lotto, 0, 6);
					
				
				//���
				System.out.print(cnt+"����=");
				/*
				for(int k=0;k<lotto.length-1;k++){
					System.out.print(lotto[k]);
					if(k==5){
						System.out.print("], ");
					}else{
						System.out.print(", ");
					}
				}//for
				*/
				System.out.print(Arrays.toString(Arrays.copyOfRange(lotto,0,6)));				
				System.out.println("bonus="+lotto[6]);
			}//���� ����for

			System.out.print("��� �Ͻðڽ��ϱ�?(1:��, 2:�ƴϿ�) ");
			int qa=scan.nextInt();
			if(qa!=1){//���α׷� ����		
				System.out.println("���α׷��� ����Ǿ����ϴ�.");
				break;				
			}

		}while(true);

		System.out.println();
	}//end of main
}
