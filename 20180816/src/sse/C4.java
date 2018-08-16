package sse;

import java.util.Scanner;

public class C4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		long a = scan.nextLong();
		int power = (int)Math.log10(a);
		long front;
		long back;
		long num = scan.nextInt();
		
		long realfront=0;
		long realback=0;
		
		boolean flag = false;
		System.out.println(a);
		
		for(int i=1; i<power+1;i++) {
			front = (long)(a/(long)Math.pow(10, i));
			while(front%10 ==0) {
				front /= 10;
			}
			back = (long)(a%Math.pow(10, i));
			if((front+back)==num) {
				realfront = front;
				realback = back;
				flag = true;
				
			}
//				System.out.println("NONE");
			
//			System.out.println(front+" "+back);
		}
		
		if(flag == true) {
			System.out.println(realfront+"+"+realback+"="+num);
		}else
			System.out.println("NONE");
		
		
		scan.close();
		System.out.println(power);
	}
}