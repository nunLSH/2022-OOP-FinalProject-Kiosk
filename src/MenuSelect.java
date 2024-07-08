import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class MenuSelect extends JFrame
{                 
	JPanel        jp1, jp4, jp5;
	JLabel        totalprice;
	JTabbedPane   MenuOrder;

   // 젤라또 메뉴 이름 
   String gel_name[] = { "바닐라", "초코", "녹차", "레몬", "라즈베리", "블루베리" };
   // 젤라또 가격
   int priceg[] = { 3000, 3000, 3000, 3000, 3000, 3000 };
   JLabel lg[] = new JLabel[6];

   // 음료 메뉴 이름 
   String bev_name[] = { "아메리카노(ICE)", "아메리카노(HOT)", "카페라떼(ICE)", "카페라떼(HOT)"};
   // 음료 가격
   int priceb[] = { 2500, 2500, 3000, 3000};
   JLabel lb[] = new JLabel[4];

	public MenuSelect() {
		setTitle("Select Menu");
		setLayout(new BorderLayout());
		getContentPane().setBackground(new Color(21, 173, 247));

		// 배너 패널
		jp1 = new JPanel();
		ImageIcon banner = new ImageIcon("../Images/배너1.png");
		JLabel l1 = new JLabel(banner, JLabel.CENTER);
		jp1.add(l1);
		jp1.setBackground(new Color(21, 173, 247));

		// 메뉴 선택 패널 내용 - JTabbedPane 
		JTabbedPane MenuOrder = new JTabbedPane();
		//Tab의 수에 따른 Panel 생성: Tab가 연동하는 Panel 생성
		GelatoFlavor gf = new GelatoFlavor(); // 젤라또 패널
		Beverage b = new Beverage(); // 음료 패널
		MenuOrder.addTab("Gelato", gf);
		MenuOrder.addTab("Beverage", b);
		MenuOrder.setFont(new Font("맑은 고딕", Font.BOLD, 13)); // 탭 글꼴
		MenuOrder.setForeground(Color.white); // 탭 글꼴 색상
		MenuOrder.setBackground(new Color(0,0,204)); // 탭 색상
	    
		// 장바구니 패널
		Cart jp3 = new Cart();

		// 장바구니 버튼 패널
		jp4 = new JPanel();
		
		totalprice = new JLabel("총 금액: "+String.valueOf(total)+"원");
		jp4.add(totalprice);

		// 주문완료 버튼
		JButton ok = new JButton("주문완료");
		ok.setFont(new Font("맑은 고딕", Font.BOLD,13));
		ok.setForeground(Color.white);
		ok.setBackground(new Color(0,0,220));
		ok.addActionListener(new OkListener());
		jp4.add(ok);
		// 주문취소 버튼
		JButton cancel = new JButton("주문취소");
		cancel.setFont(new Font("맑은 고딕", Font.BOLD,13));
		cancel.setForeground(Color.white);
		cancel.setBackground(new Color(204,0,102));
		cancel.addActionListener(new CancelListener()); 
		jp4.add(cancel);
        
		jp5 = new JPanel(new BorderLayout());
		jp5.add(jp3, BorderLayout.CENTER);
		jp5.add(jp4, BorderLayout.SOUTH);


		// JFrame에 패널 붙이기
		getContentPane().add(jp1, BorderLayout.NORTH);
        getContentPane().add(MenuOrder, BorderLayout.CENTER);
		getContentPane().add(jp5, BorderLayout.SOUTH);
		
		// JFrame 설정
		setSize(500, 690);
		setResizable(false); // 사이즈 조절 불가
		setLocationRelativeTo(null); // 프레임을 화면 중앙에 배치
		setVisible(true);
	}

	// GelatoFlavor 패널
	class GelatoFlavor extends JPanel {

		public GelatoFlavor() {
			setLayout(null); // 배치 관리자 삭제
		   /* 배치 관리자를 삭제해야 버튼을 절대적 위치에 지정가능 */

		   // 젤라또 메뉴 버튼 생성 - 이미지 자체를 버튼으로 생성
		   JButton[] gel = new JButton[6];
		   gel[0]= new JButton(new ImageIcon("../Images/gel_vanila.png")); // 바닐라
		   gel[1] = new JButton(new ImageIcon("../Images/gel_choco.png")); // 초코
		   gel[2] = new JButton(new ImageIcon("../Images/gel_greentea.png")); // 녹차
		   gel[3] = new JButton(new ImageIcon("../Images/gel_lemon.png")); // 레몬
		   gel[4] = new JButton(new ImageIcon("../Images/gel_strawberry.png")); // 딸기
		   gel[5] = new JButton(new ImageIcon("../Images/gel_blueberry.png")); // 블루베리

           // 젤라또 버튼, 가격 위치 설정
		   for (int i = 0; i < 6; i++) {
			   gel[i].setBackground(Color.white);
			   lg[i] = new JLabel(priceg[i] + " 원");

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
							// 수량 설정
							String[] amount = {"1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15"};
							// 문자열로 형변환 -> 정수로 형변환
							String amountg = (String)JOptionPane.showInputDialog(null,gel_name[j], "상품 수량",
								JOptionPane.PLAIN_MESSAGE, null, amount, amount[0]);
							int count = Integer.parseInt(amountg);   
							total= total+priceg[j] * count; // 총 금액	  
 
                            String inputStr[] = new String [4];       
                            inputStr[0] = gel_name[j];        
                            inputStr[1] = priceg[j]+"원";        
					        inputStr[2] = ""+count;        
                            inputStr[3] = priceg[j] * count + "원";        
                            model.addRow(inputStr); // 장바구니 table에 추가
                            
			                // JLabel(totalprice)값 변경       
				            totalprice.setText("총 금액: "+String.valueOf(total)+"원");
                        }
                    }); 
			}
		}
        // 메뉴 이름
	    public void paintComponent(Graphics g) {
		    super.paintComponent(g);

		    Graphics2D g2 = (Graphics2D)g;

		    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
			    RenderingHints.VALUE_ANTIALIAS_ON);

		    g.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		    g.setColor(new Color(0,0,153));
		    g.drawString("Vanila", 68, 160);
		    g.drawString("Chocolate", 207, 160);
		    g.drawString("Green Tea", 355, 160);
		    g.drawString("Lemon", 66, 340);
		    g.drawString("Raspberry", 203, 340);
		    g.drawString("Blueberry", 357, 340);
	    }
	}

    // Beverage 패널
	class Beverage extends JPanel {

		public Beverage() {
			setLayout(null); // 배치 관리자 삭제
		   /* 배치 관리자를 삭제해야 버튼을 절대적 위치에 지정가능 */

		   // 음료 메뉴 버튼 생성 - 이미지 자체를 버튼으로 생성
		   JButton[] bev = new JButton[4];
		   bev[0]= new JButton(new ImageIcon("../Images/bev_아아.png")); // 아이스 아메리카노
		   bev[1] = new JButton(new ImageIcon("../Images/bev_뜨아.png")); // 핫 아메리카노
		   bev[2] = new JButton(new ImageIcon("../Images/bev_아카.png")); // 아이스 카페라떼
		   bev[3] = new JButton(new ImageIcon("../Images/bev_뜨카.png")); // 핫 카레라떼

           // 음료 버튼, 가격 위치 설정
		   for (int i = 0; i < 4; i++) {
			   bev[i].setBackground(Color.white); 
			   lb[i] = new JLabel(priceb[i] + " 원");

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
							// 수량 설정
							String[] amount = {"1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15"};
							// 문자열로 형변환 -> 정수로 형변환
							String amountb = (String)JOptionPane.showInputDialog(null,bev_name[j], "상품 수량",
								JOptionPane.PLAIN_MESSAGE, null, amount, amount[0]);
							int count = Integer.parseInt(amountb);
						    total= total+priceb[j] * count; // 총 금액
 
                            String inputStr[] = new String [4];
                            inputStr[0] = bev_name[j];
                            inputStr[1] = priceb[j]+"원";
					        inputStr[2] = ""+count;
                            inputStr[3] = priceb[j] * count + "원";
                            model.addRow(inputStr); // 장바구니 table에 추가
                            
			                // JLabel(totalprice)값 변경
				            totalprice.setText("총 금액: "+String.valueOf(total)+"원");        
                        }
                    });
			}
	   }
	   // 음료 이름
	   public void paintComponent(Graphics g) {
		   super.paintComponent(g);

		   Graphics2D g2 = (Graphics2D)g;

		   g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
			   RenderingHints.VALUE_ANTIALIAS_ON);

		   g.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		   g.setColor(new Color(0,0,153));
		   g.drawString("아메리카노(ICE)", 42, 160);
		   g.drawString("아메리카노(HOT)", 188, 160);
		   g.drawString("카페라떼(ICE)", 350, 160);
		   g.drawString("카페라떼(HOT)", 45, 340);
	   }
	}

	// Cart 패널
	DefaultTableModel  model;
	JTable             table;
	JScrollPane        scrollPane;
	int total=0; 

	class Cart extends JPanel {
	    
	    public Cart() {
		    setLayout(new FlowLayout());
		    // 주문내역
		    String[] [] data = new String[0][0];
		    // 테이블의 첫 번째 행에 들어가는 데이터를 구분짓는 열의 이름
            String[] title = {"상품명","단가","수량","합계"};
            model = new DefaultTableModel(data, title);
            table = new JTable(model);
            scrollPane = new JScrollPane(table); // JScrollPane에 table 넣기
            scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(480,120));
		    add(scrollPane);
		}
	}

	// 주문완료 버튼에 화면전환 이벤트 
    class OkListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 표준대화 상자 - JOptionPane
			int answer = JOptionPane.showConfirmDialog(null,"총 결제금액 : "+total+
			"원\n"+"주문하시겠습니까?","주문 확인",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(answer == JOptionPane.YES_OPTION) {
				if (total == 0) {
					JOptionPane.showMessageDialog(null, "상품을 선택하지 않으셨습니다.\n 주문내역을 확인해주세요"
						,"알림", JOptionPane.PLAIN_MESSAGE);
				} else {
						new Payment(); // Payment 창으로 전환
						dispose();// MenuSelect 창 닫기
					}
			} else {
			}
		}
	};

	// 주문취소 이벤트
	class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.setNumRows(0); //주문 내역 초기화
			// JLabel(totalprice)값 변경 - 0원으로 초기화
			total=0;
            totalprice.setText("총 금액: "+String.valueOf(total)+"원");
        }
    };
}

