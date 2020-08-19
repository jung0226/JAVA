import java.util.LinkedList;

public class LinkedListTest {

	public LinkedListTest() {
	}
	public void start() {
		//LinkedList: �Է¼�������, queue(���� �Էµ� ��ü ���� ���:FIFO), dequeó���� �� �� �ִ�.
		//			   ��ü�� output�ϸ� �÷��ǿ��� ��ü�� ���ŵȴ�.
		
		LinkedList<String> ll = new LinkedList<String>();
		
		//��ü �߰�
		ll.offer("ȫ�浿");
		ll.offer("�̼���");
		ll.offer("�������");
		
		//��ü �� ���ϱ�
		System.out.println("��ü�� = "+ll.size());
		String str= ll.poll();
		System.out.println("str= "+str);
		System.out.println("��ü�� = "+ll.size());
		
		ll.offerFirst("����");
		System.out.println("��ü�� = "+ll.size());
		
		String str2= ll.pollLast();
		System.out.println("str2= "+str2);	
		System.out.println("��ü�� = "+ll.size());
		
		//�÷����� ��� ��ü�� ������� ����϶�.
		while(!ll.isEmpty()) {//��ü�� ���� �� false, ���� �� true
			//���
			System.out.println("-->"+ll.poll());
			
		}
		
	}

	public static void main(String[] args) {
		new LinkedListTest().start();

	}

}
