
import java.util.*;

//------------------------------------------------------
public class GraphTester {
	// ------- main --------------
	public static void main(String[] args) {
		// build graph
		MinimumSpanningTree<String> graph = new MinimumSpanningTree<String>();
		graph.addEdge("a", "b", 2);
		graph.addEdge("b", "c", 3);
		graph.addEdge("c", "a", 1);


		/*
		graph.addEdge("a", "c", 10);
		graph.addEdge("c", "a", 10);
		graph.addEdge("a", "d", 7);
		graph.addEdge("d", "a", 7);
		graph.addEdge("c", "d", 9);
		graph.addEdge("d", "c", 9);
		graph.addEdge("d", "e", 23);
		graph.addEdge("e", "d", 23);
		graph.addEdge("d", "b", 32);
		graph.addEdge("b", "d", 32);
		*/
		System.out.println("Graph Adjacency List");
		graph.showAdjTable();

		System.out.println("Minimum Spanning Tree");
		System.out.println("------------------------");
		ArrayList<Edge<String>> results = graph.applyPrim();
		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
		}
	}

}
