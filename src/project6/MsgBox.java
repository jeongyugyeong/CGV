package project6;


import java.awt.*;
import java.awt.event.*;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MsgBox extends Dialog implements ActionListener 	//다이어로그로 상속받은 메시지 박스에 엑션리스너를 추가하는 클래스
{
	boolean id = false;				//id값을 거짓으로 설정
	Button ok,can;					//버튼
	JFrame parent;
	MsgBox(JFrame frame, String movieName,String ticketNum,String msg,String seats, boolean okcan,JFrame parent)
	{
		super(frame, "Message", true);		//Message의 프레임 설정
		this.parent = parent;
		
		Container panel = frame.getContentPane();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		if(movieName!=null) panel.add(new Label(movieName));
		if(ticketNum!=null) panel.add(new Label(ticketNum));
		if(seats!=null) panel.add(new Label(seats));
		panel.add(new Label(msg));
		add(panel);
		addOKCancelPanel(okcan);
		createFrame();						//프레임 생성
		pack();
		setVisible(true);
	}

	void addOKCancelPanel( boolean okcan ) 
	{
		Panel p = new Panel();				//패널 생성
		p.setLayout(new FlowLayout());
		createOKButton( p );				//버튼 생성
		if (okcan == true)
			createCancelButton( p );
		add("South",p);
	}

	void createOKButton(Panel p) 
	{
		p.add(ok = new Button("OK"));		//초기화후 리스너 설정
		ok.addActionListener(this); 
	}

	void createCancelButton(Panel p) 
	{
		p.add(can = new Button("Cancel"));
		can.addActionListener(this);
	}

	void createFrame() 
	{
		Dimension d = getToolkit().getScreenSize();		//프레임 생성후 설정
		setLocation(d.width/3,d.height/3);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == ok) 					//버튼 클릭에 따라 액션 설정
		{
			id = true;
			if(parent!=null) parent.dispose();
			new MainFrame().show();
			setVisible(false);
		}
		else if(ae.getSource() == can) 
		{
			setVisible(false);
		}
	}
}






