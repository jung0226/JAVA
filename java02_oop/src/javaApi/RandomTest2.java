package javaApi;

import java.util.Random;

class RandomTest2 
{
	public static void main(String[] args) 
	{
		// Random클래스를 이용한 난수 만들기
		Random ran = new Random();
		
		for(int i=1;i<=500;i++){
			// int 데이터 범위 내의 임의의 수
			// nextDouble(), nextFloat()
			// nextBoolean()
			//0~99. 0~49
			//int ranInt = ran.nextInt(50); //int형 정수를 생성함. nextLong()
			
			//51~100,              (큰 수 - 작은 수+1)
			int ranInt = ran.nextInt(50)+51;

			//boolean ranInt= ran.nextBoolean();
			//double ranInt= ran.nextDouble();
			System.out.print(ranInt+"\t");
		}
	}
}
