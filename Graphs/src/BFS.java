import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
public class BFS {
	public static void printhelper(int edges[][],int sv,boolean visited[]) {
		System.out.println(sv);
		Queue<Integer> q = new LinkedList<>();
		 Queue<Integer> q1 = new LinkedList<>(); 
		q.add(sv);
		visited[sv] = true;
		while(!q.isEmpty()) {
			int front = q.remove();
			System.out.println(front);
			for(int i = 0; i < edges.length; i++) {
				if(edges[front][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
	public static void print(int edges[][]) {
		int n = edges.length;
		boolean visited [] = new boolean[n];
		for(int i = 0; i < n; i++) {
			if(!visited[i])
				printhelper(edges,i,visited);
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// no of vertices
		int n = s.nextInt();
		int e = s.nextInt();
		int edges [][] = new int[n][n];
		for(int i = 0 ; i < e; i++) {
			int sv = s.nextInt();
			int ev = s.nextInt();
			edges[sv][ev] = 1;
			edges[ev][sv] = 1;
		}
		print(edges);

	}

}
