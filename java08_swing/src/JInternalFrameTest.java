import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JInternalFrameTest extends JFrame implements ActionListener{
	JDesktopPane dp = new JDesktopPane();
	JPanel btnPane = new JPanel();
		JButton saveBtn = new JButton("�����ϱ�");
		JButton openBtn = new JButton("�ҷ�����");
	
	public JInternalFrameTest() {
		super("JInternalFrame");
		add(dp);
		
		add("North",btnPane);
		btnPane.add(saveBtn); btnPane.add(openBtn);
		saveBtn.addActionListener(this);
		openBtn.addActionListener(this);
		
		//InternalFrame ��ü
		JInternalFrame if1 = new JInternalFrame("�޷�");
		CalendarSwing2 cal = new CalendarSwing2();
		if1.add(cal);
		if1.setSize(400,300);
		if1.setVisible(true);
		dp.add(if1);
		//										  ����,  resize, closing, maximum, icon
		JInternalFrame if2 = new JInternalFrame("�޸���", true, true, true, true);
		JTextArea ta = new JTextArea();
		if2.add(ta);
		if2.setBounds(100,100,400,300);//��ǥ, ��, ����
		if2.setVisible(true);
		dp.add(if2);
		if2.toFront();
		
		JInternalFrame if3 = new JInternalFrame("�޸���", true, true, true, true);
		JTextArea ta2 = new JTextArea();
		if3.add(ta2);
		if3.setBounds(200, 200, 400, 400);
		if3.setVisible(true);
		dp.add(if3);
		if3.toFront();
		
		setSize(1000,1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String btn = ae.getActionCommand();
		if(btn.equals("�ҷ�����")) {
			openFile();
		}else if(btn.equals("�����ϱ�")) {
			saveFile();
		}
		
	}
	
	//�����ϱ�
	public void saveFile() {
		//DesktopPane���� Ȱ��ȭ�� InternalFrame ��ü ������.
		JInternalFrame frm= dp.getSelectedFrame();
		//���� �Էµ� ��ü ������
		JTextArea ta = (JTextArea)frm.getFocusOwner();
		String title = frm.getTitle();
		File f;
		if(title.equals("�޸���")) {
			JFileChooser fc= new JFileChooser();
			int state = fc.showSaveDialog(this);
			if(state==0) {
				try {
					f = fc.getSelectedFile();
					FileWriter fw = new FileWriter(f);
					fw.write(ta.getText(),0,ta.getText().length());
					fw.close();
				}catch(IOException ie) {}
			}
		}else {//ó�� ������ �ƴ� ��
			try {
				f=new File(title);	
				FileWriter fw = new FileWriter(f);	
				fw.write(ta.getText(),0,ta.getText().length());
				fw.close();
			}catch(IOException ie) {}
		}
		
	}
	
	//�ҷ�����
	public void openFile() {
		JFileChooser fc = new JFileChooser();
		int state = fc.showOpenDialog(this); // 0: ���, 1: ����
		if(state ==0) {
			try {
				File f = fc.getSelectedFile();
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				char readData[] = new char[(int)f.length()];
				int cnt = br.read(readData, 0, (int)f.length());
				if(cnt>0) {
					JInternalFrame f4 = new JInternalFrame(f.getPath(), true, true, true, true);
					JTextArea ta = new JTextArea(new String(readData));
					f4.add(ta);
					f4.setBounds(250, 250, 700, 700);
					f4.setVisible(true);
					dp.add(f4);
					f4.toFront();
				}
			}catch(FileNotFoundException fnfe) {
				System.out.println("������ ���� ��");
			}catch(IOException ie) {
				System.out.println("���� �б� ����");
			}
		}
		
		
	}
	public static void main(String[] args) {
		new JInternalFrameTest();
	}

}
