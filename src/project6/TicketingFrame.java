package project6;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.omg.CORBA.Bounds;

public class TicketingFrame extends JFrame implements ItemListener, ActionListener{
	Choice movieName;              //영화목록  
	Choice selectTime; 			//시간
	Choice adultTicket;	//성인
	Choice childTicket;	//학생
	JPanel panel;
	JLabel label,name,time,adult,child;
	JButton next,home;
	int ticketNum,select;
	public TicketingFrame(){
		setSize(500,400);
		setTitle("영화 예매");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel(null);
		label = new JLabel("CGV");
		name = new JLabel("영화 제목 : ");
		time = new JLabel("영화 시간 : ");
		adult = new JLabel("어   른 : ");
		child = new JLabel("청소년 : ");
		
		ticketNum = (int) (Math.random()*99999);						// 예매 번호를 random으로 선택함
		next = new JButton("NEXT");
		home = new JButton("HOME");
		
		next.addActionListener(this);									// next 이벤트 리스너
		
		home.addActionListener(new ActionListener() { 					// home 버튼 이벤트 리스너 이전 frame의 home 이벤트 리스너와 같음
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TicketingFrame.this.dispose();
				new MainFrame().show();
			}
		});
		
		movieName=new Choice();                // 초이스 객체를 생성한다.
		selectTime=new Choice(); 
		
		selectTime.add("09:00~11:20(조조할인)");       // 영화에 따라 다른 시간표를 추가한다.
		selectTime.add("11:30~13:50");
		selectTime.add("14:00~16:20");
		selectTime.add("16:30~18:50");
		selectTime.add("19:00~17:20");
		selectTime.add("17:30~19:50");
		selectTime.add("22:00~24:20(심야할인)");
		
		adultTicket=new Choice();			// 여른표 구매수를 입력받기 위한 텍스트필드
		childTicket=new Choice();			// 청소년표 구매수를 입력받기 위한 텍스트필드
		
		movieName.add("엑스맨");                         // 영화목록 추가
		movieName.add("말레피센트");
		movieName.add("끝까지 간다");
		movieName.add("엣지 오브 투모로우");
	
		movieName.addItemListener(this);
	
