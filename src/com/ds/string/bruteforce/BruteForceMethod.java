package com.ds.string.bruteforce;

public class BruteForceMethod {

	public static void main(String[] args) {
		System.out.println(bruteForceMethod("hello ashish", "hello"));
	}
	
	public static int bruteForceMethod(String text, String pattern) {
		
		int n = text.length();
		int m = pattern.length();
		
		for (int i = 0; i < n - m + 1; i++) {
			int j = 0;
			while (j < m && (pattern.charAt(j) == text.charAt(i + j))) {
				j = j + 1;
			}
			if (j == m) return i;
		}		
		return -1;
	}

}
