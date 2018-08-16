package sse;

import java.util.Scanner;

public class C10 {
	int x, y;
	int radiox, radioy;
	Scanner scan = new Scanner(System.in);
	String dummy ="";
	char[][] map ;
	Node[] queue;
	Node data;
	int cnt=0;
	int rp=0, wp=1;
	int[] dx = {0, 0, 1, -1};
	int[] dy = {1, -1, 0, 0};
	int extracnt=0;
	
	
	class Node{
		int x, y, cnt;
		
		public Node(int a, int b, int c) {
			x = a;
			y = b;
			cnt = c;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C10 obj = new C10();
		obj.getInput();
		obj.bfs();
		obj.extra();
	}
	
	public void getInput() {
		y = scan.nextInt();
		x = scan.nextInt();
		scan.nextLine();
		map = new char[x][y];
		queue = new Node[x*y];
		for(int i=0; i<x; i++) {
			dummy = scan.nextLine();
			for(int j=0; j<y; j++) {
				map[i][j] = dummy.charAt(j);
			}
		}
		radioy = scan.nextInt();
		radiox = scan.nextInt();
	}
	
	public void bfs() {
		int nx, ny;
		queue[0] = new Node(radiox, radioy, cnt);
		map[radiox-1][radioy-1] = '0';
		while(rp<wp) {
			data = queue[rp];
			rp++;
			for(int i=0; i<4; i++) {
				nx = data.x + dx[i];
				ny = data.y + dy[i];
				if(nx>0 && nx<=x && ny>0 && ny<=y) {
					if(map[nx-1][ny-1]=='1') {
						queue[wp] = new Node(nx, ny, data.cnt+1);
						map[nx-1][ny-1]='0';
						wp++;
					}
				}
			}
		}
		System.out.println((queue[wp-1].cnt)+3);
	}
	
	public void extra() {
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				if(map[i][j] == '1') {
					extracnt++;
				}
			}
		}
		System.out.println(extracnt);
	}
}
