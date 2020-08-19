import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SwingCalendar extends JFrame implements ActionListener, ItemListener {
	
	Font fnt1 = new Font("����ü", Font.BOLD, 12);
	Font fnt2 = new Font("�ü�ü", Font.BOLD, 12);	

	// �޷�
	Calendar cal = Calendar.getInstance();

	ImageIcon lastBtn1 = new ImageIcon("img/last1.png"); // �⺻
	ImageIcon lastBtn2 = new ImageIcon("img/last2.png"); // ��ư�� ���� ������ ��
	ImageIcon lastBtn3 = new ImageIcon("img/last3.png"); // ���콺 ������
	ImageIcon nextBtn1 = new ImageIcon("img/next1.png");
	ImageIcon nextBtn2 = new ImageIcon("img/next2.png");
	ImageIcon nextBtn3 = new ImageIcon("img/next3.png");

	// �⵵
	DefaultComboBoxModel year = new DefaultComboBoxModel();
	JComboBox yearbox = new JComboBox(year);
	// ��
	DefaultComboBoxModel month = new DefaultComboBoxModel();
	JComboBox monthbox = new JComboBox(month);

	JPanel northFrm = new JPanel();
	JButton lastMonth = new JButton(lastBtn1);
	JButton nextMonth = new JButton(nextBtn1);

	// GirdLayout: �Է��ϴ� ������� ���, ������ ��ġ
	// grd.setVgap(5); grid���̸� ���� �������� 5�ȼ��� ����
	JPanel calFrm = new JPanel(new BorderLayout());
	JPanel calWeek = new JPanel(new GridLayout(1, 7)); // ����
	JPanel calDay = new JPanel(new GridLayout(0, 7)); // 1, 2, 3,...,31

	String day[] = { "��", "��", "ȭ", "��", "��", "��", "��" };
	JLabel dayLbl;

	public SwingCalendar() {
		super("�޷�");
		add("North", northFrm);
		// ��ư �ܰ��� ���ֱ�
		lastMonth.setBorderPainted(false);
		nextMonth.setBorderPainted(false);
		// ���뿵�� ä��� ���ֱ�
		lastMonth.setContentAreaFilled(false);
		nextMonth.setContentAreaFilled(false);
		// ���� �Ǿ����� ����� �׵θ� ���ֱ�
		lastMonth.setFocusPainted(false);
		nextMonth.setFocusPainted(false);

		// ��ư ������ ��
		lastMonth.setPressedIcon(lastBtn2);
		nextMonth.setPressedIcon(nextBtn2);
		// ���콺 ������
		lastMonth.setRolloverIcon(lastBtn3);
		nextMonth.setRolloverIcon(nextBtn3);

		// �⵵
		for (int i = 1940; i <= 3000; i++) {
			year.addElement(i);
		}
		// ��
		for (int i = 1; i <= 12; i++) {
			month.addElement(i);
		}
		year.setSelectedItem("2020");
		month.setSelectedItem("8");

		// ��ư, �޺��ڽ��� �гο� �߰�
		northFrm.add(lastMonth);
		northFrm.add(yearbox);
		northFrm.add(monthbox);
		northFrm.add(nextMonth);


		add("Center", calFrm);
		calFrm.add("North", calWeek);
		calFrm.add("Center", calDay);

		calWeek.setBackground(Color.LIGHT_GRAY);
		calDay.setBackground(Color.pink);

		// ���� ���
		weekPrn(calWeek);

		// ù ȭ��
		// cal.set(Calendar.YEAR, Calendar.MONTH, 1);// ��, ��, 1
		cal.set(2020, 7, 1);
		int week = cal.get(Calendar.DAY_OF_WEEK);// ���� 1->��, ���� - 1=�����
		// ������ �� ���ϱ�
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// ����
		for (int i = 1; i < week; i++) {
			calDay.add(new JLabel(""));
		}
		// ��¥
		dayPrn(calDay, lastDay, week);

		// �̺�Ʈ
		// lastMonth.addActionListener(this);
		// nextMonth.addActionListener(this);
		yearbox.addItemListener(this);
		monthbox.addItemListener(this);

		lastMonth.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton event = (JButton) e.getSource();
				if (event.equals(lastMonth)) {
					int l = Integer.parseInt(month.getSelectedItem().toString());
					if (l == 1) {
						year.setSelectedItem(Integer.parseInt(year.getSelectedItem().toString()) - 1);
						monthbox.setSelectedItem(12);
					} else {
						for (int i = l - 1; i > l - 2; i--) {
							monthbox.setSelectedItem(i);
						}
					}
				} // if
			}
		});

		nextMonth.addActionListener(new ActionListener() {
			int selectYear = 2020;
			int selectMonth = 7;// 0->1��;

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton event = (JButton) e.getSource();
				if (event.equals(nextMonth)) {
					int m = Integer.parseInt(monthbox.getSelectedItem().toString());
					if (m == 12) {
						year.setSelectedItem(Integer.parseInt(year.getSelectedItem().toString()) + 1);
						monthbox.setSelectedItem(1);
					} else {
						for (int i = m + 1; i < m + 2; i++) {
							monthbox.setSelectedItem(i);

						}
					}
				}

			}

		});

		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	// �������̵�
	public void actionPerformed(ActionEvent e) {
	}

	// �������̵�
	public void itemStateChanged(ItemEvent e) {
		int selectYear = 2020;
		int selectMonth = 7;// 0->1��;
		// �޺��ڽ�
		JComboBox event = (JComboBox) e.getSource();
		if (event == yearbox) {
			selectYear = Integer.parseInt(yearbox.getSelectedItem().toString());
			calendar(selectYear, Integer.parseInt(monthbox.getSelectedItem().toString()));

		} else if (event == monthbox) {
			selectMonth = Integer.parseInt(monthbox.getSelectedItem().toString());
			calendar(Integer.parseInt(yearbox.getSelectedItem().toString()), selectMonth);
		}

	}

	// ���� ���
	public void weekPrn(JPanel calWeek) {

		for (int i = 0; i < day.length; i++) {
			JLabel label = new JLabel(day[i], SwingConstants.CENTER);
			label.setFont(fnt1);
			if (i == 0) {
				label.setForeground(Color.red);
				calWeek.add(label);
			} else if (i == 6) {
				label.setForeground(Color.blue);
				calWeek.add(label);
			} else {
				calWeek.add(label);
			}
		}
	}
	
	// ��¥ ���
	 public void dayPrn(JPanel newCalDay, int lastDay, int week) {
		 for (int d = 1; d <= lastDay; d++) {
				JLabel jDay = new JLabel(String.valueOf(d));
				jDay.setFont(fnt2);
				switch(week) {
				case 1:
					if(d==1 || d%7==1) {
						jDay.setForeground(Color.red);
						newCalDay.add(jDay);
					}else if(d==7 || d%7==0){
						jDay.setForeground(Color.blue);
						newCalDay.add(jDay);
					}else {					
						newCalDay.add(jDay);
					}
					break;
				case 2:
					if(d==7 || d%7==0) {
						jDay.setForeground(Color.red);
						newCalDay.add(jDay);
					}else if(d==6 || d%7==6){
						jDay.setForeground(Color.blue);
						newCalDay.add(jDay);
					}else {					
						newCalDay.add(jDay);
					}
					break;
				case 3:
					if(d==6 || d%7==6) {
						jDay.setForeground(Color.red);
						newCalDay.add(jDay);
					}else if(d==5 || d%7==5){
						jDay.setForeground(Color.blue);
						newCalDay.add(jDay);
					}else {					
						newCalDay.add(jDay);
					}
					break;
				case 4:
					if(d==5 || d%7==5) {
						jDay.setForeground(Color.red);
						newCalDay.add(jDay);
					}else if(d==4 || d%7==4){
						jDay.setForeground(Color.blue);
						newCalDay.add(jDay);
					}else {					
						newCalDay.add(jDay);
					}
					break;
				case 5:
					if(d==4 || d%7==4) {
						jDay.setForeground(Color.red);
						newCalDay.add(jDay);
					}else if(d==3 || d%7==3){
						jDay.setForeground(Color.blue);
						newCalDay.add(jDay);
					}else {					
						newCalDay.add(jDay);
					}
					break;
				case 6:
					if(d==3 || d%7==3) {
						jDay.setForeground(Color.red);
						newCalDay.add(jDay);
					}else if(d==2 || d%7==2){
						jDay.setForeground(Color.blue);
						newCalDay.add(jDay);
					}else {					
						newCalDay.add(jDay);
					}
					break;
				case 7:
					if(d==2 || d%7==2) {
						jDay.setForeground(Color.red);
						newCalDay.add(jDay);
					}else if(d==1 || d%7==1){
						jDay.setForeground(Color.blue);
						newCalDay.add(jDay);
					}else {					
						newCalDay.add(jDay);
					}
					break;
				default:
					newCalDay.add(jDay);
				}//end of switch
				
			}
	 }
	
	

	// �޷�
	public void calendar(int year, int month) {// �⵵, ��

		calFrm.removeAll();
		JPanel newCalWeek = new JPanel(new GridLayout(1, 7));
		//���� ���
		weekPrn(newCalWeek);
		JPanel newCalDay = new JPanel(new GridLayout(0, 7));
		newCalWeek.setBackground(Color.LIGHT_GRAY);
		newCalDay.setBackground(Color.pink);
		calFrm.add("North", newCalWeek);
		calFrm.add("Center", newCalDay);

		// ���� - �Է¹��� ��, ��, 1���� ���� �������� ���Ѵ�.
		cal.set(year, month - 1, 1);// ��, ��, 1
		int week = cal.get(Calendar.DAY_OF_WEEK);// ���� 1->��, ���� - 1=�����

		// ������ �� ���ϱ�
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		// ����
		for (int i = 1; i < week; i++) {
			newCalDay.add(new JLabel(""));
		}
		// ��¥ ���
		dayPrn(newCalDay, lastDay, week);

		validate();
		newCalDay.setVisible(true);

	}// end of calendar

	public static void main(String[] args) {
		new SwingCalendar();

	}

}
