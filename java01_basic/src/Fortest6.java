class  Fortest6
{
	public static void main(String[] args) 
	{
		for(int i = 1; i <6;i++){
			for(int j = 1; j<6 ;j++){
				System.out.print("*");
			}
			System.out.println();//�� ����
		}
		/*
		������
		*
		**
		***
		****
		*****
		
		*/
		
		System.out.println();//�� ����
		for(int i = 1; i <6;i++){
			for(int j =1;j<=i;j++){
				System.out.print("*");
			}
			System.out.println();//�� ����
		}
		System.out.println();

		/*
		������
		***** 1~5
		****  1~4
		***   1~3
		**    1~2
		*     1~1

		*/

		for(int i=1; i<6 ; i++){
			for(int j = 5; j>=i ; j--){
				System.out.print("*");
			}
			System.out.println();
		}
		/* ���� ���
		for(int i = 5 ; i>=1 ; i--){//5 4 3 2 1
			for(int j=1 ; j<=i ; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		*/

		/*
		     *  �� 1 ���� 4, 5-��º��� = 4
			**  �� 2 ���� 3, 5-��º��� = 3
		   ***  �� 3 ���� 2, 5-��º��� = 2
		  ****  �� 4 ���� 1, 5-��º��� = 1
		 *****  �� 5 ���� 0  ��+���� = ��5
		
		*/
		
		System.out.println();

		for(int i=1 ; i<=5 ; i++){//���� �� 1,2,3,4,5
			
			//����
			for(int space=1; space<=5-i; space++){
				System.out.print(" ");
			}
			//��
			for(int j=1;j<=i;j++){		
				System.out.print("@");							
			}			
			System.out.println();//�ٹٲ�
		}

		/*
		
		*****  �� 5 ���� 0
		 ****  �� 4 ���� 1
		  ***  �� 3 ���� 2
		   **  �� 2 ���� 3
		    *  �� 1 ���� 4

			5 - ���� ����ϴ� ���� ��= ����
		*/
		System.out.println();

		for(int i=5 ; i>=1 ; i--){//���� �� 1,2,3,4,5

			//����
			for(int space=1;space<=5-i;space++){		
				System.out.print(" ");							
			}	
			
			//��
			for(int j=1; j<=i; j++){
				System.out.print("@");
			}
					
			System.out.println();//�ٹٲ�
		}

		/*
				*     �� 1 ���� 4 4. 9-�� =8. 8/2=4(������ ��)
			   ***    �� 3 ���� 3 3
			  *****   �� 5 ���� 2 2 
			 *******  �� 7 ���� 1 1
			********* �� 9 ���� 0 0
			 �� = ��+2
		*/

		for(int i=1; i <= 9; i+=2){//�� 1 3 5 7 9
			//���� 4 3 2 1
			for(int s=1;s<=(9-i)/2;s++){
				System.out.print(" ");
			}
			//�� ���
			for(int k=1;k<=i;k++){
				System.out.print("$");
			}

			System.out.println();//�ٹٲ�
		}	


	}//end of main
}
/*
��ø �ݺ��� : �ݺ������� �ݺ���

����
1	2	3	4	5
1	2	3	4	5
1	2	3	4	5
1	2	3	4	5
1	2	3	4	5
*/