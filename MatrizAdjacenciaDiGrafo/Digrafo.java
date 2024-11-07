package MatrizAdjacenciaDiGrafo;

public class Digrafo {
    private int[][] matrizAdjacencia;
    private int numVertices;
    private int numArestas;

    public Digrafo(int numVertices) {
        this.numVertices = numVertices;
        matrizAdjacencia = new int[numVertices][numVertices];
    }

    public void adicionarAresta(int origem, int destino) {
        if (origem >= 1 && origem <= numVertices && destino >= 1 && destino <= numVertices) {
            matrizAdjacencia[origem - 1][destino - 1]++;
            numArestas++;
        } else {
            throw new IllegalArgumentException("Os vértices estão fora dos limites da matriz.");
        }
    }

    public String imprimirMatrizAdjacencia() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matriz de Adjacência:\n");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                sb.append(matrizAdjacencia[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int grauEntrada(int vertice) {
        int grauEntrada = 0;
        for (int i = 0; i < numVertices; i++) {
            grauEntrada += matrizAdjacencia[i][vertice - 1];  
        }
        return grauEntrada;
    }

    public int grauSaida(int vertice) {
        int grauSaida = 0;
        for (int i = 0; i < numVertices; i++) {
            grauSaida += matrizAdjacencia[vertice - 1][i];  
        }
        return grauSaida;
    }

    public boolean ehSimples() {
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdjacencia[i][i] > 0) {
                return false; 
            }
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdjacencia[i][j] > 1) {
                    return false; 
                }
            }
        }
        return true;
    }

    public String analisarVertice(int vertice) {
        StringBuilder sb = new StringBuilder();
        sb.append("Vértices vizinhos ao vértice " + vertice + ": ");
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdjacencia[vertice - 1][i] > 0) {
                sb.append((i + 1) + " ");
            }
        }
        return sb.toString();
    }

    public String contarArestasParalelasELaços() {
        int laços = 0;
        int arestasParalelas = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numVertices; i++) {
            if (matrizAdjacencia[i][i] > 0) {
                laços++;
                sb.append("Laço no vértice " + (i + 1) + "\n");
            }
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdjacencia[i][j] > 1) {
                    arestasParalelas += matrizAdjacencia[i][j] - 1;
                    sb.append("Arestas paralelas entre os vértices " + (i + 1) + " e " + (j + 1) + "\n");
                }
            }
        }

        sb.append("Quantidade de laços: " + laços + "\n");
        sb.append("Quantidade de arestas paralelas: " + arestasParalelas + "\n");

        return sb.toString();
    }
}
