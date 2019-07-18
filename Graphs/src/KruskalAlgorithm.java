import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	int src;
	int destination;
	int weight;
	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight; // sort in increasing order
	}
}
public class KruskalAlgorithm {
	public static void kruskals(Edge [] input , int n) {
		Arrays.sort(input);
		int parent [] = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		Edge output[] = new Edge[n - 1];
		//count represent no of edges present in mst
		int count = 0;
		int i = 0;
		while(count != n - 1) {
			Edge curredge = input[i];
			int srcparent = findparent(curredge.src,parent);
			int destparent = findparent(curredge.destination,parent);
			if(srcparent != destparent) {
				output[count] = curredge;
				count++;
				parent[srcparent] = destparent;
			}
			i++;
		}
		for(int j = 0; j < n - 1; j++) {
			if(output[j].src > output[j].destination) {
				System.out.println(output[j].destination +" " + output[j].src + " " + output[j].weight);
			}else {
				System.out.println(output[j].src +" " + output[j].destination + " " + output[j].weight);

			}
		}
		
	}
	private static int findparent(int src, int[] parent) {
		if(parent[src] == src) {
			return src;
		}
		return findparent(parent[src], parent);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int E = s.nextInt();
		Edge[] input = new Edge[E];
		for(int i = 0; i < E; i++) {
			input[i] = new Edge();
			input[i].src = s.nextInt();
			input[i].destination = s.nextInt();
			input[i].weight = s.nextInt();
		}
		kruskals(input,n);
	}
	
}
