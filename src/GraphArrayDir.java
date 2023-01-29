import java.util.Scanner;

public class GraphArrayDir  {
	int[][] ar;

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
		}
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println(ar.length + " " + getPaths());
		for (int i=0;i<ar.length;i++) {
			for (int j=0;j<ar[0].length;j++) {
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
			for (int j=0;j<ar[0].length;j++) {
				int length = ar[i][j];
				if (length>0) {
					nPaths++;
				}
			}
		}
		return nPaths;
	}
	
	
}
