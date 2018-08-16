package sse;


import java.util.Arrays;
import java.util.Scanner;

public class C5 {
	Scanner scan = new Scanner(System.in);
	int plate;
	int kind;
	int eatnum;
	int coupon;
	int[] array;
	int[] check;
	int cnt = 0;
	int max = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C5 obj = new C5();
		obj.getInput();
		obj.check();
	}

	public void getInput() {
		plate = scan.nextInt();
		kind = scan.nextInt();
		eatnum = scan.nextInt();
		coupon = scan.nextInt();
		array = new int[plate];
		for(int i=0; i<plate; i++) {
			array[i] = scan.nextInt();
			//			System.out.println(array[i]);
		}
//		for(int i=0; i<plate; i++) {
//			System.out.println(array[i]);
//		}
	}

	public void check() {
		check = new int[kind];
		for(int i=0; i<plate; i++) {
			Arrays.fill(check, 0);
			cnt = 0;
			for(int j=0; j<eatnum; j++) {
				if(check[array[(i+j)%plate]-1]==0) {
					check[array[(i+j)%plate]-1]++;
					cnt++;
					max = Math.max(max, cnt);
				}
				if(check[coupon-1] == 0) {
					check[coupon-1]++;
					cnt++;
					max = Math.max(max, cnt);
				}
			}
		}

		System.out.println(max);
	}
}