		for(int i=0; i < 11; i++) {                 //인원수 최대 10명
			adultTicket.add(String.valueOf(i));
			childTicket.add(String.valueOf(i));
		}
		
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 80));
		label.setForeground(Color.red);
		
		label.setBounds(160,60,200,80);												// 절대좌표 지정
		name.setBounds(20,160,70,30);
		movieName.setBounds(90,163,150,30);
		time.setBounds(20,200,70,30);
		selectTime.setBounds(90,203,150,30);
		adult.setBounds(270, 160, 70, 30);
		adultTicket.setBounds(350,163,70,30);
		child.setBounds(270, 200, 70, 30);
		childTicket.setBounds(350,203,70,30);
		next.setBounds(80, 300, 140, 30);
		home.setBounds(280,300,140,30);
		
		panel.add(label);
		panel.add(name);
		panel.add(movieName);
		panel.add(time);
		panel.add(selectTime);
		panel.add(adult);
		panel.add(adultTicket);
		panel.add(child);
		panel.add(childTicket);
		panel.add(next);
		panel.add(home);
		setResizable(false);				 // 크기 조절 불가
		add(panel);
		
	}
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int index = movieName.getSelectedIndex();		//ch1의 선택번호를 index에 입력
		System.out.println(index);
		selectTime.removeAll();
		if(index == 0)							//index가 0일 경우
		{					
			selectTime.add("09:00~11:20(조조할인)");//영화에따라다른시간표를추가한다.
			selectTime.add("11:30~13:50");
			selectTime.add("14:00~16:20");
			selectTime.add("16:30~18:50");
			selectTime.add("19:00~17:20");
			selectTime.add("17:30~19:50");
			selectTime.add("22:00~24:20(심야할인)");
		}
		else if(index==1)
		{					
			selectTime.add("09:10~12:10(조조할인)");//영화에따라다른시간표를추가한다.
			selectTime.add("12:20~15:20");
			selectTime.add("15:30~18:30");
			selectTime.add("18:40~21:40");
			selectTime.add("--:--~--:--");
			selectTime.add("--:--~--:--");
			selectTime.add("21:50~24:50(심야할인)");
		}
		else if(index==2)
		{					
			selectTime.add("09:00~10:50(조조할인)");//영화에따라다른시간표를추가한다.
			selectTime.add("11:00~12:50");
			selectTime.add("13:00~14:50");
			selectTime.add("15:00~16:50");
			selectTime.add("17:00~18:50");
			selectTime.add("19:00~20:50");
			selectTime.add("--:--~--:--(심야영화없음)");
		}
		else if(index==3)
		{					
			selectTime.add("--:--~--:--(조조할인없음)");
			selectTime.add("11:00~13:50");//영화에따라다른시간표를추가한다.
			selectTime.add("14:00~16:50");
			selectTime.add("17:00~19:50");
			selectTime.add("20:00~22:50");
			selectTime.add("--:--~--:--");
			selectTime.add("23:00~25:50(심야할인)");
		}
		else if(index==4)
		{					
			selectTime.add("10:00~12:20(조조할인)");//영화에따라다른시간표를추가한다.
			selectTime.add("12:30~14:50");
			selectTime.add("15:00~17:20");
			selectTime.add("19:00~17:20");
			selectTime.add("17:30~19:50");
			selectTime.add("--:--~--:--");
			selectTime.add("22:00~24:20(심야할인)");
		}
		else if(index==5)
		{					
			selectTime.add("--:--~--:--(조조할인없음)");
			selectTime.add("11:00~13:50");//영화에따라다른시간표를추가한다.
			selectTime.add("14:00~16:50");
			selectTime.add("17:00~19:50");
			selectTime.add("20:00~22:50");
			selectTime.add("--:--~--:--");
			selectTime.add("--:--~--:--(심야영화없음)");
		}
		select = index;
	}
	public void actionPerformed(ActionEvent e){

		// 버튼에 적힌 문자열을 읽어온다.

			int l_nmovie_time = selectTime.getSelectedIndex();		//각 아이템에서 index 를 얻어옴
			String l_strmovie_time = selectTime.getSelectedItem();
			int l_nadult_ticket = adultTicket.getSelectedIndex();
			int l_nstudent_ticket = childTicket.getSelectedIndex();


			String all ="";
			int l_nadult_price = 9000;					//각표에 대한 가격 설정
			int l_nstudent_price = 8000;
			int l_totalPrice = 0;

			if((l_nadult_ticket == 0 && l_nstudent_ticket == 0) 
				|| l_strmovie_time.equals("--:--~--:-- (조조 할인 없음)") 
				|| l_strmovie_time.equals("--:--~--:-- (심야 영화 없음)")
				|| l_strmovie_time.equals("--:--~--:--")
				||l_strmovie_time.equals(null))
			{
				new MsgBox(new JFrame("") ,null,null ,"부족한 요소가 있습니다.",null, false,null);
			}
			else
			{
				if(l_nmovie_time == 0 && !l_strmovie_time.equals("--:--~--:-- (조조 할인 없음)"))
				{
					l_nadult_price -= 2000;
					l_nstudent_price -= 2000;
				}
				else if(l_nmovie_time == 6 && !l_strmovie_time.equals("--:--~--:-- (심야 영화 없음)"))
				{
					l_nadult_price -= 1000;
					l_nstudent_price -= 1000;
				}
				if(l_nadult_ticket != 0)
				{
					l_totalPrice += l_nadult_ticket*l_nadult_price; 
				}
				if(l_nstudent_ticket != 0)
				{
					l_totalPrice += l_nstudent_ticket*l_nstudent_price;
				}
				
				all += String.valueOf(l_totalPrice)+"   ";
				
				
				//MsgBox message = new MsgBox(new Frame("") , l_strmovie_time+"   " + all, true);
				TicketingFrame.this.setVisible(false); // 현재 티켓고르는 화면은 visivle false로 해줌 dispose 안한것은 seatframe에서 prev버튼 처리를 쉽게하기위함임 dispose해주면 사용자가 입력한 모든 정보가 날라가기 때문
				/*
				 * 지금 선택한 영화의 모든 정보를 seatFrame에 넘겨줌 seatFrame에선 모든 좌석을 선택하면 영화 예매가 완료됨
				 */
				SeatFrame seat = new SeatFrame(movieName.getItem(select),l_nadult_ticket+l_nstudent_ticket,l_totalPrice,ticketNum,l_strmovie_time,TicketingFrame.this);
				seat.show();							// 좌석 선택 화면 show해줌
			}

	  }
	
}
