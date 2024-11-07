package MatrizIncidenciaGrafoComLeitura;

import javax.swing.JOptionPane;
import java.io.*;

public class MatrizIncidenciaGrafo {
    private int[][] matrizIncidencia;
    private int numVertices;
    private int numArestas;
    private int[][] arestas;
    private int arestaAtual;

    public MatrizIncidenciaGrafo(int numVertices, int numArestas) {
        this.numVertices = numVertices;
        this.numArestas = numArestas;
        this.matrizIncidencia = new int[numVertices][numArestas];
        this.arestas = new int[numArestas][2]; // Guardando origem e destino de cada aresta
        this.arestaAtual = 0;
    }

    public void adicionarAresta(int vertice1, int vertice2) {
        if (vertice1 > 0 && vertice1 <= numVertices && vertice2 > 0 && vertice2 <= numVertices) {
            if (arestaAtual < numArestas) {
                matrizIncidencia[vertice1 - 1][arestaAtual] = 1;
                matrizIncidencia[vertice2 - 1][arestaAtual] = (vertice1 != vertice2) ? 1 : 2;
                arestas[arestaAtual][0] = vertice1;
                arestas[arestaAtual][1] = vertice2;
                arestaAtual++;
            } else {
                JOptionPane.showMessageDialog(null, "Número máximo de arestas atingido!");
            }
        } else {
            throw new IllegalArgumentException("Vértices fora dos limites!");
        }
    }

    public String imprimirMatrizIncidencia() {
        StringBuilder sb = new StringBuilder("Matriz de Incidência:\n");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numArestas; j++) {
                sb.append(matrizIncidencia[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int grau(int vertice) {
        int grau = 0;
        for (int i = 0; i < numArestas; i++) {
            if (matrizIncidencia[vertice - 1][i] > 0) {
                grau += matrizIncidencia[vertice - 1][i];
            }
        }
        return grau;
    }

    public String analisarVertice(int vertice) {
        StringBuilder sb = new StringBuilder("Vértices vizinhos de " + vertice + ": ");
        for (int i = 0; i < numArestas; i++) {
            if (arestas[i][0] == vertice) {
                sb.append(arestas[i][1]).append(" ");
            } else if (arestas[i][1] == vertice) {
                sb.append(arestas[i][0]).append(" ");
            }
        }
        return sb.toString();
    }

    public String contarArestasParalelasELaços() {
        int laços = 0;
        int arestasParalelas = 0;
        for (int i = 0; i < numArestas; i++) {
            if (arestas[i][0] == arestas[i][1]) {
                laços++;
            }
            for (int j = i + 1; j < numArestas; j++) {
                if ((arestas[i][0] == arestas[j][0] && arestas[i][1] == arestas[j][1]) ||
                    (arestas[i][0] == arestas[j][1] && arestas[i][1] == arestas[j][0])) {
                    arestasParalelas++;
                }
            }
        }
        return "Quantidade de laços: " + laços + "\nQuantidade de arestas paralelas: " + arestasParalelas;
    }

    public void salvarEmArquivo(String nomeArquivo) {
        try (PrintWriter gravarArq = new PrintWriter(new FileWriter(nomeArquivo))) {
            gravarArq.println(numVertices);
            gravarArq.println(numArestas);
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numArestas; j++) {
                    gravarArq.print(matrizIncidencia[i][j] + " ");
                }
                gravarArq.println();
            }
            JOptionPane.showMessageDialog(null, "Matriz de incidência salva com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public void carregarDeArquivo(String nomeArquivo) {
        try (BufferedReader lerArq = new BufferedReader(new FileReader(nomeArquivo))) {
            numVertices = Integer.parseInt(lerArq.readLine());
            numArestas = Integer.parseInt(lerArq.readLine());
            matrizIncidencia = new int[numVertices][numArestas];
            arestas = new int[numArestas][2];
            for (int i = 0; i < numVertices; i++) {
                String[] valores = lerArq.readLine().split(" ");
                for (int j = 0; j < numArestas; j++) {
                    matrizIncidencia[i][j] = Integer.parseInt(valores[j]);
                }
            }
            JOptionPane.showMessageDialog(null, "Matriz de incidência carregada com sucesso de " + nomeArquivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo: " + e.getMessage());
        }
    }
}
