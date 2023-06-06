import javax.swing.JOptionPane;

// Input: User name
// Output: Hello Name dialog
public class HelloNameDialog {
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("What is your name: ");
		JOptionPane.showMessageDialog(null, "Hello " + name);
		System.exit(0);
	}
}
