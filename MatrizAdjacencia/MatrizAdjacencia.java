import javax.swing.JOptionPane;

public class MatrizAdjacencia {
    private int[][] matriz;
    private int numVertices;

    public MatrizAdjacencia(int numVertices) {
        this.numVertices = numVertices;
        matriz = new int[numVertices][numVertices];
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        if (origem >= 0 && origem < numVertices && destino >= 0 && destino < numVertices) {
            matriz[origem][destino] = peso;
        } else {
            JOptionPane.showMessageDialog(null, "Vértice inválido.");
        }
    }

    public void removerAresta(int origem, int destino) {
        if (origem >= 0 && origem < numVertices && destino >= 0 && destino < numVertices) {
            matriz[origem][destino] = 0;
        } else {
            JOptionPane.showMessageDialog(null, "Vértice inválido.");
        }
    }

    public String imprimirMatriz() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                sb.append(matriz[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getPeso(int origem, int destino) {
        return matriz[origem][destino];
    }

    public int getNumVertices() {
        return numVertices;
    }

    public String listarVizinhos(int vertice) {
        if (vertice < 0 || vertice >= numVertices) {
            return "Vértice inválido.";
        }
        StringBuilder sb = new StringBuilder("Vizinhos do vértice " + vertice + ": ");
        for (int i = 0; i < numVertices; i++) {
            if (matriz[vertice][i] > 0) {
                sb.append(i).append(" (Peso: ").append(matriz[vertice][i]).append(") ");
            }
        }
        return sb.toString();
    }

    public String listarArestas() {
        StringBuilder sb = new StringBuilder("Arestas do grafo:\n");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matriz[i][j] > 0) {
                    sb.append("Origem: ").append(i)
                      .append(", Destino: ").append(j)
                      .append(", Peso: ").append(matriz[i][j]).append("\n");
                }
            }
        }
        return sb.toString();
    }
}
