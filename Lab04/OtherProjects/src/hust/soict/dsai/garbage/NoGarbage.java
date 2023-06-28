package hust.soict.dsai.garbage;

import java.nio.file.*;

public class NoGarbage {

	public static void main(String[] args) throws Exception {
		String filename = "D:\\hust\\20222\\oop\\OOP.20222\\Lab\\OOP.Lab.20222.20210087.TruongGiaBach\\Other\\src\\hust\\soict\\dsai\\garbage\\test.txt";
		//here I use the path on my local repository
		byte[] inputBytes = { 0 };
		long startTime, endTime;
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		StringBuilder outputStringBuilder = new StringBuilder();
		for (int i = 0; i < 1000; i++) {
			for (byte b : inputBytes) {
				outputStringBuilder.append((char)b);
			}			
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

}