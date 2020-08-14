package project6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckTicketFrame extends JFrame{
	ArrayList<String> ticket; 											// text파일에서 예매된 정보를 가져와서 arraylist에 넣어줌
	JPanel panel;
	JLabel label,numLabel;
	JButton next,home;
	JTextField numText;
	public CheckTicketFrame(){
		setSize(500,400);
		setTitle("CGV");
		panel = new JPanel(null);
		label = new JLabel("CGV");
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 80));
		label.setForeground(Color.red);
		 next = new JButton("NEXT");
		home = new JButton("HOME");
		
		numLabel = new JLabel("예약 번호 : ");
		numText = new JTextField(10);
		ticket = new ArrayList<String>(); 								// arraylist 초기화
		
		try {
			FileReader fr = new FileReader("ticket.txt");				// ticket.txt 파일에서 예매 정보를 가져옴
			BufferedReader br = new BufferedReader(fr);
			String str;
			while((str = br.readLine()) != null) { 						// 한줄단위로읽어서 arraylist에 넣어줌
				ticket.add(str);
			}
			br.close();
			fr.close();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		home.addActionListener(new ActionListener() { 					// home 버튼 이벤트 리스너
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CheckTicketFrame.this.dispose(); 						// 현재 frame을 dispose 해줌
				new MainFrame().show(); 								// mainframe을 show 해줌
			}
		});
		next.addActionListener(new ActionListener() { 					// 예매 정보 확인 버튼 이벤트 리스너
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				for(int i=0;i<ticket.size();i++) {						// text에서 읽어온 예매된정보 에서 
					
					StringTokenizer st = new StringTokenizer(ticket.get(i).toString());
					String name = st.nextToken("\t ");
					String num = st.nextToken("\t ");
					if(num.equals(numText.getText().toString())) {
						String price = st.nextToken("\t ");
						String seats = st.nextToken("\t ");
						String time = st.nextToken("\t");
						String etc = "시    간 : "+time+"   가     격 : "+price;
						new MsgBox(new JFrame("") ,"영화 이름 : "+name,"예약 번호 : "+num, etc,"좌     석   : "+seats, false,null);
					}
				}
			}
		});
		next.setBounds(80, 300, 140, 30);
		home.setBounds(280,300,140,30);
		label.setBounds(160,60,200,80);
		numLabel.setBounds(120, 200, 140, 30);
		numText.setBounds(220, 200, 140, 30);
		
		panel.add(label);
		panel.add(numLabel);
		panel.add(numText);
		panel.add(next);
		panel.add(home);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);				 // 크기 조절 불가
		add(panel);
		
		
	}
}
