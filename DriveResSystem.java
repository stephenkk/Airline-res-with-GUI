import javax.swing.JOptionPane;

public class DriveResSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int start = JOptionPane.showConfirmDialog(null, "Would you like to reserve one?", "There are seats"
				+ " avialable on this flight", JOptionPane.YES_NO_OPTION);
		if (start == 1 )
			System.exit(0);
		else {
			ResSystem flight = new ResSystem();
			flight.setVisible(true);
		}
		
	}

}
