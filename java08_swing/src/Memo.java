import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java08_swing.RGB2;

public class Memo extends JFrame implements ActionListener {
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	
	//���� ����
	String buffer;

	// �޴� ����
	JMenuBar mb = new JMenuBar();
	JMenu fileMenu = new JMenu("����");
		JMenuItem newMenu = new JMenuItem("������");
		JMenuItem openMenu = new JMenuItem("����");
		JMenu saveMenu = new JMenu("�����ϱ�");
			JMenuItem save = new JMenuItem("save");
			JMenuItem saveAs = new JMenuItem("save as");
			JMenuItem endMenu = new JMenuItem("����");
	JMenu editMenu = new JMenu("����");
		JMenuItem copyMenu = new JMenuItem("�����ϱ�");
		JMenuItem cutMenu = new JMenuItem("�����α�");
		JMenuItem pasteMenu = new JMenuItem("�ٿ��ֱ�");
	JMenu fontMenu = new JMenu("�۲�");
		JMenuItem fontColor = new JMenuItem("���ڻ�");
	JMenu runMenu = new JMenu("����");
		JMenuItem memoMenu = new JMenuItem("�޸���");
		JMenuItem editplusMenu = new JMenuItem("����Ʈ�÷���");
		JMenu browerMenu = new JMenu("��������");
			JMenuItem chromeMenu = new JMenuItem("ũ��");
			JMenuItem expMenu = new JMenuItem("�ͽ��÷η�");
		JMenuItem complieMenu = new JMenuItem("������");
		JMenuItem javaRunMenu = new JMenuItem("�ڹٽ���");

