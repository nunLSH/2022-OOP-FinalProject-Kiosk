import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CompleteOrder extends JFrame
{             
	JPanel   banner;
	JLabel   m1, m2, m3, m4;
	JButton  ok;
	public CompleteOrder() {
		super("�ֹ��Ϸ�");
		setLayout(null);

		banner = new JPanel();
		ImageIcon b = new ImageIcon("../Images/���2.png");
		JLabel l = new JLabel(b, JLabel.CENTER);
		banner.setBounds(0,0,500,150);
		banner.setBackground(new Color(21, 173, 247));
		banner.add(l);

		m1 = new JLabel("��� ��ȣ");
		m1.setFont(new Font("���� ���", Font.BOLD,23));
		m1.setForeground(Color.black);
		m1.setBounds(190, 200, 300, 40);
		m1.setBackground(Color.white);
		m2 = new JLabel("1��");
		m2.setFont(new Font("���� ���", Font.BOLD,23));
		m2.setForeground(Color.blue);
		m2.setBounds(220, 240, 300, 40);
		m2.setBackground(Color.white);
		m3 = new JLabel("������ �Ϸ�Ǿ����ϴ�");
		m3.setFont(new Font("���� ���", Font.BOLD,17));
		m3.setForeground(Color.black);
		m3.setBounds(155, 300, 300, 20);
		m3.setBackground(Color.white);
		m4 = new JLabel("�̿����ּż� �����մϴ�");
		m4.setFont(new Font("���� ���", Font.BOLD,17));
		m4.setForeground(Color.black);
		m4.setBounds(145, 335, 300, 20);
		m4.setBackground(Color.white);

		ok = new JButton("Ȯ��");
		ok.setFont(new Font("���� ���", Font.BOLD,15));
		ok.setForeground(Color.white);
		ok.setBackground(new Color(21, 173, 247));
		ok.setBounds(210, 380, 80, 40);
		
		add(banner);
		add(m1);
		add(m2);
		add(m3);
		add(m4);
		add(ok);

		// ok ��ư �̺�Ʈ
		ok.addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		
		// JFrame ����
		setSize(500, 690);
		getContentPane().setBackground(Color.white);
		setResizable(false); // ������ ���� �Ұ�
		setLocationRelativeTo(null); // �������� ȭ�� �߾ӿ� ��ġ
		setVisible(true);
	}
}