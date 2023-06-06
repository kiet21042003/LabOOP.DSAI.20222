import java.util.Scanner;
public class Array {
	
	public static int[] sort (int[] arr) {
		
		int n = arr.length;
		int newarr[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			newarr[i] = arr[i];
		}
		
		for (int i = 0; i < n; i++) {
			int tmp = 0;
			for (int j = i+1; j < n; j++) {
				if (newarr[i] > newarr[j]) {
					tmp = newarr[i];
					newarr[i] = newarr[j];
					newarr[j] = tmp;}
			} 
		}
		return newarr;
	}
	
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Lenght of an array" );
		int n = input.nextInt();
		int arr[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			
			int ele = input.nextInt();
			arr[i] = ele;
		}
		
		int[] newarr = sort(arr);
		int total = 0, avg = 0;
		
		System.out.print("After sorting: ");
		for (int i = 0; i < n; i++) {
			total = total + newarr[i];
			System.out.print(newarr[i] + " ");
		}
		avg = total / n;
		System.out.println();
		System.out.println("Sum is: " + total);
		System.out.println("Average is: " + avg);	
			
		
		
	}
}
