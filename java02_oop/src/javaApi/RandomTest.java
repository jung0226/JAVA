package javaApi;

class RandomTest 
{
	public static void main(String[] args) 
	{
		//난수 생성
		//0.0~0.1사이의 값을 생성해준다.
		for(int i=1;i<=1000;i++){
			double ran = Math.random();//static이 앞에 붙어있어서. 사용 Scanner는 아님.
			//1~100			 (정수)(난수*(큰 수 - 작은수+1))+작은수
			//51~100				   100 -51+1
			int ranInt = (int)(ran*50)+51; // 100 --> 0~99, 50 --> 0~49
			System.out.print(ranInt+"\t");
		}


	}
}
