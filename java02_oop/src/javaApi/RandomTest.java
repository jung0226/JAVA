package javaApi;

class RandomTest 
{
	public static void main(String[] args) 
	{
		//���� ����
		//0.0~0.1������ ���� �������ش�.
		for(int i=1;i<=1000;i++){
			double ran = Math.random();//static�� �տ� �پ��־. ��� Scanner�� �ƴ�.
			//1~100			 (����)(����*(ū �� - ������+1))+������
			//51~100				   100 -51+1
			int ranInt = (int)(ran*50)+51; // 100 --> 0~99, 50 --> 0~49
			System.out.print(ranInt+"\t");
		}


	}
}
