import javax.swing.JOptionPane;

public class DriveResSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			ResSystem flight = new ResSystem();
			flight.planeNotFull();
			while (flight.getSeatsRemain() == true)
			flight.setVisible(true);
			
			JOptionPane.showMessageDialog(null, "The flight is full. "
					+ "The next flight is in 3 hours.");
			System.exit(0);
		
		
	}

}
