
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
public class ResSystem extends JFrame implements ActionListener{
	private boolean seats[];			//array for the seats on the plane.
	private boolean cabin;			//first class is cabin == true. coach is cabin == false.
	
	private boolean seatsRemain;	//seatsRemain == true means there are still seats available.
	private int firstClassSeat;		//finds the next assignable element in the array seats (FC)
	private int coachClassSeat;		//finds the next assignable element in the array seats (coach)

	public static final int WIDTH = 700;
	public static final int HEIGHT = 300;
	
	
	public ResSystem() {//Constructor
		cabin = false;
		int capacity = 11;
		seats = new boolean[capacity];
		seatsRemain = false;
		firstClassSeat = 0;
		coachClassSeat = 5;
		
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new FlowLayout());
		
		JButton FirstClassButton = new JButton("First Class");
		FirstClassButton.addActionListener(this);
		contentPane.add(FirstClassButton);
		
		JButton CoachClassButton = new JButton("Coach");
		CoachClassButton.addActionListener(this);
		contentPane.add(CoachClassButton);
	
	}//End Constructor
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		Container contentPane = getContentPane();
		
		if(actionCommand.equals("First Class")) 
			assignFirstClass();
	
		else if (actionCommand.equals("Coach")) 
			assignCoachClass();
	
		//System.out.println(cabin);
		// TODO Auto-generated method stub
		
	}
	
	public boolean planeNotFull() {	//Method to determine if seats remain after each assignment.
		int index=0;			//local variable to move through array elements
		seatsRemain=false;
		while (index <= 9) {
			if (seats[index]==false) {
				index++;
				seatsRemain=true;
				break;}
			else 
				index++;				
		}
		return seatsRemain;		//seatsRemain == true means seats are still available in at least
	}							//one class of service.
	public void setSeatsRemain (boolean newSeatsRemain) {
		seatsRemain = newSeatsRemain;
	}
	
	public boolean getSeatsRemain (){
	
		return seatsRemain;
	}
	
	
	public void assignFirstClass () {//Assigns a seat in first class based on customer choice
		firstClassSeat=0;			//offers coach (if available) if 1st is not available
		
		while (seats[firstClassSeat] != false && firstClassSeat <= 4) {
			firstClassSeat++;
		}if (firstClassSeat <= 4) {
		seats[firstClassSeat] = true;//array element set to true as seat is now assigned.
		
		JOptionPane.showMessageDialog(null, "Your seat is #" + (firstClassSeat + 1) +" in"
				+ " the first class cabin."
				+ " Your boarding pass is printed below.");
		System.out.println();
		printBoardingPassFC();
		planeNotFull();
		}
		else if (seatsRemain == true) {
		int secondChoice = JOptionPane.showConfirmDialog(null, "The first class cabin is "
				+ "full", "Would you like to researve in coach?", 
				JOptionPane.YES_NO_OPTION);	
		if (secondChoice == 0) 					
			assignCoachClass();
		else JOptionPane.showMessageDialog(null, "The next flight departs"
				+ "in three hours" );
		}
		
	}
	public void assignCoachClass () {//Assigns a seat in coach based on customer choice
		coachClassSeat=5;				//offers 1st class (if available) if coach is not available
		
			while (seats[coachClassSeat] != false && coachClassSeat <= 9) {
				coachClassSeat++;
			}
			
			if (coachClassSeat <= 9) {
			seats[coachClassSeat] = true;//array element set to true as seat is now assigned.
			JOptionPane.showMessageDialog(null, "Your seat is #" + (coachClassSeat + 1) +" in"
					+ " the coach cabin."
					+ " Your boarding pass is printed below.");
			System.out.println();
			printBoardingPassCoach();
			planeNotFull();
			}
			else if (seatsRemain = true) {
				int secondChoice = JOptionPane.showConfirmDialog(null, "The coach cabin is "
						+ "full", "Would you like to researve in First Class?", 
						JOptionPane.YES_NO_OPTION);	
				if (secondChoice == 0)					
				assignFirstClass();
				else JOptionPane.showMessageDialog(null, "The next flight departs"
						+ "in three hours" );
			}
	
	}

	public void printBoardingPassFC() {
System.out.println("**********************************************");
System.out.println("*                                            *");
System.out.println("*                                            *");
System.out.println("*  You are seated in the first class cabin.  *");
System.out.println("*  Your seat number is " + (firstClassSeat + 1) +"                     *");
System.out.println("*                                            *");
System.out.println("*                                            *");
System.out.println("**********************************************");
	
	}
	public void printBoardingPassCoach() {
System.out.println("**********************************************");
System.out.println("*                                            *");
System.out.println("*                                            *");
System.out.println("*  You are seated in the coach class cabin.  *");
System.out.println("*  Your seat number is " + (coachClassSeat + 1) +"                     *");
System.out.println("*                                            *");
System.out.println("*                                            *");
System.out.println("**********************************************");
	
	}
	
}

