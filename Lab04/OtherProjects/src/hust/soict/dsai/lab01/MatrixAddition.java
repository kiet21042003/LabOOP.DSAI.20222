package hust.soict.dsai.lab01;
import java.util.Scanner;

class Matrix {
	private int length;
	private int width;
	private double[][] mat;
	
	public Matrix(double[][] m) {
		length = m.length;
		width = m[0].length;
		mat = m;
	}
	
	public void display() {
		for (double [] row : this.mat) {
			for (double x : row) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	
	public Matrix add(Matrix m) {
		double[][] tmp = new double[this.length][this.width];
		for (int i = 0; i < this.length; i++) {
			for (int j = 0; j < this.width; j++) {
				tmp[i][j] = this.mat[i][j] + m.mat[i][j];
			}
		}
		return new Matrix(tmp);
		 
	}
}

public class MatrixAddition {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter matrices' size: ");
		int n = input.nextInt();
		int m = input.nextInt();
		System.out.println("Enter the first matrix: ");
		double[][] mat1 = new double[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mat1[i][j] = input.nextDouble();
			}
		}
		Matrix Mat1 = new Matrix(mat1);
		System.out.println("Enter the second matrix: ");
		double[][] mat2 = new double[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mat2[i][j] = input.nextDouble();
			}
		}
		Matrix Mat2 = new Matrix(mat2);
		Matrix ans = Mat1.add(Mat2);
		System.out.println("The sum of the two matrices:");
		ans.display();
	}
}
