
public class Path {
	int start;
	int end;
	int length;
	
	public Path(int start, int end, int length) {
		this.start = start;
		this.end = end;
		this.length = length;
	}

	@Override
	public String toString() {
		return start + " " + end +" " +length;
	}
	
	
}
