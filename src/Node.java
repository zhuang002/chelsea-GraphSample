import java.util.ArrayList;

public class Node {
	int id;
	ArrayList<Node> nextNodes = new ArrayList<>();
	
	public Node(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	
	public ArrayList<Node> getNextNodes() {
		return nextNodes;
	}
	
}
