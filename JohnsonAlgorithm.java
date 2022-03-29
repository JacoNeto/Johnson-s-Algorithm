import java.io.IOException;

public class JohnsonAlgorithm {

	// procedimento de calculo do algoritmo
	public static void calc(int[][] matrizCusto) {
		int vertices;
		int arestas;
		
		String str = "";

		int[][] matrizAdjacente;
		
		vertices = matrizCusto[0].length;
		arestas = matrizCusto.length;
		
		matrizAdjacente = new int[vertices][vertices];

		for (int k = 0; k < arestas; k++) {
			matrizAdjacente[matrizCusto[k][0] - 1][matrizCusto[k][1] - 1] = matrizCusto[k][2];
		}

		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				// Se não há aresta, usa valor maximo
				if (matrizAdjacente[i][j] == 0 && i != j) {
					matrizAdjacente[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				for (int k = 0; k < vertices; k++) {
					// Obtem caminho minimo de j e k atraves de i
					matrizAdjacente[j][k] = Utils.valorMinimo(matrizAdjacente[j][k],
							matrizAdjacente[j][i] + matrizAdjacente[i][k]);
				}
			}
		}

		str += "Matriz Adjacente resultante\n\n";

		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (matrizAdjacente[i][j] != Integer.MAX_VALUE) {
					str += matrizAdjacente[i][j] + " ";
				}
			}
			str += "\n";
		}
		
		try {
			MatrixFile.Write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
