class Variable01{
	public static void main(String args[]){

	//1�ּ�: ����

	/*
	������ �ּ���
	*/

	//���� ���� = �⺻ ��������, ���۷�����(��ü��)

	//���� :byte(1byte),short(2byte),int(4byte �⺻ Ÿ��), long(8byte)
	//���: 100,50

	byte korJumsu=100;
	int engJunmsu =50;

	int hap=korJumsu+engJunmsu;
	
	//Ŭ����.����.�޼ҵ�
	//1���� ��� ���� = �޼ҵ� ����
	/*
		print():��� �� �� �ٲ�X
		println():��� �� �� �ٲ�
		printf():
	*/
	System.out.println("����: "+korJumsu);
	System.out.println("����: "+engJunmsu);
	System.out.println("�հ�: "+hap);

	System.out.println(korJumsu+"+"+engJunmsu+"="+hap);

	//�� ��ȯ = typecasting��
	byte num=(byte)130;
	System.out.println("num: "+num);
	
	int num2=num;

	System.out.println("num2: "+num2);

	}//end of main
}//end of class


	/*
	���� ���� ��Ģ
	 1. �ҹ��ڷ� ����
	 2. ù��° ���ڴ� ����, _,$�� ����
	 3. Ư������(_.$����)�� ����� �� ����.
	 4. �ռ����� ��� �ι�° �ܾ��� ù ��° ���ڴ� �빮�ڷ� �����Ѵ�.
	*/