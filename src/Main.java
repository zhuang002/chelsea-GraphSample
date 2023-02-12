
public class Main {

	public static void main(String[] args) {
		// data structures
		
		/*GraphDir1 graph = new GraphDir1();
		graph.load();
		graph.print();*/
		
		/*GraphArrayNonDir graph1 = new GraphArrayNonDir();
		graph1.load();
		graph1.print();*/
		
		/*GraphArrayDir graph2 = new GraphArrayDir();
		graph2.load();
		graph2.print();*/
		
		/*GraphNodeDir graph2 = new GraphNodeDir();
		graph2.load();
		graph2.print();*/
		
		/*GraphNodeNonDir graph2 = new GraphNodeNonDir();
		graph2.load();
		graph2.print();*/
		
		// Go through all nodes from one node.
		/*GraphArrayNonDir graph1 = new GraphArrayNonDir();
		graph1.load();
		graph1.goThroughBFS();
		System.out.println();
		graph1.goThroughDFS();*/
		
		/*GraphNodeNonDir graph1 = new GraphNodeNonDir();
		graph1.load();
		graph1.goThroughBFS();
		System.out.println();
		graph1.goThroughDFS();*/
		
		/*GraphArrayNonDir graph1 = new GraphArrayNonDir();
		graph1.load();
		System.out.println(graph1.isConnectedBFS());
		System.out.println(graph1.isConnectedDFS());*/
		
		/*GraphNodeNonDir graph1 = new GraphNodeNonDir();
		graph1.load();
		System.out.println(graph1.isConnectedBFS());
		System.out.println(graph1.isConnectedDFS());*/
		
		/*GraphArrayNonDir graph1 = new GraphArrayNonDir();
		graph1.load();
		System.out.println(graph1.hasRingBFS());
		System.out.println(graph1.hasRingDFS());*/
		
		GraphNodeNonDir graph2 = new GraphNodeNonDir();
		graph2.load();
		System.out.println(graph2.hasRingBFS());
		System.out.println(graph2.hasRingDFS());
	}

}
