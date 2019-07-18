import java.util.Scanner;

public class haspath {
    public static boolean haspath(int [][]edges,int sv,int ev,boolean visited[]){
        if(edges[sv][ev] == 1){
            return true;
        }
        boolean x = false;
        for(int i = 0; i < edges.length;i++ ){
            if(edges[sv][i] == 1 && !visited[i])
                visited[i] = true;
                x = haspath(edges,i,ev,visited);
        }
        return x;
    }
    public static boolean haspath(int [][]edges,int sv,int ev){
        boolean visited [] = new boolean[edges.length];
        boolean x = false;
        for(int i = 0; i < edges.length; i++){
            if(!visited[i]){
             x = haspath(edges,sv,ev,visited);
            }
        }
        return x;
    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();
        int edges [][] = new int[V][V];
		for(int i = 0 ; i < E; i++) {
			int sv = s.nextInt();
			int ev = s.nextInt();
			edges[sv][ev] = 1;
			edges[ev][sv] = 1;
		}
        int v1 = s.nextInt();
		int v2= s.nextInt();
		boolean k = haspath(edges,v1,v2);
        System.out.println(k);
	}
}