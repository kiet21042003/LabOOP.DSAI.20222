package hust.soict.dsai.lab01;
import java.util.Scanner;

class StarTriangle{
	private int height;
	public StarTriangle(int h){
		height = h;
	}
	public void makeTriangle() {
		int h = this.height;
		for (int i = 0; i < h; i++) {
			for (int j = 1; j < h*2; j++) {
				if (j >= h-i && j <= h+i) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}

public class Triangle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("n = ");
		int n = input.nextInt();
		StarTriangle T = new StarTriangle(n);
		T.makeTriangle();
	}
}
