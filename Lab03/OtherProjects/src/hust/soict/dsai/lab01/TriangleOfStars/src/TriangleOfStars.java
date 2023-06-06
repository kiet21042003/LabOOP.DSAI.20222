import java.util.Scanner;
public class TriangleOfStars {
	public static void main(String[] args) {
		System.out.println("Input height of triangel n: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		for (int i = 1; i <= n; ++i) {
			System.out.println(" ".repeat(n+1-i) + "*".repeat(2*i-1) + " ".repeat(n+1-i));
		}
		System.exit(n);
	}
}


