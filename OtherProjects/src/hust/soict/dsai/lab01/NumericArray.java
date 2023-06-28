package hust.soict.dsai.lab01;
import java.util.Scanner;
import java.util.Arrays;

class Array {
	private double[] array;
	private int len;
	
	public Array(double[] a) {
		array = a;
		len = a.length;
	}
	
	public void display() {
		for (double x : this.array) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
	public void Sort() {
		Arrays.sort(this.array);
	}
	
	public double sum() {
		double s = 0;
		for (double x : this.array) {
			s += x;
		}
		return s;
	}
	
	public double avg() {
		return this.sum() / this.array.length;
	}
}

public class NumericArray {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the array length: ");
		int n = input.nextInt();
		System.out.println("Enter array elements: ");
		double[] arr = new double[n];
		for (int i = 0; i < n; i++) {
			arr[i] = input.nextDouble();
		}
		Array my_array1 = new Array(arr);
		
		System.out.print("Array before sorting: ");
		my_array1.display();
		my_array1.Sort();
		System.out.print("Array after sorting: ");
		my_array1.display();
		System.out.print("Array's sum: ");
		System.out.println(my_array1.sum());
		System.out.print("Array's average value: ");
		System.out.println(my_array1.avg());
	}
}
