import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class GraphNodeNonDir {
	Node[] nodes;

	public void load() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int nNodes = sc.nextInt();
		this.nodes = new Node[nNodes];
		for (int i=0;i<nNodes;i++) {
			this.nodes[i] = new Node(i);
		}
		
		int nPaths = sc.nextInt();
		
		for (int i=0;i<nPaths;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			this.nodes[start].getNextNodes().add(this.nodes[end]); 
			this.nodes[end].getNextNodes().add(this.nodes[start]); 
		}
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println(nodes.length+" "+getPaths());
		for (Node startNode:this.nodes) {
			for (Node endNode:startNode.getNextNodes()) {
				if (endNode.id > startNode.id)
					System.out.println(startNode.getId()+" "+endNode.getId());
			}
		}
		
	}
	
	private int getPaths() {
		// TODO Auto-generated method stub
		int nPaths = 0;
		for (Node startNode:this.nodes) {
			nPaths += startNode.getNextNodes().size();
		}
		return nPaths/2;
	}

	public void goThroughBFS() {
		// TODO Auto-generated method stub
		boolean[] included = new boolean[this.nodes.length];
		for (int i=0;i<included.length;i++) {
			included[i] = false;
		}
		
		ArrayList<Node> current = new ArrayList<>();
		ArrayList<Node> next = new ArrayList<>();
		
		current.add(this.nodes[0]);
		included[0] = true;
		System.out.print(0+" ");
		
		while (!current.isEmpty()) {
			for (Node node:current) {
				next.addAll(getNeighboursBFS(node, included));
			}
			current = next;
			next = new ArrayList<>();
		}
		
	}

	private ArrayList<Node> getNeighboursBFS(Node node, boolean[] included) {
		// TODO Auto-generated method stub
		ArrayList<Node> neighbours = new ArrayList<>();
		for (Node n:node.nextNodes) {
			if (!included[n.id]) {
				neighbours.add(n);
				included[n.id] = true;
				System.out.print(n.id+" ");
			}
		}
		return neighbours;
	}

	public void goThroughDFS() {
		// TODO Auto-generated method stub
		boolean[] included = new boolean[this.nodes.length];
		for (int i=0;i<included.length;i++) {
			included[i] = false;
		}
		
		dfsFrom(this.nodes[0], included);
	}

	private void dfsFrom(Node node, boolean[] included) {
		// TODO Auto-generated method stub
		if (included[node.id]) 
			return;
		
		System.out.print(node.id+" ");
		included[node.id] = true;
		
		for (Node n:node.nextNodes) {
			dfsFrom(n,included);
		}
	}
	
	
}
