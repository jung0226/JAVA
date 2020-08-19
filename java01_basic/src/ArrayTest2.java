class ArrayTest2 
{
	public static void main(String[] args) 
	{
		System.out.println("=========정렬 전========");
		//배열에 난수 넣기.
		int arr[]=new int[5];
		for(int i=0; i<arr.length; i++){
			arr[i]=(int)(Math.random()*100)+1;
			
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		
		
		for(int i=0; i<arr.length-1; i++){
			for(int j=i+1;j<arr.length; j++){
				if(arr[i]<arr[j]){
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
			
				}
			}//for				
		}//for

		System.out.println("=========정렬 후========");
		for(int i=0;i<arr.length;i++){

			System.out.print(arr[i]+"\t");
		}

	}//end of main
}
