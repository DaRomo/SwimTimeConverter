import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *	@author	Matthew Romanelli <500distanceswimmer@gmail.com>
 *	@version 1.0
 *	since	2012-09-14
 */
public class SwimTimeConverter extends JFrame
{
	/** variable for the panel	*/
	private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7;
	/** variables for text boxes */
	private JLabel messageLabel1, messageLabel2, messageLabel3, messageLabel4, messageLabel5, colon, period;
	/** variable for the calculate button */
	private JButton calculate;
	/** variables for the Combo Boxes */
	private JComboBox event, stroke, course;
	/** variables for the textfield */
	private JTextField minute, second, milli;
	/** variable for the window height */
	private int WINDOW_HEIGHT = 275;
	/** variable for the window width */
	private int WINDOW_WIDTH = 350;
	/** variable for values in the event combo box */
	private String[] events;
	/** variable for the values in the course combo box */
	private String[] courses;
	/** variable for the values in the stroke combo box */
	private String[] strokes;
	
	/** Constructor and creats the panel */
	public SwimTimeConverter()
	{
		super ("Swim Time Converter");
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(7, 1));
		
		messageLabel1 = new JLabel("Swim Time Converter");
		messageLabel2 = new JLabel("Enter Your Time: ");
		messageLabel3 = new JLabel("Select Your Event: ");
		messageLabel5 = new JLabel("Select Your Course: ");
		messageLabel4 = new JLabel("Select Your Stroke: ");
		colon = new JLabel(":");
		period = new JLabel(".");

		calculate = new JButton("Calculate");
		
		events = new String[] {"50", "100", "200", "400/500", "800/1000", "1500/1650"};
		strokes = new String[] {"Freestyle", "Backstroke", "Breaststroke", "Butterfly", "IM"};
		courses = new String[] {"Long Course Meters", "Short Course Meters", "Short Courtse Yards"};
		
		event = new JComboBox(events);
		stroke = new JComboBox(strokes);
		course = new JComboBox(courses);
		
		minute = new JTextField(2);
		second = new JTextField(2);
		milli = new JTextField(2);
		
				
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();

		//panel1.add(messageLabel1);
		panel2.add(messageLabel2);
		panel3.add(minute);
		panel3.add(colon);
		panel3.add(second);
		panel3.add(period);
		panel3.add(milli);
		panel4.add(messageLabel3);
		panel4.add(event);
		panel5.add(messageLabel4);
		panel5.add(stroke);
		panel6.add(messageLabel5);
		panel6.add(course);
		panel7.add(calculate);
						
		//add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);
		add(panel7);
			
		setVisible(true);
				
