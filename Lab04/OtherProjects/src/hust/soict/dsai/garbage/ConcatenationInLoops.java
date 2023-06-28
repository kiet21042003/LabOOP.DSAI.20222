package hust.soict.dsai.garbage;

import java.util.Random;

public class ConcatenationInLoops {
	public static void main(String[] args) {
		String s = "";
		String a = "abc";
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++)
			s += a;
		System.out.println(String.format("String: %d", System.currentTimeMillis() - start));
		
		StringBuffer sbf = new StringBuffer();
		start = System.currentTimeMillis();
		for (int i =0; i < 100000; i++)
			sbf.append(a);
		System.out.println(String.format("StringBuffer: %d", System.currentTimeMillis() - start));
		
		StringBuilder sbd = new StringBuilder();
		start = System.currentTimeMillis();
		for (int i =0; i < 100000; i++)
			sbd.append(a);
		System.out.println(String.format("StringBuilder: %d", System.currentTimeMillis() - start));
	}
}