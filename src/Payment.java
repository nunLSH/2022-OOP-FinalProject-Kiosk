import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame
{             
	JPanel      cardIn, banner;
	ImagePanel  image;
	JLabel      message1, message2;
	PayTimer    pt;
	Thread      th;

	public Payment() {
		super("����â");
		setLayout(null);
		int second = 10; // 10�� 
		
		cardIn = new JPanel();
		cardIn.setLayout(null);
		banner = new JPanel();
		ImageIcon b = new ImageIcon("../Images/���2.png");
		JLabel l = new JLabel(b, JLabel.CENTER);
		banner.setBounds(0,0,500,150);
		banner.add(l);
		banner.setBackground(new Color(21, 173, 247));
		message1 = new JLabel("�����Ͻ� ī�带 ���Ա��� �־��ּ���");
		message1.setFont(new Font("���� ���", Font.BOLD,17));
		message1.setForeground(Color.black);
		message1.setBackground(Color.white);
		message1.setBounds(95, 200, 300, 20);
		message2 = new JLabel("������ �Ϸ�� ������ ī�带 ���� ������!");
		message2.setFont(new Font("���� ���", Font.BOLD,17));
		message2.setForeground(new Color(213, 52, 52));
		message2.setBackground(Color.white);;
		message2.setBounds(75, 240, 500, 20);

		// ī�� ���� �̹���
		image = new ImagePanel(new ImageIcon("../Images/ī�����.png").getImage());
		image.setBounds(0,260,500,300);
		image.setBackground(Color.white);

		pt = new PayTimer(second); // ������ ��ü ����
		th = new Thread(pt); // pt�� �Ű������� �Ͽ� ������ ��ü th ����
		th.start(); // ������ ����
		cardIn.add(pt);
		cardIn.setBounds(0, 280, 500, 30);
		cardIn.setBackground(Color.white);

		add(cardIn);
		add(banner);
		add(message1);
		add(message2);
		add(image);
		// JFrame ����
		setSize(500, 690);
		getContentPane().setBackground(Color.white);
		setResizable(false); // ������ ���� �Ұ�
		setLocationRelativeTo(null); // �������� ȭ�� �߾ӿ� ��ġ
		setVisible(true);
	}
	class ImagePanel extends JPanel {
		Image img;

	    public ImagePanel(Image img) {
			this.img = img;
		}

		public void paintComponent(Graphics g) {
			g.drawImage(img, 120, 50, null);
		}
	}
}