		calculate.addActionListener(new CalculateButtonListener());		
	}
	
	public class CalculateButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String min, sec, mil;
			String LCM, SCM, SCY;
			double val1 = 0, val2 = 0, val3 = 0, val4, val5, val6;
								
			min = minute.getText();
			sec = second.getText();
			mil = milli.getText();
			
			try
			{
				val1 = Double.parseDouble(min);
				val2 = Double.parseDouble(sec);
				val3 = Double.parseDouble(mil);
			}
			
			catch (NumberFormatException nfe)
			{
				JOptionPane.showMessageDialog(null, "That's not a time!");
			}
			
			if (course.getSelectedIndex() == 0)
			{
				if (event.getSelectedIndex() == 0)
				{
					// 50 FR LCM 
					if (stroke.getSelectedIndex() == 0)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 0.8);
						val6 = (turnToSeconds(val1, val2, val3) - 0.8) / 1.11;
						messageBox(val4, val5, val6);
					}
					//50 BK LCM
					if (stroke.getSelectedIndex() == 1)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 0.6);
						val6 = (turnToSeconds(val1, val2, val3) - 0.6) / 1.11;
						messageBox(val4, val5, val6);
					}
					//50 BR LCM
					if (stroke.getSelectedIndex() == 2)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 1.0);
						val6 = (turnToSeconds(val1, val2, val3) - 1.0) / 1.11;
						messageBox(val4, val5, val6);
					}
					//50 FL LCM
					if (stroke.getSelectedIndex() == 3)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 0.7);
						val6 = (turnToSeconds(val1, val2, val3) - 0.7) / 1.11;
						messageBox(val4, val5, val6);
					}
				}
				if (event.getSelectedIndex() == 1)
				{
					//100 FR LCM
					if (stroke.getSelectedIndex() == 0)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 1.6);
						val6 = (turnToSeconds(val1, val2, val3) - 1.6) / 1.11;
						messageBox(val4, val5, val6);
					}
					//100 BK LCM
					if (stroke.getSelectedIndex() == 1)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 1.2);
						val6 = (turnToSeconds(val1, val2, val3) - 1.2) / 1.11;
						messageBox(val4, val5, val6);
					}
					//100 BR LCM
					if (stroke.getSelectedIndex() == 2)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 2.0);
						val6 = (turnToSeconds(val1, val2, val3) - 2.0) / 1.11;
						messageBox(val4, val5, val6);
					}
					//100 FL LCM
					if (stroke.getSelectedIndex() == 3)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 1.4);
						val6 = (turnToSeconds(val1, val2, val3) - 1.4) / 1.11;
						messageBox(val4, val5, val6);
					}
				}
				if (event.getSelectedIndex() == 2)
				{
					//200 FR LCM
					if (stroke.getSelectedIndex() == 0)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 3.2);
						val6 = (turnToSeconds(val1, val2, val3) - 3.2) / 1.11;
						messageBox(val4, val5, val6);
					}
					//200 BK LCM
					if (stroke.getSelectedIndex() == 1)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 2.4);
						val6 = (turnToSeconds(val1, val2, val3) - 2.4) / 1.11;
						messageBox(val4, val5, val6);
					}
					//200 BR LCM
					if (stroke.getSelectedIndex() == 2)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 4.0);
						val6 = (turnToSeconds(val1, val2, val3) - 4.0) / 1.11;
						messageBox(val4, val5, val6);
					}
					//200 FL LCM
					if (stroke.getSelectedIndex() == 3)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 2.8);
						val6 = (turnToSeconds(val1, val2, val3) - 2.8) / 1.11;
						messageBox(val4, val5, val6);
					}
					//200 IM LCM
					if (stroke.getSelectedIndex() == 4)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 3.2);
						val6 = (turnToSeconds(val1, val2, val3) - 3.2) / 1.11;
						messageBox(val4, val5, val6);
					}
				}
				if (event.getSelectedIndex() == 3)
				{
					//400 FR LCM
					if (stroke.getSelectedIndex() == 0)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 6.4);
						val6 = (turnToSeconds(val1, val2, val3)) / 0.8925;
						messageBox(val4, val5, val6);
					}
					//400 IM LCM
					if (stroke.getSelectedIndex() == 4)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 6.4);
						val6 = (turnToSeconds(val1, val2, val3) - 6.4) / 1.11;
						messageBox(val4, val5, val6);
					}
				}
				if (event.getSelectedIndex() == 4)
				{
					//800 FR LCM
					if (stroke.getSelectedIndex() == 0)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 12.8);
						val6 = (turnToSeconds(val1, val2, val3)) / 0.8925;
						messageBox(val4, val5, val6);
					}
				}
				if (event.getSelectedIndex() == 5)
				{
					//1500 FR LCM
					if (stroke.getSelectedIndex() == 0)
					{
						val4 = (turnToSeconds(val1, val2, val3));
						val5 = (turnToSeconds(val1, val2, val3) - 24.0);
						val6 = (turnToSeconds(val1, val2, val3)) / 1.02;
						messageBox(val4, val5, val6);
					}
				}
			}
			if (course.getSelectedIndex() == 1)
			{
				if (event.getSelectedIndex() == 0)
				{
					//50 FR SCM
					if (stroke.getSelectedIndex() == 0)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 0.8);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) / 1.11;
						messageBox(val4, val5, val6);
					}
					//50 BK SCM
					if (stroke.getSelectedIndex() == 1)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 0.6);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) / 1.11;
						messageBox(val4, val5, val6);
					}
					//50 BR sCM
					if (stroke.getSelectedIndex() == 2)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 1.0);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) / 1.11;
						messageBox(val4, val5, val6);
					}
					//50 FL SCM
					if (stroke.getSelectedIndex() == 3)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 0.7);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) / 1.11;
						messageBox(val4, val5, val6);
					}
				}
				if (event.getSelectedIndex() == 1)
				{
					//100 FR SCM
					if (stroke.getSelectedIndex() == 0)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 1.6);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) / 1.11;
						messageBox(val4, val5, val6);
					}
					//100 BK SCM
					if (stroke.getSelectedIndex() == 1)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 1.2);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) / 1.11;
						messageBox(val4, val5, val6);
					}
					//100 BR SCM
					if (stroke.getSelectedIndex() == 2)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 2.0);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) / 1.11;
						messageBox(val4, val5, val6);
					}
					//100 FL SCM
					if (stroke.getSelectedIndex() == 3)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 1.4);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) / 1.11;
						messageBox(val4, val5, val6);
					}
				}
				if (event.getSelectedIndex() == 2)
				{
					//200 FR SCM
					if (stroke.getSelectedIndex() == 0)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 3.2);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) / 1.11;
						messageBox(val4, val5, val6);
					}
					//200 BK SCM
					if (stroke.getSelectedIndex() == 1)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 2.4);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) / 1.11;
						messageBox(val4, val5, val6);
					}
					//200 BR SCM
					if (stroke.getSelectedIndex() == 2)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 4.0);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) / 1.11;
						messageBox(val4, val5, val6);
					}
					//200 FL SCM
					if (stroke.getSelectedIndex() == 3)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 2.8);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) / 1.11;
						messageBox(val4, val5, val6);
					}
					//200 IM SCM
					if (stroke.getSelectedIndex() == 4)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 3.2);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) / 1.11;
						messageBox(val4, val5, val6);
					}
				}
				if (event.getSelectedIndex() == 3)
				{
					//400 FR SCM
					if (stroke.getSelectedIndex() == 0)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 6.4);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) * 1.153;
						messageBox(val4, val5, val6);
					}
					//400 IM SCM
					if (stroke.getSelectedIndex() == 4)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 6.4);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) / 1.11;
						messageBox(val4, val5, val6);
					}
				}
				if (event.getSelectedIndex() == 4)
				{
					//800 FR SCM
					if (stroke.getSelectedIndex() == 0)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 12.8);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) * 1.153;
						messageBox(val4, val5, val6);
					}
				}
				if (event.getSelectedIndex() == 5)
				{
					//1500 FR SCM
					if (stroke.getSelectedIndex() == 0)
					{
						val4 = (turnToSeconds(val1, val2, val3) + 24.0);
						val5 = (turnToSeconds(val1, val2, val3));
						val6 = (turnToSeconds(val1, val2, val3)) * 1.013;
						messageBox(val4, val5, val6);
					}
				}
			}
		}
	}
	
	/**
	 * Converts the time that is in the format minutes:seconds.hundreths to just seconds
	 *
	 * Multiples the minutes value by 60, keeps the seconds value the same, and multiplies the hundreths value by 0.01 and adds
	 * them all together
	 *
	 *@param num1	value that holds the number of minutes inputed by the user
	 *@param num2	value that holds the number of seconds inputed by the user
	 *@param num3	value that holds the number of hundreths of seconds inputer by the user
	 *@return		value that is time in the time in just seconds
	 */
	public double turnToSeconds (double num1, double num2, double num3)
	{
		return num1 * 60 + num2 + 0.01 * num3;
	}
	
	public void messageBox (double v1, double v2, double v3)
	{
		int one, two, three, four, five, six, seven , eight, nine;
		String a, b, c, d, e, f;
		
		one = (int)v1/60;
		two = (int)v1%60;
		three = (int)((v1%1) * 100);
		
		four = (int)v2/60;
		five = (int)v2%60;
		six = (int)((v2%1) * 100);
		
		seven = (int)v3/60;
		eight = (int)v3%60;
		nine = (int)((v3%1) * 100);
		
		a = addExtraZero(two);
		b = addExtraZero(three);
		c = addExtraZero(five);
		d = addExtraZero(six);
		e = addExtraZero(eight);
		f = addExtraZero(nine);
		
		JOptionPane.showMessageDialog(null, "Your time in LCM is: " + one + ":" + a + "." + b + "\nYour time in SCM is: " + four + ":" + c + "." + d + "\nYour time in SCY is: " + seven + ":" + e + "." + f);
	}
	
	/**
	 *	Adds a zero (0) to values that are less than 10 for the seconds and hundreths values
	 *
	 *Once the mathematical operations have been performed, values that are less then 10 will not have a zero in front of them.
	 *Proper swimming time convention requires a zero (0) in front of the single digit number for the seconds and minutes values
	 *Example: time before method: 2:7.9 is now 2:07.09
	 *
	 *@param nums	the int value for the number of seconds or hundreths
	 *@return		the original int in the String form of the int if its value is ten (10) or greater or the String form of the
	 *					original int preceded by the character "0" if its value is zero (0) to nine (9) 
	 */
	public String addExtraZero (int nums)
	{
		String s = Integer.toString(nums);
		
		if (s.length() < 2)
		{
			s = "0" + s;
		}
		return s;
	}
	
	public static void main (String[] args)
	{
		new SwimTimeConverter();
	}	
}
