package MatrizAdjacencia;

import javax.swing.JOptionPane;

public class Grafo {
    private final int[][] matrizAdj;
    private final int numVertices;

    public Grafo(int numVertices) {
        this.matrizAdj = new int[numVertices][numVertices];
        this.numVertices = numVertices;
    }

    public void adicionarAresta(int origem, int destino) {
        if (origem > 0 && destino > 0 && origem <= numVertices && destino <= numVertices) {
            matrizAdj[origem - 1][destino - 1]++;
            matrizAdj[destino - 1][origem - 1]++;
        } else {
            JOptionPane.showMessageDialog(null, "Vértices inválidos! Insira valores entre 1 e " + numVertices);
        }
    }

    public void removerAresta(int origem, int destino) {
        if (origem > 0 && destino > 0 && origem <= numVertices && destino <= numVertices) {
            if (matrizAdj[origem - 1][destino - 1] > 0) {
                matrizAdj[origem - 1][destino - 1]--;
                matrizAdj[destino - 1][origem - 1]--;
            } else {
                JOptionPane.showMessageDialog(null, "Não existe aresta entre esses vértices.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vértices inválidos! Insira valores entre 1 e " + numVertices);
        }
    }

    public int consultaGrau(int vertice) {
        if (vertice > 0 && vertice <= numVertices) {
            int grau = 0;
            for (int i = 0; i < numVertices; i++) {
                grau += matrizAdj[vertice - 1][i];
            }
            return grau;
        } else {
            JOptionPane.showMessageDialog(null, "Vértice inválido! Insira um valor entre 1 e " + numVertices);
            return -1;
        }
    }

    public void imprimirGrafo() {
        StringBuilder representacao = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                representacao.append(matrizAdj[i][j]).append(" ");
            }
            representacao.append("\n");
        }
        JOptionPane.showMessageDialog(null, "Matriz de Adjacência\n" + representacao);
    }

    public boolean grafoSimples() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j && matrizAdj[i][j] > 0 || matrizAdj[i][j] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isConectado() {
        boolean[] visitado = new boolean[numVertices];
        dfs(0, visitado);

        for (boolean b : visitado) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int vertice, boolean[] visitado) {
        visitado[vertice] = true;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdj[vertice][i] > 0 && !visitado[i]) {
                dfs(i, visitado);
            }
        }
    }

    public int contarVerticesIsolados() {
        int isolados = 0;
        for (int i = 0; i < numVertices; i++) {
            if (consultaGrau(i + 1) == 0) {
                isolados++;
            }
        }
        return isolados;
    }

    public String vizinhos(int vertice) {
        if (vertice > 0 && vertice <= numVertices) {
            StringBuilder vizinhos = new StringBuilder("Vizinhos do vértice " + vertice + ": ");
            boolean temVizinho = false;
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdj[vertice - 1][i] > 0) {
                    vizinhos.append(i + 1).append(" ");
                    temVizinho = true;
                }
            }
            if (!temVizinho) {
                return "O vértice " + vertice + " não possui vizinhos.";
            }
            return vizinhos.toString();
        } else {
            return "Vértice inválido! Insira um valor entre 1 e " + numVertices;
        }
    }
}
