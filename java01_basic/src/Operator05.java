class Operator05 
{
	public static void main(String[] args) 
	{
		//비트 연산자 : 2진수 계산을 하는 연산자
		//			$, |, ~(부정), ^(EOR:두 값이 다를 때 참)


		int a = 10;
		int b = 3;
		int c = a & b;

		System.out.println("c= "+c);

		int d = a | b;

		System.out.println("d= "+d);

		//음수인 경우 2의 보수로 만든다.
		//2의 보수는 1의 보수 + 1을 하면 된다.
		//1의 보수는 0->1, 1->0으로 바꾸는 것.
		int e= ~a;
		System.out.println("e= "+e);

		int f= a^b;
		System.out.println("f= "+f);

		//쉬프트연산자
		// <<:왼쪽으로 이동(0으로 채워짐, 넘치면 버림), >>:오른쪽으로 이동(부호로 채워짐)
		// >>>:오른쪽으로 이동(0으로 채워짐)

		int g = a<<2; //40 -->곱
		System.out.println("g= "+g);

		a=-10;

		int h = a>>2; //2 -->
		System.out.println("h= "+h);//3

		int i = a>>>2;
		System.out.println("i= "+i);//62

		

	}
}
