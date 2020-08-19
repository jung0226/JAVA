class ArrayEx3 
{
	public static void main(String[] args) 
	{
		int arr[][]= new int[10][10];
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				if(i==j || (i+j)==arr[i].length-1) arr[i][j]=100;				
			}
		}

		//Ãâ·Â
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				System.out.printf("%5d",arr[i][j]);
				//System.out.print(arr[i][j]+"\t");				
			}
			System.out.println();
		}
	}//end of main
}
