import java.io.IOException;

public class JohnsonAlgorithm {

	// procedimento de calculo do algoritmo
	public static void calc(int[][] matrizCusto) {

		int vertices = 0; // numero de vertices da matriz de custo
		int arestas = 0; // numero de arestas da matriz de custo

		String str = ""; // saida do programa
		String straux = ""; // saida auxiliar do programa

		int[][] matrizAdjacente = matrizCusto;

		arestas = matrizCusto.length;
		
		// obtém o número de vértices
		for (int i = 0; i < arestas; i++) {
			vertices = Utils.valorMaximo(matrizCusto[i][0], vertices);
		}
		for (int i = 0; i < arestas; i++) {
			vertices = Utils.valorMaximo(matrizCusto[i][1], vertices);
		}
		
		// cria matriz aux adicionando vertice auxiliar q
		int auxArestas = arestas + vertices;
		int[][] matrizAux = new int[auxArestas][3];
		for (int i = 0; i < arestas; i++) {
			for (int j = 0; j < 3; j++) {
				matrizAux[i][j] = matrizCusto[i][j];
			}
		}
		for (int i = 0; i < vertices; i++) {
			matrizAux[arestas + i][0] = 0;
			matrizAux[arestas + i][1] = i + 1;
			matrizAux[arestas + i][2] = 0;
		}
		
		// calcula os caminhos baseados em q
		int[] distOrigem = Bellman.calc(matrizAux, vertices + 1, auxArestas, vertices);
		
		for(int i = 0; i < distOrigem.length; i++) {
			System.out.print(distOrigem[i] + " ");
		}
		
		for(int i = 0; i < arestas; i ++) {
				matrizAdjacente[i][2] = matrizAdjacente[i][2] + distOrigem[matrizAdjacente[i][0]] - distOrigem[matrizAdjacente[i][1]];  
		}
		
		// a matriz adjacente é uma matriz quadrática com o número de vértices
		// da matriz de custo

		// matrizAdjacente = new int[vertices][vertices];
		/*matrizAdjacente = Bellman.calc(matrizCusto, vertices, arestas, 0);

		// preenche a matriz adjacente com os valores da matriz de custo
		for (int k = 0; k < arestas; k++) {
			matrizAdjacente[matrizCusto[k][0] - 1][matrizCusto[k][1] - 1] = matrizCusto[k][2];
		}

		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				// Se não há aresta, usa valor maximo/infinito
				if (matrizAdjacente[i][j] == 0 && i != j) {
					System.out.println("slmfnfdkjjgn " + i + " " + j);
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
		*/
		str += "Matriz Adjacente resultante\n\n";

		for (int i = 0; i < arestas; i++) {
			for (int j = 0; j < 3; j++) {
				if (matrizAdjacente[i][j] != Integer.MAX_VALUE) {
					str += matrizAdjacente[i][j] + " ";
				}
			}
			str += "\n";
		}

		try {
			MatrixFile.Write(str, "src/assets/adjacente_resultante.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < auxArestas; i++) {
			for (int j = 0; j < 3; j++) {
				if (matrizAux[i][j] != Integer.MAX_VALUE) {
					straux += matrizAux[i][j] + " ";
				}
			}
			straux += "\n";
		}
		
		try {
			MatrixFile.Write(straux, "src/assets/adjacente_aux.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
