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
		ImageIcon home = new ImageIcon("../Images/홈(메인) 화면.png");
		// 메인 화면 이미지 자체를 버튼으로 생성
		start = new JButton(home);
		// 버튼의 색상을 이미지의 배경색과 동일하게 설정
		start.setBackground(new Color(21, 173, 247));
		jp.add(start);
		// 패널의 색상도 이미지의 배경색과 동일하게 설정
		jp.setBackground(new Color(21, 173, 247));

		// 버튼에 화면전환 이벤트 
		start.addActionListener(new ActionListener() {
			@Override
				public void actionPerformed(ActionEvent e) {
				new MenuSelect(); // MenuChoice 창으로 전환
				dispose(); // Home 창 닫기 ( = setVisible(false); )
			}
		});
		
		// JFrame에 패널 붙이기 & JFrame 설정
		getContentPane().add(jp);
		setSize(500, 690);
		setResizable(false); // 사이즈 조절 불가
		setLocationRelativeTo(null); // 프레임을 화면 중앙에 배치
		setVisible(true);
		
	}
}