	public Memo() {
		super("�޸���");
		add(sp);

		// �޴�
		mb.add(fileMenu);
		mb.add(editMenu);
		mb.add(fontMenu);
		mb.add(runMenu);
		fileMenu.add(newMenu);
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		fileMenu.add(endMenu);
		saveMenu.add(save);
		saveMenu.add(saveAs);

		editMenu.add(copyMenu);
		editMenu.add(cutMenu);
		editMenu.add(pasteMenu);

		fontMenu.add(fontColor);
		
		runMenu.add(memoMenu);
		runMenu.add(editplusMenu);
		runMenu.add(browerMenu);
		runMenu.add(complieMenu);
		runMenu.add(javaRunMenu);
		browerMenu.add(chromeMenu);
		browerMenu.add(expMenu);

		setJMenuBar(mb);

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// �̺�Ʈ ���
		newMenu.addActionListener(this);
		openMenu.addActionListener(this);
		save.addActionListener(this);
		saveAs.addActionListener(this);
		endMenu.addActionListener(this);

		copyMenu.addActionListener(this);
		cutMenu.addActionListener(this);
		pasteMenu.addActionListener(this);
		
		fontColor.addActionListener(this);

		memoMenu.addActionListener(this);
		editplusMenu.addActionListener(this);
		chromeMenu.addActionListener(this);
		expMenu.addActionListener(this);

		complieMenu.addActionListener(this);
		javaRunMenu.addActionListener(this);
		
		setShortCut();//����Ű ����
		

	}

	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if (event == endMenu) {
			dispose();// �ڿ� ����
			System.exit(0);
		} else if (event == newMenu) {
			ta.setText("");
			setTitle("�޸���");
		} else if (event == openMenu) {// ����
			openMenu();
		} else if (event == save) {
			saveMenu();
		} else if(event == copyMenu) {
			copyMenu();
		} else if (event == pasteMenu) {
			pasteMenu();
		} else if(event == cutMenu) {
			cutMenu();
		} else if (event == memoMenu) {
			startProcess("notepad.exe");
		} else if(event == editplusMenu) {
			startProcess("C://Program Files/EditPlus/editplus.exe"); //����̺�� 2�� ���ϻ��̴� 1��'/'
		} else if(event == expMenu) {
			startProcess("C://Program Files/Internet Explorer/iexplore.exe");
		} else if(event == chromeMenu) {//�� ĭ ���� ������ �Է��ϸ� �� �ּҰ� ��.
			startProcess("C://Program Files (x86)/Google/Chrome/Application/chrome.exe https://www.nate.com"); 
		} else if(event == complieMenu) {//�� ĭ ���� ���ϸ�
			startProcess("javac "+getTitle()); //javac d:\test0813.java
		} else if(event == javaRunMenu) {
			javaRunStart();
		} else if(event == fontColor) {
			setFontColor();
		}

	}// �̺�Ʈ �޼ҵ�
	
	//���ڻ�
	public void setFontColor() {
		//Dialog: �⺻ ���̾ƿ� BorderLayout
		JDialog dialog = new JDialog(this, "RGB�ڵ�",false); //true : modal ����, false : modal ����
		dialog.add("Center", new RGB2(ta,dialog));
		dialog.setSize(500, 400);
		dialog.setVisible(true);
	}
	
	public void javaRunStart() {
		String fileName = getTitle();
		if(!fileName.equals("�޸���")) {
			try {
				Runtime runtime = Runtime.getRuntime();
				Process process = runtime.exec("java "+fileName);
				InputStreamReader isr = new InputStreamReader(process.getInputStream());
				BufferedReader br = new BufferedReader(isr);
				while(true) {
					String buffer = br.readLine();
					if(buffer==null) break;
					System.out.println(buffer);
				}				
			}catch(Exception e){
				System.out.println(e.toString());
			}
			System.out.println("����Ϸ�....");
		}
	}
	
	public void startProcess(String fileName) {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec(fileName);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//������
	public void cutMenu() {
		//buffer = ta.getSelectedText();
		copyMenu();
		ta.replaceSelection("");
		
	}
	
	//�ٿ��ֱ�
	public void pasteMenu(){
		ta.replaceSelection(buffer);
	}

	//����
	public void copyMenu() {
		buffer = ta.getSelectedText();
	}
	
	
	// �����ϱ�
	public void saveMenu() {
		JFileChooser fc = new JFileChooser();
		int result = fc.showSaveDialog(this);
		if (result == 0) {// 0:����, 1:���
			try {
				File f = fc.getSelectedFile(); // ������ ��ο� ���ϸ� ������
				FileWriter fw = new FileWriter(f);

				String txt = ta.getText();
				fw.write(txt);
				fw.close();
				setTitle(f.getPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// ����
	public void openMenu() {
		File f = new File("D://javaDev");
		JFileChooser fc = new JFileChooser(f); // ���� Ž����
		// filter����
		FileFilter f1 = new FileNameExtensionFilter("�ڹ�(.java)", "java", "JAVA", "Java");
		fc.addChoosableFileFilter(f1);

		FileFilter f2 = new FileNameExtensionFilter("�ڹ�(.class)", "class");
		fc.addChoosableFileFilter(f2);

		FileFilter f3 = new FileNameExtensionFilter("�̹���", "jpg", "gif", "png");
		fc.addChoosableFileFilter(f3);

		int result = fc.showOpenDialog(this); // 0:����, 1:���
		if (result == 0) { // ���� ��ư�� ������ ���
			try {
				File selectFile = fc.getSelectedFile();// ������ ���ϸ�� ���
				FileInputStream fis = new FileInputStream(selectFile);
				byte data[] = new byte[(int) selectFile.length()];// �뷮�� Ŀ���� ������ �ȵǴ� Buffer�� ���ִ°� ����.
				int cnt = fis.read(data);
				if (cnt > 0) {
					ta.setText(new String(data));
				}
				setTitle(selectFile.getPath());

			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//����Ű ����
	public void setShortCut() {
		//		   mask  key
		// ���� --> ctrl + o
		openMenu.setMnemonic(KeyEvent.VK_O);
		openMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		
		// ���� --> alt + s
		save.setMnemonic(KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
	}
	
	public static void main(String[] args) {
		new Memo();
	}

}
