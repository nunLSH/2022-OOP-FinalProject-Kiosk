import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame
{                 
	JPanel   jp;
	JButton  start;

	public Home() {
		super("Welcome to LSH's Gelato");

		jp = new JPanel();
		ImageIcon home = new ImageIcon("../Images/Ȩ(����) ȭ��.png");
		// ���� ȭ�� �̹��� ��ü�� ��ư���� ����
		start = new JButton(home);
		// ��ư�� ������ �̹����� ������ �����ϰ� ����
		start.setBackground(new Color(21, 173, 247));
		jp.add(start);
		// �г��� ���� �̹����� ������ �����ϰ� ����
		jp.setBackground(new Color(21, 173, 247));

		// ��ư�� ȭ����ȯ �̺�Ʈ 
		start.addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent e) {
				new MenuSelect(); // MenuChoice â���� ��ȯ
				dispose(); // Home â �ݱ� ( = setVisible(false); )
			}
		});
		
		// JFrame�� �г� ���̱� & JFrame ����
		getContentPane().add(jp);
		setSize(500, 690);
		setResizable(false); // ������ ���� �Ұ�
		setLocationRelativeTo(null); // �������� ȭ�� �߾ӿ� ��ġ
		setVisible(true);
		
	}
}

