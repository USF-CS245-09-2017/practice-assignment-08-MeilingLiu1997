package cs245.PA08;

import java.util.Stack;

public class GraphAdjMatrix implements Graph{
	// data member
	int[][] edges;
	
	// constructor
	public GraphAdjMatrix(int size) {
		edges = new int[size][size];
	}

	@Override
	// Adds a directed edge between two vertices from src to tar.
	public void addEdge(int src, int tar) {
		// TODO Auto-generated method stub
		edges[src][tar] = 1;
	}

	@Override
	// Prints (to console) one ordering of vertices such that 
	// each directed edge (v1, v2) from vertex v1 to vertex v2, v1 comes before v2 in the ordering. 
	// If such an ordering is not possible (due to cycles, for example), 
	// this function must indicate so, though it may print a partial solution in so doing.
	public void topologicalSort() {
		// TODO Auto-generated method stub
		boolean[] visited = new boolean[edges.length];
		Stack stack = new Stack();
		for(int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				dfs(i, visited, stack);
			}
		}
	}
	
	private void dfs(int vertex, boolean[] visited, Stack stack) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(new Integer(vertex));
		while(!s.empty()) {
			
			int v = s.pop();
			System.out.println(v);				//Check sorting here.
			visited[v] = true;

			for(int i = 0; i < neighbors(v).length; i++) {
				
				int n = neighbors(v)[i];

				if(!visited[n]) {
					s.push(new Integer(n));
					visited[n] = true;
				}
			}
		}
	}

	@Override
	// Returns an array of vertex IDs such that each ID represents a vertex 
	// which is the destination of the edge origination from the argument.
	
	// list of neighbors for a vertex
	public int[] neighbors(int vertex) {
		// TODO Auto-generated method stub
		int[] vertexs = new int[outdegree(vertex)];
		int index = 0;
		
		for(int i = 0; i < edges.length; i++) {
			if(edges[vertex][i] == 1) {
				vertexs[index] = i;
				index++;
			}
		}
		return vertexs;
	}
	
	// number of vertexs
	public int outdegree(int vertex) {
		int degree = 0;
		for(int i = 0; i < edges.length; i++) {
			if(edges[vertex][i] != Double.POSITIVE_INFINITY &&
					edges[vertex][i] != 0) {
				degree++;
			}
		}
		return degree;
	}
	
}
