import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		try {
			// lê matriz de custo do arquivo txt
			int[][] matrizCusto = MatrixFile.Read();
			// executa o algoritmo de Johnson 
			JohnsonAlgorithm.calc(matrizCusto);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
