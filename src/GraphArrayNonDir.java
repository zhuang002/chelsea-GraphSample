import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class GraphArrayNonDir {
	int[][] ar = null;

	public void load() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int nNodes = sc.nextInt();
		ar = new int[nNodes][nNodes];
		for (int i=0;i<nNodes;i++) {
			for (int j=0;j<nNodes;j++) {
				ar[i][j] = 0;
			}
		}
		
		int nPaths = sc.nextInt();
		for (int i=0;i<nPaths;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int length = sc.nextInt();
			ar[start][end] = length;
			ar[end][start] = length;
		}
		
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println(ar.length + " " + getPaths());
		for (int i=0;i<ar.length;i++) {
			for (int j=i+1;j<ar[0].length;j++) {
				int length = ar[i][j];
				if (length>0) {
					System.out.println(i+" "+j+" "+length);
				}
			}
		}
		
	}

	private int getPaths() {
		// TODO Auto-generated method stub
		int nPaths = 0;
		for (int i=0;i<ar.length;i++) {
			for (int j=i+1;j<ar[0].length;j++) {
				int length = ar[i][j];
				if (length>0) {
					nPaths++;
				}
			}
		}
		return nPaths;
	}

	public int goThroughBFS() {
		// TODO Auto-generated method stub

		boolean[] included = new boolean[this.ar.length];
		for (int i=0;i<included.length;i++) {
			included[i] = false;
		}
		
		ArrayList<Integer> current = new ArrayList<>();
		ArrayList<Integer> next = new ArrayList<>();
		
		current.add(0);
		included[0] = true;
		System.out.print(0+" ");
		
		while (!current.isEmpty()) {
			for (int id: current) {
				ArrayList<Integer> neighbours = getNeighboursBFS(id, included);
				next.addAll(neighbours);
				
			}
			current = next;
			next = new ArrayList<>();
		}
		
		int count = 0;
		for (int i=0;i<included.length;i++) {
			if (included[i])
				count ++;
		}
		return count;
	}

	private ArrayList<Integer> getNeighboursBFS(int id, boolean[] included) {
		// TODO Auto-generated method stub
		ArrayList<Integer> neighbours = new ArrayList<>();
		for (int connectedId=0;connectedId<this.ar.length;connectedId++) {
			if (!included[connectedId] && this.ar[id][connectedId]>0) {
				neighbours.add(connectedId);
				included[connectedId] = true;
				System.out.print(connectedId+" ");
			}
		}
		return neighbours;
	}

	public int goThroughDFS() {
		// TODO Auto-generated method stub
		boolean[] included = new boolean[this.ar.length];
		for (int i=0;i<included.length;i++) {
			included[i] = false;
		}
		
		dfsFrom(0, included);
		
		int count = 0;
		for (int i=0;i<included.length;i++) {
			if (included[i])
				count ++;
		}
		return count;
	}

	private void dfsFrom(int node, boolean[] included) {
		// TODO Auto-generated method stub
		System.out.print(node+" ");
		included[node] = true;
		ArrayList<Integer> neighbours = getNeighboursDFS(node, included);
		for (int neighbour : neighbours) {
			if (!included[neighbour])
				dfsFrom(neighbour, included);
		}
	}

	private ArrayList<Integer> getNeighboursDFS(int id, boolean[] included) {
		// TODO Auto-generated method stub
		ArrayList<Integer> neighbours = new ArrayList<>();
		for (int connectedId=0;connectedId<this.ar.length;connectedId++) {
			if (this.ar[id][connectedId]>0) {
				neighbours.add(connectedId);
			}
		}
		return neighbours;
	}

	public boolean isConnectedBFS() {
		// TODO Auto-generated method stub
		int count = this.goThroughBFS();
		if (count == this.ar.length) {
			return true;
		}
		return false;
	}

	public boolean isConnectedDFS() {
		// TODO Auto-generated method stub
		int count = this.goThroughDFS();
		if (count == this.ar.length) {
			return true;
		}
		return false;
	}

	public boolean hasRingBFS() {
		// TODO Auto-generated method stub
		boolean[] included = new boolean[this.ar.length];
		for (int i=0;i<included.length;i++) {
			included[i] = false;
		}
		
		ArrayList<Integer> current = new ArrayList<>();
		ArrayList<Integer> next = new ArrayList<>();
		
		current.add(0);
		included[0] = true;
		
		while (!current.isEmpty()) {
			for (int id:current) {
				for (int nextId=id+1;nextId<this.ar.length;nextId++) {
					if (included[nextId])
						return true;
					if (this.ar[id][nextId]>0) {
						next.add(nextId);
						included[nextId] = true;
					}
					
				}
			}
			current = next;
			next = new ArrayList<>();
		}
		return false;
	}

	public boolean hasRingDFS() {
		// TODO Auto-generated method stub
		boolean[] included = new boolean[this.ar.length];
		for (int i=0;i<included.length;i++) {
			included[i] = false;
		}

		return hasRingDFS(0, included);
	}

	private boolean hasRingDFS(int id, boolean[] included) {
		// TODO Auto-generated method stub
		if (included[id]) {
			return true;
		}
		included[id] = true;
		for (int nextId = id+1; nextId<this.ar.length;nextId++) {
			if (this.ar[id][nextId]>0) {
				if (hasRingDFS(nextId, included)) {
					return true;
				}
			}
		}
		return false;
	}
}
