class Array3 
{
	public static void main(String[] args) 
	{
		//arguments - �ƱԸ�Ʈ, �Ű�����, �Ķ����
		//dosâ���� ���� �ݵ�� 3�� ��� �����.
		/*
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		*/

		//id:admin, pw:1234
		// args[0].equls("admin") && args[1].equls("1234")
		if( "admin".equals(args[0]) && "1234".equals(args[1]) ){// ==�� ���� ���� ����Ǿ��ִ� �ּҿ� �񱳵�. equls�޼ҵ� ����ϱ�.
			int sum=0;
			for(int i=1;i<=100;i++){
				sum+=i;				
			}
			System.out.println(sum);
		}else{//�α��� ���н�
			System.out.println("���̵�� ��й�ȣ�� �߸� �Է��Ͽ����ϴ�.");
		}



		
	}//end fo main
}
