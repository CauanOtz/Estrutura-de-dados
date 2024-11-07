package MatrizIncidenciaGrafo;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String opcoes = "Escolha uma opção:\n"
                + "1. Adicionar Aresta\n"
                + "2. Imprimir Matriz de Incidência\n"
                + "3. Determinar Grau de um Vértice\n"
                + "4. Ver Vértices Vizinhos\n"
                + "5. Contar Arestas Paralelas e Laços\n"
                + "6. Sair";
    
        int numVertices = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de vértices:"));
        int numArestas = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de arestas:"));
    
        MatrizIncidenciaGrafo grafo = new MatrizIncidenciaGrafo(numVertices, numArestas);
    
        while (true) {
            String escolha = JOptionPane.showInputDialog(opcoes);
            switch (escolha) {
                case "1":
                    int vertice1 = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice de origem:"));
                    int vertice2 = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice de destino:"));
                    grafo.adicionarAresta(vertice1, vertice2);
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, grafo.imprimirMatrizIncidencia());
                    break;
                case "3":
                    int verticeGrau = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice para calcular o grau:"));
                    JOptionPane.showMessageDialog(null, "Grau do vértice " + verticeGrau + ": " + grafo.grau(verticeGrau));
                    break;
                case "4":
                    int verticeVizinho = Integer.parseInt(JOptionPane.showInputDialog("Informe o vértice para ver os vizinhos:"));
                    JOptionPane.showMessageDialog(null, grafo.analisarVertice(verticeVizinho));
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, grafo.contarArestasParalelasELaços());
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}

