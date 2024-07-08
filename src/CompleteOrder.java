import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CompleteOrder extends JFrame
{             
	JPanel   banner;
	JLabel   m1, m2, m3, m4;
	JButton  ok;
	public CompleteOrder() {
		super("주문완료");
		setLayout(null);

		banner = new JPanel();
		ImageIcon b = new ImageIcon("../Images/배너2.png");
		JLabel l = new JLabel(b, JLabel.CENTER);
		banner.setBounds(0,0,500,150);
		banner.setBackground(new Color(21, 173, 247));
		banner.add(l);

		m1 = new JLabel("대기 번호");
		m1.setFont(new Font("맑은 고딕", Font.BOLD,23));
		m1.setForeground(Color.black);
		m1.setBounds(190, 200, 300, 40);
		m1.setBackground(Color.white);
		m2 = new JLabel("1번");
		m2.setFont(new Font("맑은 고딕", Font.BOLD,23));
		m2.setForeground(Color.blue);
		m2.setBounds(220, 240, 300, 40);
		m2.setBackground(Color.white);
		m3 = new JLabel("결제가 완료되었습니다");
		m3.setFont(new Font("맑은 고딕", Font.BOLD,17));
		m3.setForeground(Color.black);
		m3.setBounds(155, 300, 300, 20);
		m3.setBackground(Color.white);
		m4 = new JLabel("이용해주셔서 감사합니다");
		m4.setFont(new Font("맑은 고딕", Font.BOLD,17));
		m4.setForeground(Color.black);
		m4.setBounds(145, 335, 300, 20);
		m4.setBackground(Color.white);

		ok = new JButton("확인");
		ok.setFont(new Font("맑은 고딕", Font.BOLD,15));
		ok.setForeground(Color.white);
		ok.setBackground(new Color(21, 173, 247));
		ok.setBounds(210, 380, 80, 40);
		
		add(banner);
		add(m1);
		add(m2);
		add(m3);
		add(m4);
		add(ok);

		// ok 버튼 이벤트
		ok.addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		
		// JFrame 설정
		setSize(500, 690);
		getContentPane().setBackground(Color.white);
		setResizable(false); // 사이즈 조절 불가
		setLocationRelativeTo(null); // 프레임을 화면 중앙에 배치
		setVisible(true);
	}
}