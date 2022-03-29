import java.io.IOException;

public class JohnsonAlgorithm {

	// procedimento de calculo do algoritmo
	public static void calc(int[][] matrizCusto) {
		
		int vertices; // numero de vertices da matriz de custo
		int arestas; // numero de arestas da matriz de custo
		
		String str = ""; // saida do programa

		int[][] matrizAdjacente;
		
		vertices = matrizCusto[0].length;
		arestas = matrizCusto.length;
		
		// a matriz adjacente é uma matriz quadrática com o número de vértices
		// da matriz de custo
		matrizAdjacente = new int[vertices][vertices]; 
		
		// preenche a matriz adjacente com os valores da matriz de custo
		for (int k = 0; k < arestas; k++) {
			matrizAdjacente[matrizCusto[k][0] - 1][matrizCusto[k][1] - 1] = matrizCusto[k][2];
		}
		
		
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				// Se não há aresta, usa valor maximo/infinito
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
