import java.util.Scanner;

public class NumberOfDays {
	
	public static void main(String args[]) {
		
		System.out.println("Enter month and year respectively: ");
		Scanner input = new Scanner(System.in);
		
		
		boolean check31 = true;
		String input_month = input.nextLine();
		int year = input.nextInt();
		System.out.println(input_month);
	

		if ((input_month.equals("April")) || (input_month.equals("Apr.")) ||
				(input_month.equals("Apr")) || (input_month.equals("4"))) {check31 = false;}
		
		else if ((input_month.equals("June")) || (input_month.equals("Jun.")) ||
				(input_month.equals("Jun")) || (input_month.equals("6"))) {check31 = false;}
		
		else if ((input_month.equals("September")) ||(input_month.equals("Sep.")) ||
				(input_month.equals("Sep")) || (input_month.equals("9"))) {check31 = false;}

		else if ((input_month.equals("November")) || (input_month.equals("Nov.")) ||
				(input_month.equals("Nov")) || (input_month.equals("11"))) {check31 = false;}

		int days_of_feb = 28;
		
		if (year < 0) {System.out.println("Year has to be non-negative");}
		
		if (((year % 4 == 0) && (year % 100 != 0)) || 
				((year % 100 == 0)&&(year % 400 == 0))) {days_of_feb = 29;}
		
		boolean checkfeb = ((input_month.equals("February")) || (input_month.equals("Feb.")) ||
				(input_month.equals("Feb")) || (input_month.equals("2")));
		
		if (checkfeb) {
			System.out.println(days_of_feb);
		}
		
		else if (check31) {
			System.out.println(31);
	
		} else if (!check31) {
			System.out.println(30);
		}
		
		System.exit(0);
		
	} 
}