
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
//new GenericTest<String>() -->V가 String이 되는 것.
//new GenericTest<Calendar>() -->V가 Calendar가 되는 것.
