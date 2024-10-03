package MatrizDiGrafo;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int vertices = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de vértices:"));
        Digrafo digrafo = new Digrafo(vertices);

        String menu = "Escolha uma opção:\n" +
                      "1. Adicionar aresta\n" +
                      "2. Imprimir matriz de adjacência\n" +
                      "3. Ver grau de entrada e saída de um vértice\n" +
                      "4. Ver vizinhos de um vértice\n" +
                      "5. Contar laços e arestas paralelas\n" +
                      "6. Verificar se é dígrafo simples\n" +
                      "7. Sair";

        boolean rodando = true;
        while (rodando) {
            String opcao = JOptionPane.showInputDialog(menu);
            switch (opcao) {
                case "1":
                    int origem = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice de origem da aresta:"));
                    int destino = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice de destino da aresta:"));
                    digrafo.adicionarAresta(origem, destino);
                    break;

                case "2":
                    digrafo.imprimirMatrizAdjacencia();
                    break;

                case "3":
                    int verticeGrau = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice para verificar grau de entrada e saída:"));
                    JOptionPane.showMessageDialog(null, "Grau de Entrada: " + digrafo.grauEntrada(verticeGrau) +
                            "\nGrau de Saída: " + digrafo.grauSaida(verticeGrau));
                    break;

                case "4":
                    int verticeVizinhos = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice para verificar vizinhos:"));
                    digrafo.vizinhosDoVertice(verticeVizinhos);
                    break;

                case "5":
                    digrafo.contarArestasParalelasELaços();
                    break;

                case "6":
                    boolean digrafoSimples = digrafo.ehDigrafoSimples();
                    JOptionPane.showMessageDialog(null, "O dígrafo é simples? " + (digrafoSimples ? "Sim" : "Não"));
                    break;

                case "7":
                    rodando = false;
                    JOptionPane.showMessageDialog(null, "Encerrando o programa.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
            }
        }
    }
}
