import java.util.ArrayList;
import java.util.Scanner;

// the class to save paths.
public class GraphDir1 {
	int nNodes;
	ArrayList<Path> paths = new ArrayList<>();
	public void load() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		this.nNodes = sc.nextInt();
		
		int nPaths = sc.nextInt();
		for (int i=0;i<nPaths;i++) {
			paths.add(new Path(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		sc.close();
	}
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(nNodes+" "+paths.size());
		for (Path path:paths) {
			System.out.println(path);
		}
	}
	
	
}
