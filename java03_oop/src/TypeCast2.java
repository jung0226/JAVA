
public class TypeCast2 extends TypeCast1{
	int num=200;
	String name = "GilDong";
	public TypeCast2() {
	}
	public void prn() {
		System.out.println("num= "+num+", name= "+name);
	}
	
	//오버라이딩
	public boolean equals(Object obj) {
		TypeCast2 tc=(TypeCast2)obj;
		if(tc.num == 100) {
			return false;
		}else {
			return true;
		}

	}

}
