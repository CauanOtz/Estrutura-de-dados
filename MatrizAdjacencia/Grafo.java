import javax.swing.JOptionPane;

public class Grafo {
    private MatrizAdjacencia matriz;

    public Grafo(int numVertices) {
        matriz = new MatrizAdjacencia(numVertices);
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        matriz.adicionarAresta(origem, destino, peso);
    }

    public void removerAresta(int origem, int destino) {
        matriz.removerAresta(origem, destino);
    }

    public void imprimirGrafo() {
        String resultado = matriz.imprimirMatriz();
        JOptionPane.showMessageDialog(null, "Matriz de Adjacência:\n" + resultado);
    }

    public void listarVizinhos(int vertice) {
        String resultado = matriz.listarVizinhos(vertice);
        JOptionPane.showMessageDialog(null, resultado);
    }

    public void listarArestas() {
        String resultado = matriz.listarArestas();
        JOptionPane.showMessageDialog(null, resultado);
    }

    public static void main(String[] args) {
        String entrada = JOptionPane.showInputDialog("Informe o número de vértices:");
        int numVertices;
        try {
            numVertices = Integer.parseInt(entrada);
            Grafo grafo = new Grafo(numVertices);

            while (true) {
                String[] opcoes = {"Adicionar aresta", "Remover aresta", "Imprimir grafo", "Listar vizinhos", "Listar arestas", "Sair"};
                int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

                if (opcao == 5) {
                    break;
                }

                switch (opcao) {
                    case 0:
                        entrada = JOptionPane.showInputDialog("Origem:");
                        int origem = Integer.parseInt(entrada);
                        entrada = JOptionPane.showInputDialog("Destino:");
                        int destino = Integer.parseInt(entrada);
                        entrada = JOptionPane.showInputDialog("Peso:");
                        int peso = Integer.parseInt(entrada);
                        grafo.adicionarAresta(origem, destino, peso);
                        break;

                    case 1:
                        entrada = JOptionPane.showInputDialog("Origem:");
                        origem = Integer.parseInt(entrada);
                        entrada = JOptionPane.showInputDialog("Destino:");
                        destino = Integer.parseInt(entrada);
                        grafo.removerAresta(origem, destino);
                        break;

                    case 2:
                        grafo.imprimirGrafo();
                        break;

                    case 3:
                        entrada = JOptionPane.showInputDialog("Informe o vértice para listar os vizinhos:");
                        int vertice = Integer.parseInt(entrada);
                        grafo.listarVizinhos(vertice);
                        break;

                    case 4:
                        grafo.listarArestas();
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número válido.");
        }
    }
}
