import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class MenuSelect extends JFrame
{                 
	JPanel        jp1, jp4, jp5;
	JLabel        totalprice;
	JTabbedPane   MenuOrder;

   // ����� �޴� �̸� 
   String gel_name[] = { "�ٴҶ�", "����", "����", "����", "�����", "��纣��" };
   // ����� ����
   int priceg[] = { 3000, 3000, 3000, 3000, 3000, 3000 };
   JLabel lg[] = new JLabel[6];

   // ���� �޴� �̸� 
   String bev_name[] = { "�Ƹ޸�ī��(ICE)", "�Ƹ޸�ī��(HOT)", "ī���(ICE)", "ī���(HOT)"};
   // ���� ����
   int priceb[] = { 2500, 2500, 3000, 3000};
   JLabel lb[] = new JLabel[4];

	public MenuSelect() {
		setTitle("Select Menu");
		setLayout(new BorderLayout());
		getContentPane().setBackground(new Color(21, 173, 247));

		// ��� �г�
		jp1 = new JPanel();
		ImageIcon banner = new ImageIcon("../Images/���1.png");
		JLabel l1 = new JLabel(banner, JLabel.CENTER);
		jp1.add(l1);
		jp1.setBackground(new Color(21, 173, 247));

		// �޴� ���� �г� ���� - JTabbedPane 
		JTabbedPane MenuOrder = new JTabbedPane();
		//Tab�� ���� ���� Panel ����: Tab�� �����ϴ� Panel ����
		GelatoFlavor gf = new GelatoFlavor(); // ����� �г�
		Beverage b = new Beverage(); // ���� �г�
		MenuOrder.addTab("Gelato", gf);
		MenuOrder.addTab("Beverage", b);
		MenuOrder.setFont(new Font("���� ���", Font.BOLD, 13)); // �� �۲�
		MenuOrder.setForeground(Color.white); // �� �۲� ����
		MenuOrder.setBackground(new Color(0,0,204)); // �� ����
	    
		// ��ٱ��� �г�
		Cart jp3 = new Cart();

		// ��ٱ��� ��ư �г�
		jp4 = new JPanel();
		
		totalprice = new JLabel("�� �ݾ�: "+String.valueOf(total)+"��");
		jp4.add(totalprice);

		// �ֹ��Ϸ� ��ư
		JButton ok = new JButton("�ֹ��Ϸ�");
		ok.setFont(new Font("���� ���", Font.BOLD,13));
		ok.setForeground(Color.white);
		ok.setBackground(new Color(0,0,220));
		ok.addActionListener(new OkListener());
		jp4.add(ok);
		// �ֹ���� ��ư
		JButton cancel = new JButton("�ֹ����");
		cancel.setFont(new Font("���� ���", Font.BOLD,13));
		cancel.setForeground(Color.white);
		cancel.setBackground(new Color(204,0,102));
		cancel.addActionListener(new CancelListener()); 
		jp4.add(cancel);
        
		jp5 = new JPanel(new BorderLayout());
		jp5.add(jp3, BorderLayout.CENTER);
		jp5.add(jp4, BorderLayout.SOUTH);


		// JFrame�� �г� ���̱�
		getContentPane().add(jp1, BorderLayout.NORTH);
        getContentPane().add(MenuOrder, BorderLayout.CENTER);
		getContentPane().add(jp5, BorderLayout.SOUTH);
		
		// JFrame ����
		setSize(500, 690);
		setResizable(false); // ������ ���� �Ұ�
		setLocationRelativeTo(null); // �������� ȭ�� �߾ӿ� ��ġ
		setVisible(true);
	}

	// GelatoFlavor �г�
	class GelatoFlavor extends JPanel {

		public GelatoFlavor() {
			setLayout(null); // ��ġ ������ ����
		   /* ��ġ �����ڸ� �����ؾ� ��ư�� ������ ��ġ�� �������� */

		   // ����� �޴� ��ư ���� - �̹��� ��ü�� ��ư���� ����
		   JButton[] gel = new JButton[6];
		   gel[0]= new JButton(new ImageIcon("../Images/gel_vanila.png")); // �ٴҶ�
		   gel[1] = new JButton(new ImageIcon("../Images/gel_choco.png")); // ����
		   gel[2] = new JButton(new ImageIcon("../Images/gel_greentea.png")); // ����
		   gel[3] = new JButton(new ImageIcon("../Images/gel_lemon.png")); // ����
		   gel[4] = new JButton(new ImageIcon("../Images/gel_strawberry.png")); // ����
		   gel[5] = new JButton(new ImageIcon("../Images/gel_blueberry.png")); // ��纣��

           // ����� ��ư, ���� ��ġ ����
		   for (int i = 0; i < 6; i++) {
			   gel[i].setBackground(Color.white);
			   lg[i] = new JLabel(priceg[i] + " ��");

			   if (i < 3) {
			  	   gel[i].setBounds(30 + 150*i, 20, 120, 120);
				   lg[i].setBounds(67 + 150*i, 165, 60, 20);
			   } else {
				   gel[i].setBounds(30 + 150*(i-3), 195, 120, 120);
				   lg[i].setBounds(67 + 150*(i-3), 345, 60, 20);
		       }
			   add(gel[i]);
			   add(lg[i]);
		   }

	        for (int i = 0; i < 6; i++) {
				int j = i;
			        gel[i].addActionListener(new ActionListener() {
 
                        @Override
                        public void actionPerformed(ActionEvent e) {
							// ���� ����
							String[] amount = {"1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15"};
							// ���ڿ��� ����ȯ -> ������ ����ȯ
							String amountg = (String)JOptionPane.showInputDialog(null,gel_name[j], "��ǰ ����",
								JOptionPane.PLAIN_MESSAGE, null, amount, amount[0]);
							int count = Integer.parseInt(amountg);   
							total= total+priceg[j] * count; // �� �ݾ�	  
 
                            String inputStr[] = new String [4];       
                            inputStr[0] = gel_name[j];        
                            inputStr[1] = priceg[j]+"��";        
					        inputStr[2] = ""+count;        
                            inputStr[3] = priceg[j] * count + "��";        
                            model.addRow(inputStr); // ��ٱ��� table�� �߰�
                            
			                // JLabel(totalprice)�� ����       
				            totalprice.setText("�� �ݾ�: "+String.valueOf(total)+"��");
                        }
                    }); 
			}
		}
        // �޴� �̸�
	    public void paintComponent(Graphics g) {
		    super.paintComponent(g);

		    Graphics2D g2 = (Graphics2D)g;

		    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
			    RenderingHints.VALUE_ANTIALIAS_ON);

		    g.setFont(new Font("���� ���", Font.BOLD, 13));
		    g.setColor(new Color(0,0,153));
		    g.drawString("Vanila", 68, 160);
		    g.drawString("Chocolate", 207, 160);
		    g.drawString("Green Tea", 355, 160);
		    g.drawString("Lemon", 66, 340);
		    g.drawString("Raspberry", 203, 340);
		    g.drawString("Blueberry", 357, 340);
	    }
	}

    // Beverage �г�
	class Beverage extends JPanel {

		public Beverage() {
			setLayout(null); // ��ġ ������ ����
		   /* ��ġ �����ڸ� �����ؾ� ��ư�� ������ ��ġ�� �������� */

		   // ���� �޴� ��ư ���� - �̹��� ��ü�� ��ư���� ����
		   JButton[] bev = new JButton[4];
		   bev[0]= new JButton(new ImageIcon("../Images/bev_�ƾ�.png")); // ���̽� �Ƹ޸�ī��
		   bev[1] = new JButton(new ImageIcon("../Images/bev_�߾�.png")); // �� �Ƹ޸�ī��
		   bev[2] = new JButton(new ImageIcon("../Images/bev_��ī.png")); // ���̽� ī���
		   bev[3] = new JButton(new ImageIcon("../Images/bev_��ī.png")); // �� ī����

           // ���� ��ư, ���� ��ġ ����
		   for (int i = 0; i < 4; i++) {
			   bev[i].setBackground(Color.white); 
			   lb[i] = new JLabel(priceb[i] + " ��");

			   if (i < 3) {
				   bev[i].setBounds(30 + 150*i, 20, 120, 120);
				   lb[i].setBounds(67 + 150*i, 165, 60, 20);
			   } else {
				   bev[i].setBounds(30 + 150*(i-3), 195, 120, 120);
				   lb[i].setBounds(67 + 150*(i-3), 345, 60, 20);
		       }
			   add(bev[i]);
			   add(lb[i]);
		   }

	        for (int i = 0; i < 4; i++) {
				int j =i;
			        bev[i].addActionListener(new ActionListener() {
 
                        @Override
                        public void actionPerformed(ActionEvent e) {
							// ���� ����
							String[] amount = {"1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15"};
							// ���ڿ��� ����ȯ -> ������ ����ȯ
							String amountb = (String)JOptionPane.showInputDialog(null,bev_name[j], "��ǰ ����",
								JOptionPane.PLAIN_MESSAGE, null, amount, amount[0]);
							int count = Integer.parseInt(amountb);
						    total= total+priceb[j] * count; // �� �ݾ�
 
                            String inputStr[] = new String [4];
                            inputStr[0] = bev_name[j];
                            inputStr[1] = priceb[j]+"��";
					        inputStr[2] = ""+count;
                            inputStr[3] = priceb[j] * count + "��";
                            model.addRow(inputStr); // ��ٱ��� table�� �߰�
                            
			                // JLabel(totalprice)�� ����
				            totalprice.setText("�� �ݾ�: "+String.valueOf(total)+"��");        
                        }
                    });
			}
	   }
	   // ���� �̸�
	   public void paintComponent(Graphics g) {
		   super.paintComponent(g);

		   Graphics2D g2 = (Graphics2D)g;

		   g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
			   RenderingHints.VALUE_ANTIALIAS_ON);

		   g.setFont(new Font("���� ���", Font.BOLD, 13));
		   g.setColor(new Color(0,0,153));
		   g.drawString("�Ƹ޸�ī��(ICE)", 42, 160);
		   g.drawString("�Ƹ޸�ī��(HOT)", 188, 160);
		   g.drawString("ī���(ICE)", 350, 160);
		   g.drawString("ī���(HOT)", 45, 340);
	   }
	}

	// Cart �г�
	DefaultTableModel  model;
	JTable             table;
	JScrollPane        scrollPane;
	int total=0; 

	class Cart extends JPanel {
	    
	    public Cart() {
		    setLayout(new FlowLayout());
		    // �ֹ�����
		    String[] [] data = new String[0][0];
		    // ���̺��� ù ��° �࿡ ���� �����͸� �������� ���� �̸�
            String[] title = {"��ǰ��","�ܰ�","����","�հ�"};
            model = new DefaultTableModel(data, title);
            table = new JTable(model);
            scrollPane = new JScrollPane(table); // JScrollPane�� table �ֱ�
            scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(480,120));
		    add(scrollPane);
		}
	}

	// �ֹ��Ϸ� ��ư�� ȭ����ȯ �̺�Ʈ 
    class OkListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// ǥ�ش�ȭ ���� - JOptionPane
			int answer = JOptionPane.showConfirmDialog(null,"�� �����ݾ� : "+total+
			"��\n"+"�ֹ��Ͻðڽ��ϱ�?","�ֹ� Ȯ��",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(answer == JOptionPane.YES_OPTION) {
				if (total == 0) {
					JOptionPane.showMessageDialog(null, "��ǰ�� �������� �����̽��ϴ�.\n �ֹ������� Ȯ�����ּ���"
						,"�˸�", JOptionPane.PLAIN_MESSAGE);
				} else {
						new Payment(); // Payment â���� ��ȯ
						dispose();// MenuSelect â �ݱ�
					}
			} else {
			}
		}
	};

	// �ֹ���� �̺�Ʈ
	class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.setNumRows(0); //�ֹ� ���� �ʱ�ȭ
			// JLabel(totalprice)�� ���� - 0������ �ʱ�ȭ
			total=0;
            totalprice.setText("�� �ݾ�: "+String.valueOf(total)+"��");
        }
    };
}

