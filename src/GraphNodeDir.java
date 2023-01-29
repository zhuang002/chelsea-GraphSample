import java.util.Scanner;

public class GraphNodeDir {
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
		}
		
		
	}
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(nodes.length+" "+getPaths());
		for (Node startNode:this.nodes) {
			for (Node endNode:startNode.getNextNodes()) {
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
		return nPaths;
	}
}
