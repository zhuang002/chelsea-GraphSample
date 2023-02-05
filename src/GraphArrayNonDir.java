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

	public void goThroughBFS() {
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

	public void goThroughDFS() {
		// TODO Auto-generated method stub
		boolean[] included = new boolean[this.ar.length];
		for (int i=0;i<included.length;i++) {
			included[i] = false;
		}
		
		dfsFrom(0, included);
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
}
