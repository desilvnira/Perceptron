import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Perceptron {
	
	
	public static void main(String[] args) throws IOException {
		
		File imageFile = new File(args[0]);

			List<Image> imgs = Perceptron.getImages(imageFile);
			//System.out.println(imgs.size());

		
		for (Image i : imgs) {
			System.out.println();
			for (int yPos = 0; yPos < 10; yPos++) {
				for (int xPos = 0; xPos < 10; xPos++) {
					System.out.print("|" + i.vals[xPos][yPos]);
				}
				System.out.print("|");
				System.out.println();

			}
		}
		
		List<Feature> features = Perceptron.getFeatures();
		
		for(Image i: imgs) {
			i.prePorcessing(features); // Each image is now represented by an array of feature values
			for(Integer in: i.values) {
				System.out.print(in + ", ");
			}
			System.out.println();
		}
		

	}

	public static List<Feature> getFeatures() {

		List<Feature> coordsSet = new ArrayList<Feature>();
		
		for (int i = 0; i < 50; i++) {
			Set<Coordinate> coords = new HashSet<Coordinate>();
			for (int j = 0; j < 4; j++) {
				int max = 9;
				int min = 0;
				
				Random rd = new Random();
				int x = rd.nextInt(max - min + 1) + min;
				Random rd2 = new Random();
				int y = rd2.nextInt(max - min + 1) + min;
				Random rd3 = new Random();
				int randBool = rd3.nextInt(1 - 0 + 1) + 0;
				
				boolean tempBool;
				if(randBool == 0) {
					tempBool = false;
				}else {
					tempBool = true;
				}
				
				System.out.println("X Value: " + x + " Y Value: " + y + " Random Boolean Value: " + tempBool);
				
				coords.add(new Coordinate(x, y, tempBool));
			}
			
			
			
			coordsSet.add(new Feature(coords));
			
		}
		
		
		return coordsSet;

	}
	
	public static List<Image> getImages(File images) throws IOException {
		
		List<Image> fileImages  = new ArrayList<Image>();

		BufferedReader b = new BufferedReader((new FileReader(images)));

		int imagePos = 0;
		while (imagePos < 100) {
			b.readLine();
			b.readLine();
			b.readLine();

			Image img = new Image();
			for (int yPos = 0; yPos < 10; yPos++) {
				for (int xPos = 0; xPos < 10; xPos++) {
					int value = b.read();
					if (value != 10) { // ascii value 10 stands for line feed
						img.vals[xPos][yPos] = Character.getNumericValue(value);
						//System.out.println(xPos + " " + xPos + " " + Character.getNumericValue(value));
					}else {
						//System.out.println(yPos*10+xPos + " " + value);
						int value2 = b.read();
						img.vals[xPos][yPos] = Character.getNumericValue(value2);

					}
				}
			}
			fileImages.add(img);
			b.readLine();
			imagePos++;

		}

		return fileImages;

	}

}
