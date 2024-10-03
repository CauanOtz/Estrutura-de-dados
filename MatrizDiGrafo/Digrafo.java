package MatrizDiGrafo;

import javax.swing.JOptionPane;

public class Digrafo {
    private int[][] matrizAdjacencia;
    private int vertices;

    public Digrafo(int vertices) {
        this.vertices = vertices;
        this.matrizAdjacencia = new int[vertices][vertices];
    }

    public void adicionarAresta(int origem, int destino) {
        matrizAdjacencia[origem][destino]++;
    }

    public void imprimirMatrizAdjacencia() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matriz de Adjacência:\n");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                sb.append(matrizAdjacencia[i][j] + " ");
            }
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public int grauEntrada(int vertice) {
        int grauEntrada = 0;
        for (int i = 0; i < vertices; i++) {
            grauEntrada += matrizAdjacencia[i][vertice];
        }
        return grauEntrada;
    }

    public int grauSaida(int vertice) {
        int grauSaida = 0;
        for (int i = 0; i < vertices; i++) {
            grauSaida += matrizAdjacencia[vertice][i];
        }
        return grauSaida;
    }

    public boolean ehDigrafoSimples() {
        for (int i = 0; i < vertices; i++) {
            if (matrizAdjacencia[i][i] > 0) {
                return false; // Existem laços, portanto não é um dígrafo simples
            }
        }
        return true;
    }

    public void vizinhosDoVertice(int vertice) {
        StringBuilder sb = new StringBuilder();
        sb.append("Vizinhos do vértice ").append(vertice).append(": ");
        for (int i = 0; i < vertices; i++) {
            if (matrizAdjacencia[vertice][i] > 0) {
                sb.append(i).append(" ");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void contarArestasParalelasELaços() {
        int paralelas = 0;
        int lacos = 0;
        StringBuilder sb = new StringBuilder("Arestas paralelas e laços:\n");
        
        for (int i = 0; i < vertices; i++) {
            if (matrizAdjacencia[i][i] > 0) {
                lacos++;
                sb.append("Laço no vértice: ").append(i).append("\n");
            }
            for (int j = 0; j < vertices; j++) {
                if (matrizAdjacencia[i][j] > 1) {
                    paralelas++;
                    sb.append("Arestas paralelas entre vértices: ").append(i).append(" -> ").append(j).append("\n");
                }
            }
        }
        
        sb.append("Total de laços: ").append(lacos).append("\n");
        sb.append("Total de arestas paralelas: ").append(paralelas);
        
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
