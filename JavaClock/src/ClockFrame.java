import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockFrame  extends JFrame{
	
	Calendar calendar;
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	String time;
	String day;
	String date;
	
	ClockFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Java Clock");
		this.setSize(350,200);
		this.setResizable(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.black);
		
		timeFormat = new SimpleDateFormat("HH:mm:ss");
		dateFormat = new SimpleDateFormat("dd MMMM y");
		dayFormat = new SimpleDateFormat("EEEE");
		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		timeLabel.setForeground(Color.white);
		timeLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		dateLabel.setForeground(Color.white);
		dateLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		dayLabel.setForeground(Color.white);
		dayLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		
		panel.add(timeLabel);
		panel.add(dateLabel);
		panel.add(dayLabel);
		
		this.add(panel);
		this.setVisible(true);
		
		timeUpdate();
	}
	
	public void timeUpdate() {
		while(true) {
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
