import java.util.Scanner;
public class PrimsAlgorithm {
	public static void prims(int [][] input) {
		int V = input.length;
		//visited array
		boolean vis[] = new boolean[V];
		//weight array
		int weight[] = new int[V];
		weight[0] = 0;
		for(int i = 1; i < V; i++) {
			weight[i] = Integer.MAX_VALUE;
		}
		//parent array
		int parent[] = new int[V];
			parent[0] = -1;
		//whole logic of prims algorithm
		for(int i = 0; i < V; i++) {
			// pick vertex with min weight
			int minvertex = min(weight ,vis); 
			vis[minvertex] = true;
			// explore its unvisited neighbors
			for(int j = 0; j < V; j++) {
				if(!vis[j] && input[minvertex][j] != 0) {
					if(weight[j] > input[minvertex][j]) {
						weight[j] = input[minvertex][j];
						parent[j] = minvertex;
					}
				}
			}
		}
		for(int v = 1; v < V; v++) {
			if(parent[v] < v) {
				System.out.println(parent[v] + " "+ v + " " + weight[v]);
			}else {
				System.out.println(v + " "+ parent[v] + " " + weight[v]);
			}
		}
	}
	private static int min(int[] weight, boolean[] vis) {
		int minvertex = -1;
		for(int i = 0; i < weight.length; i++) {
			if(!vis[i] && (minvertex == -1 || weight[i] < weight[minvertex])) {
				minvertex = i;
			}
		}
		return minvertex;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();
		int[][] input = new int[V][V];
		for(int i = 0 ; i < E; i++) {
			int sv = s.nextInt();
			int ev = s.nextInt();
			int weight = s.nextInt();
			input[sv][ev] = weight;
			input[ev][sv] = weight;
		}
		prims(input);
	}

}
