package sse;

import java.util.Scanner;

public class D1 {
	Scanner scan= new Scanner(System.in);
	int x, y;
	int[][] map;
	int[][] coordinate;
	int coordinateCnt=0;
	Node[] queue;
	Node data;
	int cnt=0;
	int rp=0, wp=0;
	int[] dx = {0,0,1,-1};
	int[] dy = {1,-1,0,0};
	boolean flag = false;

	public class Node{
		int x, y, cnt;

		public Node(int a, int b, int cnt) {
			x = a;
			y = b;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D1 obj = new D1();
		obj.getInput();
		obj.findCoordinate();
		obj.bfs();
		obj.print();
	}

	public void getInput() {
		y = scan.nextInt();
		x = scan.nextInt();
		map = new int[x][y];
		coordinate = new int[2][x*y];
		queue = new Node[x*y];

		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				map[i][j] = scan.nextInt();
			}
		}

//		for(int i=0; i<x; i++) {
//			for(int j=0; j<y; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
	}

	public void findCoordinate() {
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				if(map[i][j] == 1) {
					coordinate[0][coordinateCnt] = i;
					coordinate[1][coordinateCnt] = j;
					coordinateCnt++;
				}
			}
		}
		for(int i=0; i<coordinateCnt; i++) {
//			System.out.println(coordinate[0][i]+" "+coordinate[1][i]);
		}
	}

	public void bfs() {
		int nx=0, ny=0;
		for(int i=0; i<coordinateCnt; i++) {
			queue[i] = new Node(coordinate[0][i], coordinate[1][i], cnt);
		}
		wp = coordinateCnt;
		while(rp<wp) {
			data = queue[rp];
			rp++;
			for(int i=0; i<4; i++) {
				nx = data.x + dx[i];
				ny = data.y + dy[i];
				if(nx>=0 && nx<x && ny>=0 && ny<y) {
					if(map[nx][ny]==0) {
						queue[wp] = new Node(nx, ny, data.cnt+1);
						wp++;
//						System.out.println(wp+" "+(data.cnt+1));
						map[nx][ny] = 1;
						
//						for(int k=0; k<x; k++) {
//							for(int j=0; j<y; j++) {
//								System.out.print(map[k][j]+" ");
//							}
//							System.out.println();
//						}
					}
				}
			}
		}
	}

	public void print() {
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				if(map[i][j]==0) {
					flag = true;
					break;
				}
			}
			if(flag == true)
				break;
		}

		if(flag == true) {
			System.out.println(-1);
		}else if(coordinateCnt == x*y) {
			System.out.println(0);
		}else {
			System.out.println(queue[wp-1].cnt);
		}
	}
}
