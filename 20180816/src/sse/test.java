package sse;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int y = scan.nextInt();
		int x = scan.nextInt();
		scan.nextLine();
		char[][] array = new char[x][y];
		String dummy="";
		for(int i=0; i<x; i++) {
			dummy = scan.nextLine();
			System.out.println(dummy);
			for(int j=0; j<y; j++) {
				System.out.println(dummy.charAt(j));
				array[i][j] = dummy.charAt(j);
			}
		}
//		int a = scan.nextInt();
//		scan.nextLine();
//		String asdf = scan.nextLine();
//		System.out.println(asdf.charAt(0));
		
//		for(int i=0; i<x; i++) {
//			for(int j=0; j<y; j++) {
//				System.out.print(array[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	
	
}
