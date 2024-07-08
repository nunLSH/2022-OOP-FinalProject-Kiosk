import javax.swing.*;
import java.awt.*;

public class PayTimer extends JLabel implements Runnable {
	int second;

	public PayTimer (int second) {
		setOpaque(true);
		setBounds(220, 5, 40, 30);
		setForeground(Color.BLUE);
		setBackground(Color.white);
		setText(second + "");
		setFont(new Font("맑은고딕", Font.BOLD, 20));
		setHorizontalAlignment(JLabel.CENTER);
		
		this.second = second;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);	// 1초
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (second > 0) {
				second -= 1;		// 1초씩 줄어듦
				setText(second + "");
			} else {
				break;

			}
		}
		new CompleteOrder(); // 스레드가 종료되면 CompleteOrder 창으로 전환
	}
}