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
		super("결제창");
		setLayout(null);
		int second = 10; // 10초 
		
		cardIn = new JPanel();
		cardIn.setLayout(null);
		banner = new JPanel();
		ImageIcon b = new ImageIcon("../Images/배너2.png");
		JLabel l = new JLabel(b, JLabel.CENTER);
		banner.setBounds(0,0,500,150);
		banner.add(l);
		banner.setBackground(new Color(21, 173, 247));
		message1 = new JLabel("결제하실 카드를 투입구에 넣어주세요");
		message1.setFont(new Font("맑은 고딕", Font.BOLD,17));
		message1.setForeground(Color.black);
		message1.setBackground(Color.white);
		message1.setBounds(95, 200, 300, 20);
		message2 = new JLabel("결제가 완료될 때까지 카드를 빼지 마세요!");
		message2.setFont(new Font("맑은 고딕", Font.BOLD,17));
		message2.setForeground(new Color(213, 52, 52));
		message2.setBackground(Color.white);;
		message2.setBounds(75, 240, 500, 20);

		// 카드 결제 이미지
		image = new ImagePanel(new ImageIcon("../Images/카드결제.png").getImage());
		image.setBounds(0,260,500,300);
		image.setBackground(Color.white);

		pt = new PayTimer(second); // 스레드 객체 생성
		th = new Thread(pt); // pt를 매개변수로 하여 스레드 객체 th 생성
		th.start(); // 스레드 시작
		cardIn.add(pt);
		cardIn.setBounds(0, 280, 500, 30);
		cardIn.setBackground(Color.white);

		add(cardIn);
		add(banner);
		add(message1);
		add(message2);
		add(image);
		// JFrame 설정
		setSize(500, 690);
		getContentPane().setBackground(Color.white);
		setResizable(false); // 사이즈 조절 불가
		setLocationRelativeTo(null); // 프레임을 화면 중앙에 배치
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