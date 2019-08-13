package com.datasigns.demoapp;

import java.util.Scanner;

public class CommandLineApp {

	public static void main(String[] args) {
		getInputAndProcess();
	}
	
	private static void getInputAndProcess() {
		System.out.println("Enter the Command [SHRT/EXPD <url>] or [EXIT]:\n");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		URLShortener urlShortener = new BasicURLShortener();
		
		inputLoop: while(true) {
			String[] inp = s.trim().split("\\s+");
			String op = "INVALID COMMAND";
			int n = inp.length;
			if(n>0) {
				String command = inp[0].trim().toUpperCase();
				switch(command) {
				case "SHRT":
					if(n<2) {
						op = "Missing URL";
					} else {
						String url = inp[1].trim();
						op = urlShortener.getShortenedURL(url);
					}
					break;
				case "EXPD":
					if(n<2) {
						op = "Missing URL";
					} else {
						String url = inp[1].trim();
						op = urlShortener.getActualURL(url);
					}
					break;
				case "EXIT":
					break inputLoop;
				}
			}
			System.out.println(op);
			s = sc.nextLine();
		}
		sc.close();
	}

}
