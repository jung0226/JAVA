
public class GenericTest<V> {
	private V name;
	public GenericTest() {
		// TODO Auto-generated constructor stub
	}
	public void setName(V name) {
		this.name=name;
	}
	public V getName() {
		return name;
	} 

}
//new GenericTest<String>() -->V�� String�� �Ǵ� ��.
//new GenericTest<Calendar>() -->V�� Calendar�� �Ǵ� ��.
