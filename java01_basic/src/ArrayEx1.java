import java.util.Random;
class ArrayEx1 
{
	public static void main(String[] args) 
	{
		//double ran=Math.random();
		Random ran = new Random();
		int arr[]=new int[100];
		int sum=0;
		double avg=0;
		
		for(int i=0; i<arr.length;i++){
			int ranInt = ran.nextInt(1000)+1;
			arr[i]=ranInt;
			sum+=arr[i];
			
			System.out.print(arr[i]+"\t");
		}
		avg=(double)sum/arr.length;
		System.out.println();
		System.out.println("�հ� = "+sum);
		System.out.println("��� = "+avg);

		/*����� ���

		//�հ�, ��յ� �迭�� �ֱ�
		int numArr[]=new int[102]; // 0~101
		//������ �����Ͽ� �迭�� �߰�, index 100�� ��ġ�� 
		for(int idx=0; idx<numArr.length-2; idx++){//0~99
			//1~1000
			numArr[idx]= (int)(Math.random()*1000)+1;
			//			102
			numArr[numArr.length-2] += numArr[idx];			
		}
		//���
		numArr[numArr.length-1]=numArr[numArr.length-2]/(numArr.length-2);//���

		for(int i=0;i<numArr.length;i++){//0~101
			if(i==numArr.length-2){
				System.out.print("\n�հ�="+numArr[i]);
			}else if(i==numArr.length-1){
				System.out.println("\n���="+numArr[i]);
			}else{
				System.out.print(numArr[i]+"\t");
			}
		}

		*/

	}//end of main
}
/*
�迭�� ����(1~1000)������ 100�� �����ϰ�
�迭�� ���� �հ�� ����� ���϶�.

����
1 34 4343 343
:
:
�հ�=_____
���=_____

*/
