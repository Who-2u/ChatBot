package chat;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Chatf extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JTextArea area=new JTextArea();
	static JTextField field=new JTextField();
	JScrollPane sp;
	JButton send;
	JButton train;
	JButton read;
	LocalTime time=LocalTime.now();
	LocalDate date=LocalDate.now();
	Random random=new Random();
	String message;
	static String s;

	public Chatf(String title)
	{
		super(title);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(new Color(221, 235, 230));
		field=new JTextField();
		send=new JButton("Send");
		send.setFont(new Font("Serif",Font.BOLD,15));
		send.setBackground(new Color(21,176,215));
		send.setBounds(530,283,95,25);
		add(send);
		//For Text area
		area.setEditable(false);
		area.setBackground(new Color(255,255, 255));
		add(area);
		area.setFont(new Font("Serif",Font.PLAIN,15));
		sp=new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setBounds(10,10,600,250);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(sp);
			
		//For TextField
		field.setSize(510,45);
		field.setLocation(10,285);
		field.setBackground(new Color(255, 255, 255));
		field.setForeground(Color.black);
		field.setFont(new Font("Serif",Font.BOLD,15));
		add(field);
		train=new JButton("Train Me");
		train.setFont(new Font("Serif",Font.BOLD,13));
		train.setBackground(new Color(21,176,215));
		train.setBounds(530,308,95,25);
		add(train);
		read=new JButton("Read");
		read.setFont(new Font("Serif",Font.BOLD,13));
		read.setBackground(new Color(21,176,215));
		read.setBounds(10,260,95,25);
		add(read);
		MyBot chatbot = new MyBot();
		ActionListener buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				message=field.getText().toLowerCase();
			   
				area.append("You : "+field.getText()+"\n");
				field.setText("");

				if(message.contains("clear")&&(message.contains("screen")||message.contains("chat")))
				{
					bot("wait a few second...");
					area.setText("");
				}
				else {
				
				chatbot.answer1(message);
				}
			}
		};
		
		ActionListener buttonListener2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String userInput = field.getText().toLowerCase();
				field.setText("");
				try {
					chatbot.trainMe(message,userInput);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		ActionListener buttonListener3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TestChatbot.TestChatbots(s);
				
			}
		};
		send.addActionListener(buttonListener);
		train.addActionListener(buttonListener2);
		read.addActionListener(buttonListener3);
		getRootPane().setDefaultButton(send);
	}

		
	public static void bot(String message)
	{
		area.append("Bot : "+message+"\n");
		s = message;
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Chatf cb=new Chatf("Chat Bot");
		cb.setSize(650,400);
		cb.setLocation(50,50);
		

		
	}
	

}