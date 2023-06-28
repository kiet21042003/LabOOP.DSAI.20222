package hust.soict.dsai.lab01;
import java.util.Scanner;

class Calendar{
	private int month;
	private int year;
	private boolean leap_year;
	
	public boolean setDate(String m, String y) {
		this.month = setMonth(m);
		if (this.month == -1) {
			return false;
		}
		this.year = setYear(y);
		if (this.year == -1) {
			return false;
		}
		leap_year = checkLeapYear(this.year);
		return true;
	}
	
	private int setMonth(String m) {
		m += "";
		switch (m) {
			case "January":
			case "Jan.":
			case "Jan":
			case "1":
				return 1;
			case "February":
			case "Feb.":
			case "Feb":
			case "2":
				return 2;
			case "March":
			case "Mar.":
			case "Mar":
			case "3":
				return 3;
			case "April":
			case "Apr.":
			case "Apr":
			case "4":
				return 4;
			case "May":
			case "5":
				return 5;
			case "June":
			case "Jun":
			case "6":
				return 6;
			case "July":
			case "Jul":
			case "7":
				return 7;
			case "August":
			case "Aug.":
			case "Aug":
			case "8":
				return 8;
			case "September":
			case "Sept.":
			case "Sept":
			case "9":
				return 9;
			case "October":
			case "Oct.":
			case "Oct":
			case "10":
				return 10;
			case "November":
			case "Nov.":
			case "Nov":
			case "11":
				return 11;
			case "December":
			case "Dec.":
			case "Dec":
				return 12;
			default:
				System.out.println("Invalid input. Please enter again.");
				return -1;
		}
	}
	
	private int setYear(String y) {
		try {
			return Integer.parseInt(y);
		}
		catch(Exception e) {
			System.out.println("Invalid input. Please enter again.");
			return -1;
		}
	}
	
	private boolean checkLeapYear(int y) {
		return (y%4 == 0 && y%100 != 0) || (y%400 == 0);
	}
	
	public int getNumberOfDays() {
		switch (this.month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				if (this.leap_year) {
					return 29;
				}
				else {
					return 28;
				}
			default:
				return -1;
		}
	}
}

public class NumberOfDays {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("Enter the month: ");
			String month = input.nextLine();
			System.out.println("Enter the year: ");
			String year = input.nextLine();
			Calendar D = new Calendar();
			if (!D.setDate(month, year)) {
				continue;
			}
			System.out.println(D.getNumberOfDays());
			System.exit(0);
		}
	}
}
