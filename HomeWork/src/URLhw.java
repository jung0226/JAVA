import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class URLhw extends JFrame implements ActionListener {
	JPanel northPane = new JPanel();
		JLabel lbl = new JLabel("URL");
		JTextField txtbox = new JTextField(20);
		JButton btn = new JButton("소스보기");
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	String inData;
	public URLhw() {
		add(BorderLayout.NORTH, northPane);
		add(sp);
		northPane.add(lbl);
		northPane.add(txtbox);
		northPane.add(btn);

		setSize(500, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		btn.addActionListener(this);
		txtbox.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent k) {
				int key = k.getKeyCode();
				if(key == KeyEvent.VK_ENTER) {
					urlFunction();
				}
			}
		});
	}

	// 버튼 이벤트
	public void actionPerformed(ActionEvent ae) {	
		urlFunction();
	}
	
	public void urlFunction() {
		try {
			String urlStr = txtbox.getText();
			URL url = new URL(urlStr);
			
			URLConnection connection = url.openConnection();
			connection.connect();// 통신 채널 확보

			String contentType = connection.getContentType();// 헤더 정보 얻어오기
		
			int idx = contentType.indexOf("charset=");
			String code = contentType.substring(idx + 8);

			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is, code);
																	
			BufferedReader br = new BufferedReader(isr);

			while (true) {
				String inData = br.readLine();
				if (inData == null)
					break;
				ta.append(inData+"\n");
				
				}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void main(String[] args) {
		new URLhw();
	}

}