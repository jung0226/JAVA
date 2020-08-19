class Array3 
{
	public static void main(String[] args) 
	{
		//arguments - 아규멘트, 매개변수, 파라미터
		//dos창에서 값을 반드시 3개 줘야 실행됨.
		/*
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		*/

		//id:admin, pw:1234
		// args[0].equls("admin") && args[1].equls("1234")
		if( "admin".equals(args[0]) && "1234".equals(args[1]) ){// ==를 쓰면 값이 저장되어있는 주소와 비교됨. equls메소드 사용하기.
			int sum=0;
			for(int i=1;i<=100;i++){
				sum+=i;				
			}
			System.out.println(sum);
		}else{//로그인 실패시
			System.out.println("아이디와 비밀번호를 잘못 입력하였습니다.");
		}



		
	}//end fo main
}
