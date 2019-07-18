import java.util.Scanner;
import java.util.ArrayList;
public class DFS {
	private static Scanner s;
	public static void printhelper(int edges[][],int sv,boolean visited[]) {
		System.out.println(sv);
		visited[sv] = true;
		for(int i = 0; i < edges.length; i++) {
			if(edges[sv][i] == 1 && !visited[i])
				printhelper(edges,i,visited);
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
		s = new Scanner(System.in);
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
//		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//		int n = s.nextInt();
// 		int e = s.nextInt();
// 		for(int i = 0; i< n; i++) {
// 			list.add(i,new ArrayList<Integer>());
// 		}
// 		for(int i = 1; i < e; i++) {
// 			int u = s.nextInt();
//			int v = s.nextInt();
//			list.get(u).add(v);
//			list.get(v).add(u);
// 		}
// 		for(int i = 0; i < list.size();i++) {
// 			for(int j = 0; j < list.get(i).size(); j++)
// 				System.out.print(list.get(i).get(j) + " ");
// 			System.out.println();
// 		}
	}

}
