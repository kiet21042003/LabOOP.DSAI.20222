import java.util.Scanner;
public class SumMatrices {

	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("a, b for axb matrices: ");
		int a = input.nextInt();
		int b = input.nextInt();
		
		
		
		int mat1[][] = new int[a][b];
		int mat2[][] = new int[a][b];
		
		System.out.println("Matrix 1: ");
		
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				mat1[i][j] = input.nextInt();
			}
		}
		
		System.out.println("Matrix 2: ");
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				mat2[i][j] = input.nextInt();
			}
		}
		int[][] sum = new int[a][b];
		
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				sum[i][j] = mat1[i][j] + mat2[i][j];
			}
		}
		System.out.println("Matrix 1");
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				System.out.print(mat1[i][j] + " ");
			} 
			System.out.println();
		}
		
		System.out.println("Matrix 2");
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				System.out.print(mat2[i][j] + " ");
			} 
			System.out.println();
		}
		
		System.out.println("Sum of 2 matrices: ");
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				System.out.print(sum[i][j] + " ");
			} 
			System.out.println();
		}
	}
}
