package MatrizAdjacenciaDiGrafo;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int numVertices = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de vértices:"));
        Digrafo digrafo = new Digrafo(numVertices);

        boolean continuar = true;

        while (continuar) {
            String menu = """
                    Escolha uma opção:
                    1 - Adicionar Aresta
                    2 - Imprimir Matriz de Adjacência
                    3 - Verificar Grau de um Vértice
                    4 - Verificar se é Simples
                    5 - Listar Vértices Vizinhos
                    6 - Contar Arestas Paralelas e Laços
                    7 - Sair
                    """;
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1: 
                    int origem = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice de origem (1 a " + numVertices + "):"));
                    int destino = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice de destino (1 a " + numVertices + "):"));
                    try {
                        digrafo.adicionarAresta(origem, destino);
                        JOptionPane.showMessageDialog(null, "Aresta adicionada com sucesso!");
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2: 
                    JOptionPane.showMessageDialog(null, digrafo.imprimirMatrizAdjacencia(), "Matriz de Adjacência", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3: 
                    int vertice = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice para analisar o grau (1 a " + numVertices + "):"));
                    String grauInfo = "Grau de entrada: " + digrafo.grauEntrada(vertice) + "\nGrau de saída: " + digrafo.grauSaida(vertice);
                    JOptionPane.showMessageDialog(null, grauInfo, "Grau do Vértice", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4: 
                    String ehSimples = digrafo.ehSimples() ? "O dígrafo é simples." : "O dígrafo não é simples.";
                    JOptionPane.showMessageDialog(null, ehSimples, "Dígrafo Simples", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 5: 
                    vertice = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice para listar os vizinhos (1 a " + numVertices + "):"));
                    JOptionPane.showMessageDialog(null, digrafo.analisarVertice(vertice), "Vértices Vizinhos", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 6: 
                    JOptionPane.showMessageDialog(null, digrafo.contarArestasParalelasELaços(), "Arestas Paralelas e Laços", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 7: 
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
