// Solve first-degree equation with one variable
// first-degree equations with 2 variables
// second-degree equations with 1 variable
import javax.swing.JOptionPane;
import java.lang.Math;
public class SolveEquations {
	public static void main(String[] args) {
		String eqn_type = JOptionPane.showInputDialog(
				"First-degree One variable: 1"
				+ "\nFirst-degree Two variables: 2"
				+ "\nSecond-degree One variable: 3");
		switch (eqn_type) {
			case "1":
				String strFirstA = JOptionPane.showInputDialog("Input a(a != 0): ");
				String strFirstB = JOptionPane.showInputDialog("Input b: ");
				double FirstA = Double.parseDouble(strFirstA);
				double FirstB = Double.parseDouble(strFirstB);
				
				if (FirstA == 0.0) {
					JOptionPane.showMessageDialog(null, FirstA + " is not valid value for a");
				} else {
					double res1 = -FirstB / FirstA;
					JOptionPane.showMessageDialog(null, "x = " + res1);
				}; break;
			
			case "2":
				String strA11, strA12, strA21, strA22, strB1, strB2;
				strA11 = JOptionPane.showInputDialog("Input A11: ");
				strA12 = JOptionPane.showInputDialog("Input A12: ");
				strB1 = JOptionPane.showInputDialog("Input B1: ");
				strA21 = JOptionPane.showInputDialog("Input A21: ");
				strA22 = JOptionPane.showInputDialog("Input A22: ");
				strB2 = JOptionPane.showInputDialog("Input B2: ");
				
				double A11 = Double.parseDouble(strA11);
				double A12 = Double.parseDouble(strA12);
				double A21 = Double.parseDouble(strA21);
				double A22 = Double.parseDouble(strA22);
				double B1 = Double.parseDouble(strB1);
				double B2 = Double.parseDouble(strB2);
				
				double D = A11*A22 - A12*A21;
				
				if (D == 0.0) {
					JOptionPane.showMessageDialog(null, "Infinite or no real solution");
				} else {
					double Dx = B1*A22 - B2*A12;
					double Dy = A11*B2 - A21*B1;
					double x = Dx/D;
					double y = Dy/D;
					JOptionPane.showMessageDialog(null,
							"x = " + x + "\ny = " + y);
				}; break;
			
			case "3":
				String strSecondA, strSecondB, strSecondC;
				strSecondA = JOptionPane.showInputDialog("Input a (a != 0): ");
				strSecondB = JOptionPane.showInputDialog("Input b: ");
				strSecondC = JOptionPane.showInputDialog("Input c: ");
				
				double SecondA = Double.parseDouble(strSecondA);
				double SecondB = Double.parseDouble(strSecondB);
				double SecondC = Double.parseDouble(strSecondC);
				
				if (SecondA == 0.0) {
					JOptionPane.showMessageDialog(null, " 0 is invalid for a");
				} else {
				
					double delta = SecondB*SecondB - 4*SecondA*SecondC;
					
					if (delta < 0.0) {
						JOptionPane.showMessageDialog(null, "No real soluton");
					} else if (delta == 0.0) {
						double double_root = -SecondB / (2*SecondA);
						JOptionPane.showMessageDialog(null, "Double root: " + double_root);
					} else {
						double rooted_delta = Math.sqrt(delta);
						double x1 = (-SecondB + rooted_delta) / (2*SecondA);
						double x2 = (-SecondB - rooted_delta) / (2*SecondA);
						JOptionPane.showMessageDialog(null,
								"x = " + x1 + "\ny = " + x2);
					}
				
				}; break;
			default: JOptionPane.showMessageDialog(null, "Please input one of choices.");
		
				
		};
		System.exit(0);
	}
}
