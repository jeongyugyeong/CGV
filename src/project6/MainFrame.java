package project6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	public MainFrame(){
		setSize(500,400);
		setTitle("CGV");
		JPanel panel = new JPanel(null);
		JLabel label = new JLabel("CGV");
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 80));
		label.setForeground(Color.red);											// cgv 글자를 red로 바꿔줌
		JButton button1 = new JButton("영화 예매");
		JButton button2 = new JButton("예매 확인");
		
		label.setBounds(160,60,200,80);											// widget들 절대좌표 지정해줌
		button1.setBounds(180, 180, 140, 30);
		button2.setBounds(180, 240, 140, 30);
		panel.add(label);
		panel.add(button1);
		panel.add(button2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);				 // 크기 조절 불가
		add(panel);
		
		button1.addActionListener(new ActionListener() { 						// 영화 예매 버튼 이벤트리스너
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new TicketingFrame().show(); 									// ticketframe을 보여줌
				MainFrame.this.dispose();										// mainframe은 dispose함
			}
		});
		button2.addActionListener(new ActionListener() { 						// 예매 확인 버튼 이벤트 리스너
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CheckTicketFrame().show(); 									// checkTicketFrame 을 보여줌
				MainFrame.this.dispose(); 										// mainframe은 dispose해줌
			}
		});
		
	}

	public static void main(String args[]) {
		new MainFrame().show();
		//new movie().show();
	}
}
