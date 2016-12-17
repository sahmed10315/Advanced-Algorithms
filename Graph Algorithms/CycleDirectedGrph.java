

import java.util.Iterator;
import java.util.LinkedList;

public class CycleDirectedGrph {

	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency List Represntation

	// Constructor
	CycleDirectedGrph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	// A recursive function that uses visited[] and parent to detect
	// cycle in subgraph reachable from vertex v.
	Boolean isCyclicUtil(int v, boolean visited[], boolean[] recStack) {

		if (visited[v] == false) {
			// Mark the current node as visited and part of recursion stack
			visited[v] = true;
			recStack[v] = true;

			// Recur for all the vertices adjacent to this vertex
			Iterator<Integer> it = adj[v].iterator();
			Integer i;
			while (it.hasNext()) {
				i = it.next();

				// If an adjacent is not visited, then recur for that
				// adjacent
				if (!visited[i]) {
					if (isCyclicUtil(i, visited, recStack))
						return true;
				}

				// If an adjacent is visited and not parent of current
				// vertex, then there is a cycle.
				else if (recStack[i])
					return true;
			}

		}
		recStack[v] = false; // remove the vertex from recursion stack
		return false;
	}

	// Returns true if the graph contains a cycle, else false.
	Boolean isCyclic() {
		// Mark all the vertices as not visited and not part of recursion
		// stack
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		for (int i = 0; i < V; i++) {
			visited[i] = false;
			recStack[i] = false;
		}

		// Call the recursive helper function to detect cycle in different
		// DFS trees
		for (int i = 0; i < V; i++)
			if (isCyclicUtil(i, visited, recStack))
				return true;

		return false;
	}

	// Driver method to test above methods
	public static void main(String args[]) {
		// Create a graph given in the above diagram
		CycleUndirectedGrph g1 = new CycleUndirectedGrph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 0);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		if (g1.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");

		CycleUndirectedGrph g2 = new CycleUndirectedGrph(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		if (g2.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");
	}
}
