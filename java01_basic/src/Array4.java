class Array4 
{
	public static void main(String[] args) 
	{
		//�迭�� ����

		//�迭�� ���� �� �迭�� ũ�⸦ ������ �� ����.
		int arr[] = {55,15,78,69,86,41,99};//0~6
		int arr2[] = new int[20];

		//arraycopy(Object src, int srcpos, Object dest, int destPos, int length)
		//			���� �迭,	���� ���� index, Ÿ��(������) �迭��, ���� ��ġ, ���� 	
		System.arraycopy(arr,2,arr2,0,4);
		for(int i=0;i<arr2.length;i++){
			System.out.println(arr2[i]);
		}
		System.out.println("=================================");

		// Ȯ��� for��
		// �迭�� ������ Ÿ�Ժ��� : �迭��
		for(int data:arr){
			System.out.println(data);
		}

	}//end of main
}
