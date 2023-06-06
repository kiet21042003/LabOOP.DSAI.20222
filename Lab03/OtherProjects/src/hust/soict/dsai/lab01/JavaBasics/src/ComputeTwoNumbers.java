// Write a program to calculate sum, difference, product and quotient of 2 double 
// numbers which are entered by users
import javax.swing.JOptionPane;
public class ComputeTwoNumbers {
	public static void main(String[] args) {
		String str1, str2;
		str1 = JOptionPane.showInputDialog("Input the first number: ");
		str2 = JOptionPane.showInputDialog("Input the second number: ");
		double num1 = Double.parseDouble(str1);
		double num2 = Double.parseDouble(str2);
		
		double tot, diff, prod, quot;
		tot = num1 + num2;
		diff = num1 - num2;
		prod = num1*num2;
		
		String noti = "Sum is " + tot +"\nDifference is " + diff + "\nProduct is " + prod;
		
		
		if (num2 == 0.0) {
			noti += "\nInvalid divisor for division";
		} else {
			quot = num1 / num2;
			noti += "\nQuotient is " + quot;
		};
		JOptionPane.showMessageDialog(null, noti);
		System.exit(0);
	}
}
