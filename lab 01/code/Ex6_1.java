import javax.swing.JOptionPane;
public class Ex6_1 {
	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null, "Do you wnat to change the first class ticket?");
		JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION?"Yes":"No"));
		System.exit(0);
	}
}