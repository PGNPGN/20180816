package sse;

import java.util.Scanner;

public class D0 {
	Scanner scan = new Scanner(System.in);
	int x, y;
	int startx, starty;
	int goalx, goaly;
	int cnt=0;
	Node[] queue;
	Node data;
	int rp=0, wp=1;
	int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	int[][] array;
	public class Node{
		int x, y, cnt;
		
		public Node(int a, int b, int cnt) {
			x = a;
			y = b;
			this.cnt = cnt;
//			System.out.println("x= "+x+" y= "+y+" cnt= "+cnt);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D0 obj = new D0();
		obj.getInput();
		obj.count();
	}
	
	public void getInput() {
		x = scan.nextInt();
		y = scan.nextInt();
		startx = scan.nextInt();
		starty = scan.nextInt();
		goalx = scan.nextInt();
		goaly = scan.nextInt();
		queue = new Node[x*y];
		array = new int[x][y];
	}
	
	public void count() {
		int nx, ny;
		queue[0] = new Node(startx, starty, cnt);
		while(rp<wp) {
			data = queue[rp];
			rp++;
			if(data.x == goalx && data.y == goaly) {
				System.out.println(data.cnt);
				break;
			}else {
				for(int i=0; i<8; i++) {
					nx = data.x + dx[i];
					ny = data.y + dy[i];
					if((nx>=1 && nx<=x) && (ny>=1 && ny<=y)) {
						if(array[nx-1][ny-1]==0) {
							queue[wp] = new Node(nx, ny, data.cnt+1);
							array[nx-1][ny-1] = 1;
							wp++;
						}
						
					}
				}
			}
		}
	}
}
