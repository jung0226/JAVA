package javaApi;

import java.util.Random;

class RandomTest2 
{
	public static void main(String[] args) 
	{
		// RandomŬ������ �̿��� ���� �����
		Random ran = new Random();
		
		for(int i=1;i<=500;i++){
			// int ������ ���� ���� ������ ��
			// nextDouble(), nextFloat()
			// nextBoolean()
			//0~99. 0~49
			//int ranInt = ran.nextInt(50); //int�� ������ ������. nextLong()
			
			//51~100,              (ū �� - ���� ��+1)
			int ranInt = ran.nextInt(50)+51;

			//boolean ranInt= ran.nextBoolean();
			//double ranInt= ran.nextDouble();
			System.out.print(ranInt+"\t");
		}
	}
}
