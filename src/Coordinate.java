
public class Coordinate {
	
	int x;
	int y;
	boolean randBool;

	public Coordinate(int x, int y, boolean randBool) {
		
		this.x = x;
		this.y = y;
		this.randBool = randBool;
		
	}
	
	public String toString2() {
		return "X Value: " + x + "Y Value: " + y + "Random Boolean Value: " + randBool;
	}
	
}
