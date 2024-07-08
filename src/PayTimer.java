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
		setFont(new Font("�������", Font.BOLD, 20));
		setHorizontalAlignment(JLabel.CENTER);
		
		this.second = second;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);	// 1��
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (second > 0) {
				second -= 1;		// 1�ʾ� �پ��
				setText(second + "");
			} else {
				break;

			}
		}
		new CompleteOrder(); // �����尡 ����Ǹ� CompleteOrder â���� ��ȯ
	}
}