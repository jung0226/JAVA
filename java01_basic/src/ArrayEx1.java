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
		System.out.println("합계 = "+sum);
		System.out.println("평균 = "+avg);

		/*강사님 방법

		//합계, 평균도 배열에 넣기
		int numArr[]=new int[102]; // 0~101
		//난수를 생성하여 배열에 추가, index 100의 위치에 
		for(int idx=0; idx<numArr.length-2; idx++){//0~99
			//1~1000
			numArr[idx]= (int)(Math.random()*1000)+1;
			//			102
			numArr[numArr.length-2] += numArr[idx];			
		}
		//평균
		numArr[numArr.length-1]=numArr[numArr.length-2]/(numArr.length-2);//평균

		for(int i=0;i<numArr.length;i++){//0~101
			if(i==numArr.length-2){
				System.out.print("\n합계="+numArr[i]);
			}else if(i==numArr.length-1){
				System.out.println("\n평균="+numArr[i]);
			}else{
				System.out.print(numArr[i]+"\t");
			}
		}

		*/

	}//end of main
}
/*
배열의 난수(1~1000)사이의 100개 저장하고
배열의 값을 합계와 평균을 구하라.

실행
1 34 4343 343
:
:
합계=_____
평균=_____

*/
