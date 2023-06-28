package hust.soict.dsai.lab01;
import java.util.Scanner;
import java.lang.Math;

class LinearEquation {
	private double a, b;
	
	public void getCoefficients() {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("Enter the coefficients:");
			this.a = input.nextDouble();
			if (a == 0) {
				System.out.println("Invalid input\nplease enter a non-zero a");
				continue;
			}
			this.b = input.nextDouble();
			break;
		}
	}
	
	public void solve() {
		if (this.a == 0) {
			if (this.b == 0) {
				System.out.println("There're infinite solutions");
			}
			else {
				System.out.println("There's no solution");
			}
		}
		else {
			System.out.println("There's an unique solution: x = " + (-b/a));
		}
	}
}

class LinearSystem {
	private double a1, b1, c1, a2, b2, c2;
	private double D, D1, D2;
	
	public void getCoefficients() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the coefficients:");
		this.a1 = input.nextDouble();
		this.b1 = input.nextDouble();
		this.c1 = input.nextDouble();
		this.a2 = input.nextDouble();
		this.b2 = input.nextDouble();
		this.c2 = input.nextDouble();
	}
	
	private void setDeterminants() {
		this.D = a1*b2 - a2*b1;
		this.D1 = c1*b2 - c2*b1;
		this.D2 = c2*a1 - c1*a2;
	}
	
	public void solve() {
		setDeterminants();
		if (this.D == 0) {
			if (this.D1 == 0 && this.D2 == 0) {
				System.out.println("There're infinite solutions");
			}
			else {
				System.out.println("There's no solution");
			}
		}
		else {
			System.out.println("There's unique solution:\nx1 = " + D1/D
								+ "\nx2 = " + D2/D);
		}
	}
}

class QuadraticEquation{
	private double a, b, c;
	private double delta;
	
	public void getCoefficients() {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("Enter the coefficients:");
			this.a = input.nextDouble();
			if (a == 0) {
				System.out.println("Invalid input, please enter an non-zero a");
				continue;
			}
			this.b = input.nextDouble();
			this.c = input.nextDouble();
			break;
		}
	}
	
	private void setDelta() {
		this.delta = b*b - 4*a*c;
	}
	
	public void solve() {
		this.setDelta();
		if (this.delta < 0) {
			System.out.println("There's no solution");
		}
		else if (this.delta == 0){
			System.out.println("There's an unique solution: x = " 
							+ (-this.b/2*this.a));
		}
		else {
			System.out.println("There are two different solutions:\nx1 = "
							+ ((-this.b - Math.sqrt(this.delta))
							/ 2*this.a) + "\nx2 = " + ((-this.b + 
							Math.sqrt(this.delta)) / 2*this.a));
		}
	}
}

public class SolveEquations {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		/*
		 * enter 1 for solving first-degree equation with one variable
		 * enter 2 for solving system of first-degree equations with two variables
		 * enter 3 for solving second-degree equation with one variable
		 */
		System.out.println("Enter equation's type: ");
		int t = input.nextInt();
		if (t == 1) {
			LinearEquation problem = new LinearEquation();
			problem.getCoefficients();
			problem.solve();
		}
		else if (t == 2) {
			LinearSystem problem = new LinearSystem();
			problem.getCoefficients();
			problem.solve();
		}
		else {
			QuadraticEquation problem = new QuadraticEquation();
			problem.getCoefficients();
			problem.solve();
		}
	}
}
