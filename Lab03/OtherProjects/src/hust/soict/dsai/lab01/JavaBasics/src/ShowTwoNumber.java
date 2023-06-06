import javax.swing.JOptionPane;
public class ShowTwoNumber {
	public static void main(String[] args) {
		String num1, num2;
		String notification = "You have just entered ";
		num1 = JOptionPane.showInputDialog(
				null, "Input your first number: ", "What is your first number: ",
				JOptionPane.INFORMATION_MESSAGE);
		
		num2 = JOptionPane.showInputDialog(
				null, "Input your second number: ", "What is your second number: ",
				JOptionPane.INFORMATION_MESSAGE);
		
		notification += num1 + " and " + num2;
		JOptionPane.showMessageDialog(null, notification,
				"Show two numbers", JOptionPane.INFORMATION_MESSAGE);
	}
}
