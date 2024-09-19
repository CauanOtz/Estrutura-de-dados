package MatrizAdjacencia;

import javax.swing.JOptionPane;

public class MatrizAdjacencia {

    public static void main(String[] args) {
        int qtdeVertices = lerInteiro("Informe a quantidade de vértices do grafo:", 1, Integer.MAX_VALUE);
        Grafo g = new Grafo(qtdeVertices);

        int op;
        do {
            op = lerInteiro("1 - Adicionar aresta\n" +
                            "2 - Remover aresta\n" +
                            "3 - Consultar número de vértices isolados\n" +
                            "4 - Imprimir matriz de adjacência\n" +
                            "5 - Consultar grau de um vértice\n" +
                            "6 - Verificar se o grafo é simples ou multigrafo\n" +
                            "7 - Verificar se o grafo é conexo\n" +
                            "8 - Contar vértices isolados\n" +
                            "9 - Consultar vizinhos de um vértice\n" +
                            "10 - Sair\n" +
                            "Informe a opção desejada:", 1, 10);

            switch (op) {
                case 1 -> {
                    int vOrigem = lerInteiro("Informe o vértice de origem:", 1, qtdeVertices);
                    int vDestino = lerInteiro("Informe o vértice de destino:", 1, qtdeVertices);
                    g.adicionarAresta(vOrigem, vDestino);
                }
                case 2 -> {
                    int vOrigem = lerInteiro("Informe o vértice de origem:", 1, qtdeVertices);
                    int vDestino = lerInteiro("Informe o vértice de destino:", 1, qtdeVertices);
                    g.removerAresta(vOrigem, vDestino);
                }
                case 3 -> JOptionPane.showMessageDialog(null, "O grafo possui " + g.contarVerticesIsolados() + " vértice(s) isolado(s).");
                case 4 -> g.imprimirGrafo();
                case 5 -> {
                    int vertice = lerInteiro("Informe o vértice para consultar o grau:", 1, qtdeVertices);
                    int grau = g.consultaGrau(vertice);
                    if (grau != -1) {
                        JOptionPane.showMessageDialog(null, "O grau do vértice informado é: " + grau);
                    }
                }
                case 6 -> {
                    if (g.grafoSimples()) {
                        JOptionPane.showMessageDialog(null, "O grafo é simples (sem laços ou arestas paralelas).");
                    } else {
                        JOptionPane.showMessageDialog(null, "O grafo é multigrafo (contém laços e/ou arestas paralelas).");
                    }
                }
                case 7 -> {
                    if (g.isConectado()) {
                        JOptionPane.showMessageDialog(null, "O grafo é conexo.");
                    } else {
                        JOptionPane.showMessageDialog(null, "O grafo não é conexo.");
                    }
                }
                case 8 -> {
                    int isolados = g.contarVerticesIsolados();
                    JOptionPane.showMessageDialog(null, "O grafo possui " + isolados + " vértice(s) isolado(s).");
                }
                case 9 -> {
                    int vertice = lerInteiro("Informe o vértice para consultar os vizinhos:", 1, qtdeVertices);
                    String vizinhos = g.vizinhos(vertice);
                    JOptionPane.showMessageDialog(null, vizinhos);
                }
                case 10 -> JOptionPane.showMessageDialog(null, "Saindo...");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (op != 10);
    }

    private static int lerInteiro(String mensagem, int minimo, int maximo) {
        while (true) {
            try {
                int valor = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
                if (valor < minimo || valor > maximo) {
                    throw new IllegalArgumentException("O valor deve estar entre " + minimo + " e " + maximo);
                }
                return valor;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}