
public class Bellman {
	public static int[] calc (int[][] matriz, int vertices, int arestas, int src) {
		// Initialize distance of all vertices as infinite.
	    int []dis = new int[vertices];
	    for (int i = 0; i < vertices; i++)
	        dis[i] = Integer.MAX_VALUE;
	 
	    // initialize distance of source as 0
	    dis[src] = 0;
	 
	    // Relax all edges |V| - 1 times. A simple
	    // shortest path from src to any other
	    // vertex can have at-most |V| - 1 edges
	    for (int i = 0; i < vertices - 1; i++)
	    {
	 
	        for (int j = 0; j < arestas; j++)
	        {	
	            if (dis[matriz[j][0]] != Integer.MAX_VALUE && dis[matriz[j][0]] + matriz[j][2] <
	                            dis[matriz[j][1]])
	                dis[matriz[j][1]] =
	                dis[matriz[j][0]] + matriz[j][2];
	        }
	    }
	 
	    // check for negative-weight cycles.
	    // The above step guarantees shortest
	    // distances if matriz doesn't contain
	    // negative weight cycle. If we get a
	    // shorter path, then there is a cycle.
	    for (int i = 0; i < arestas; i++)
	    {
	        int x = matriz[i][0];
	        int y = matriz[i][1];
	        int weight = matriz[i][2];
	        if (dis[x] != Integer.MAX_VALUE &&
	                dis[x] + weight < dis[y]) {
	        	System.out.println("ERRO!, ciclo negativo encontrado");
	        	return null;
	        }
	    }
	    return dis;
	}
}
