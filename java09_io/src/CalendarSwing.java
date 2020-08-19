import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Calendar;

import javax.swing.*;

public class CalendarSwing extends JFrame implements ActionListener, Serializable {
	Font fnt = new Font("����ü", Font.BOLD, 20);
	Calendar date = Calendar.getInstance();
	int year;
	int month;
	String[] weekStr = {"��", "��", "ȭ", "��", "��", "��", "��"};
	//Frame -> North
	JPanel northPane = new JPanel();
		JButton prevMonth = new JButton("��");
		JComboBox<Integer> yearCombo = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();
			JLabel yearLbl = new JLabel("�� ");
		JComboBox<Integer> monthCombo = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();
			JLabel monthLbl = new JLabel("��");
		JButton nextMonth = new JButton("��");
	//Frame -> Center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel titlePane = new JPanel(new GridLayout(1,7)); //��,��,ȭ..
		JPanel dayPane = new JPanel(new GridLayout(0,7)); //1,2,3..
	
	public CalendarSwing() {
		super("�޷�");
		
		//Frame => North
		add(BorderLayout.NORTH, northPane);
			northPane.add(prevMonth); northPane.add(yearCombo); 
			year = date.get(Calendar.YEAR);
			for(int y=year-100; y< year+20; y++) {
				yearModel.addElement(y);
			}
			yearCombo.setModel(yearModel);
			yearCombo.setSelectedItem(year);
			northPane.add(yearLbl); 
			
			northPane.add(monthCombo);
			month = date.get(Calendar.MONTH); //7
			for(int d=1; d<=12; d++) {
				monthModel.addElement(d);
			}
			monthCombo.setModel(monthModel);
			monthCombo.setSelectedItem(month+1);
			northPane.add(monthCombo);
			northPane.add(monthLbl); northPane.add(nextMonth);
			northPane.setBackground(new Color(150,200,200));
			
			//���� ��¥ ���
			add(centerPane);
				centerPane.add(BorderLayout.NORTH, titlePane);
			for(int i=0; i<weekStr.length; i++) {
				JLabel lbl = new JLabel(weekStr[i], JLabel.CENTER);
				lbl.setFont(fnt);
				lbl.setOpaque(true);
				lbl.setBackground(Color.WHITE);
				if(i==0) {
					lbl.setForeground(Color.RED);
				} else if(i==6) {
					lbl.setForeground(Color.BLUE);
				}
				titlePane.add(lbl);
			}
			
			centerPane.add("Center", dayPane);
			setDay();
				
				
		setSize(400, 350);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//�̺�Ʈ ���
		prevMonth.addActionListener(this);
		yearCombo.addActionListener(this);
		monthCombo.addActionListener(this);
		nextMonth.addActionListener(this);
	}
	
	public void start() {
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		year = (int)yearCombo.getSelectedItem();
		month = (int)monthCombo.getSelectedItem() -1;
		if(obj==yearCombo || obj==monthCombo) {
			getNewDate();	
		}else if(obj == prevMonth) { //���� �� ��ư
			
			if(month==0) {
				year--;
				month=11;
				
			}else {
				month--;
			}
			buttonDateSet();
		}else if(obj == nextMonth) {
			clearEvent();
			if(month==11) {
				year++;
				month=0;
			}else {
				month++;
			}
			buttonDateSet();
		}
		
	}
	
	public void buttonDateSet() {
		clearEvent();
		monthCombo.setSelectedItem(month+1);
		yearCombo.setSelectedItem(year);
		getNewDate();
		addEvent();
		
	}
	public void addEvent() {
		yearCombo.addActionListener(this);
		monthCombo.addActionListener(this);
	}
	public void clearEvent() {
		//��ư���� �̺�Ʈ �߻� �� ComboBox�� item�� �����ϸ鼭 ComboBox�� �̺�Ʈ�� ó���ǹǷ� �̺�Ʈ�� �����Ѵ�.
		yearCombo.removeActionListener(this);
		monthCombo.removeActionListener(this);
	}
	
	public void getNewDate() {
		//��¥ �����
		dayPane.setVisible(false);
		dayPane.removeAll();
		setDay();
		dayPane.setVisible(true);
	}

	public void setDay() {
		//����
		date.set(year, month, 1);
		int week = date.get(Calendar.DAY_OF_WEEK);
		
		//����ó��
		for(int space=1; space<week; space++) {
			JLabel lbl = new JLabel();
			dayPane.add(lbl);
		}
		
		//��¥�߰�
		int lastDay = date.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i=1; i<=lastDay; i++) {
			JLabel lbl = new JLabel(String.valueOf(i), JLabel.CENTER);
			lbl.setFont(fnt);
			date.set(year,month,i);
			int w = date.get(Calendar.DAY_OF_WEEK); //����ϰ� �ִ� ��¥�� ����
			 if(w==1) lbl.setForeground(Color.RED);
			 if(w==7) lbl.setForeground(Color.BLUE);
			 
			
			dayPane.add(lbl);
			
		}
		
	
	}
	
	

}
