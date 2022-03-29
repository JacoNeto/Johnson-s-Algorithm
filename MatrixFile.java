import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixFile {
	public static int[][] Read() throws FileNotFoundException {
		Scanner sc = new Scanner(new BufferedReader(new FileReader("src/assets/adjacente_original.txt")));

		int rows = 1;
		int columns = 0;

		columns = sc.nextLine().split(" ").length;
		while (sc.hasNextLine()) {
			sc.nextLine();
			rows++;
		}

		int[][] myArray = new int[rows][columns];

		sc.close();
		sc = new Scanner(new BufferedReader(new FileReader("src/assets/adjacente_original.txt")));

		while (sc.hasNextLine()) {
			for (int i = 0; i < myArray.length; i++) {
				String[] line = sc.nextLine().trim().split(" ");
				for (int j = 0; j < line.length; j++) {
					myArray[i][j] = Integer.parseInt(line[j]);
				}
			}
		}
		System.out.println(Arrays.deepToString(myArray));
		return myArray;
	}
	
	public static void Write(String str) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/assets/adjacente_resultante.txt"));
	    writer.write(str);
	    
	    writer.close();
	}

}
