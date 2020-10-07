import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SourceView extends JFrame implements ActionListener{
    JPanel sPane = new JPanel(new BorderLayout());
    	JLabel urlLbl = new JLabel("  url : ");
    	JTextField urlTxt = new JTextField();
    	JButton okBtn = new JButton("소스보기");    
    JTabbedPane tPane = new JTabbedPane();
    
	public SourceView() {
		setViewLayout();
		
		setSize(600,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void setViewLayout() {
		setTitle("소스보기");
		add(sPane, BorderLayout.NORTH);
			sPane.add(urlLbl, "West");
			sPane.add(urlTxt);
			sPane.add(okBtn, BorderLayout.EAST);
		add(tPane);			
	
		//이벤트 등록
		urlTxt.addActionListener(this);
		okBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == urlTxt || obj == okBtn) {
			getSource();
		}
		
	}
	public void getSource() {
		try {
			String urlAddress = urlTxt.getText();
			
			URL url = new URL(urlAddress);
			
			URLConnection conn = url.openConnection();			
			                                    
			String type = conn.getContentType(); 
			String code = type.substring(type.indexOf("set=")+4);
			
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is, code);
			BufferedReader  br = new BufferedReader(isr);
			
			JTextArea ta = new JTextArea();
			JScrollPane sp = new JScrollPane(ta);
			
			while(true) {
				String readData = br.readLine();
				if(readData == null) {
					break;
				}
				ta.append(readData+"\n");////
			}
			tPane.add(urlAddress, sp);
			urlTxt.setText("http://");			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SourceView sv = new SourceView();
	}
}