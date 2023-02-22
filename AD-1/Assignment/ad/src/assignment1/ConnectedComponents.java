package assignment1;
	// Java program for the above approach
	import java.util.*;
	class ConnectedComponents{

	// Stores the parent of each vertex
	static int []parent = new int[1000000];

	// Function to find the topmost
	// parent of vertex a
	static int root(int a)
	{

		// If current vertex is
		// the topmost vertex
		if (a == parent[a])
		{
			return a;
		}

		// Otherwise, set topmost vertex of
		// its parent as its topmost vertex
		return parent[a] = root(parent[a]);
	}

	// Function to connect the component
	// having vertex a with the component
	// having vertex b
	static void connect(int a, int b)
	{

		// Connect edges
		a = root(a);
		b = root(b);

		if (a != b) {
			parent[b] = a;
		}
	}

	// Function to find unique top most parents
	static void connectedComponents(int n)
	{
		HashSet<Integer> s = new HashSet<Integer>();

		// Traverse all vertices
		for (int i = 0; i < n; i++)
		{
     	s.add(parent[i]);
		}
		System.out.println(s.size());
	}
	static void printAnswer(int N,int [][] edges)
	{
		for (int i = 0; i <= N; i++)
		{
			parent[i] = i;
		}
		for (int i = 0; i < edges.length; i++)
		{
			connect(edges[i][0], edges[i][1]);
		}

		// Print answer
		connectedComponents(N);
	}

	// Driver Code
	public static void main(String[] args)
	{

		// Given N
		int N = 8;

		// Given edges
	int [][]edges = {{ 1, 0 }, { 0, 2 },
						{ 5, 3 }, { 3, 4 },
						{ 6, 7 }};

		// Function call
		printAnswer(N, edges);
	}
	}