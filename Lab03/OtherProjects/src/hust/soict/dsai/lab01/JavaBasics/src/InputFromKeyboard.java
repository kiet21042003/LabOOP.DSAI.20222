// Exercise: Input from Keyboard
import java.util.Scanner;
public class InputFromKeyboard {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What is your name ?");
		String name = input.nextLine();
		System.out.println("How old are you");
		int age = input.nextInt();
		System.out.println("How tall are you (m)");
		double height = input.nextDouble();
		
		System.out.println(
				"Mr/Mrs " + name + ", " + age + " years old. Your height is " + height + "m"
				);
		System.exit(0);
	}
}
