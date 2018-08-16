package sse;

import java.util.Scanner;

public class C8 {
	Scanner scan = new Scanner(System.in);
	int x;
	int y;
	char[][] array;
	Node[] queue;
	Node data;
	int startx, starty;
	int goalx, goaly;
	int time=0;
	int[] dx = {0, 0, 1, -1};
	int[] dy = {1, -1, 0, 0};
	int rp=0, wp=1;
	
	public class Node{
		int a;
		int b;
		int time;

		public Node(int a, int b, int time) {
			this.a = a;
			this.b = b;
			this.time = time;
		}
		
		public void inQue(int a, int b, int time) {
			this.a = a;
			this.b = b;
			this.time = time;
			wp++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C8 obj = new C8();
		obj.getInput();
		obj.bfs();
	}

	public void getInput() {
		y = scan.nextInt();
		x = scan.nextInt();
		starty = scan.nextInt();
		startx = scan.nextInt();
		goaly = scan.nextInt();
		goalx = scan.nextInt();
		scan.nextLine();
		queue = new Node[x*y];
		array = new char[x][y];
		String dummy = "";
		for(int i=0; i<x; i++) {
			dummy = scan.nextLine();
			for(int j=0; j<y; j++) {
				array[i][j] = dummy.charAt(j);
			}
		}
//		for(int i=0; i<x; i++) {
//			for(int j=0; j<y; j++) {
//				System.out.print(array[i][j]+" ");
//			}
//			System.out.println();
//		}
		scan.close();
	}

	public void bfs() {
		int nr, nc;
		queue[0] = new Node(startx, starty, time);
		array[startx-1][starty-1] = 1;
		while(rp<wp) {
			data = queue[rp];
			rp++;
			if(data.a == goalx && data.b == goaly) {
				System.out.println(data.time);
			}
			for(int i=0; i<4; i++) {
				nr = data.a + dx[i];
				nc = data.b + dy[i];
				try {
					if(array[nr-1][nc-1]=='0') {
						queue[wp++] = new Node(nr, nc, data.time+1);
						array[nr-1][nc-1] = '1';
					}
				}catch (ArrayIndexOutOfBoundsException e) {
//					System.out.println((nr-1)+"+"+(nc-1));
				}
				
			}
			
		}
	}
}
