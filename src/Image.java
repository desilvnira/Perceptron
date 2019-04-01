import java.util.ArrayList;
import java.util.List;

public class Image {
	
	int[][] vals;
	List<Integer> values;
	
	public Image() {
		this.vals = new int[10][10];
		values = new ArrayList<Integer>();
	}
	
	public void prePorcessing(List<Feature> feats) {
		
		for(Feature f: feats) {
			values.add(valueOfFeature(f));
		}
		
	}
	
	public int valueOfFeature(Feature f) {
		int sum = 0;
		for(Coordinate c: f.coords) {
			if(this.vals[c.x][c.y] == 1 && c.randBool == true) {
				sum++;
			}
			if(this.vals[c.x][c.y] == 0 && c.randBool == false) {
				sum++;
			}
		}
		return (sum>=3)?1:0;

	}

}
