
package staudt.julian.graph.main;

/**
 * Einsendeaufgabe 3.1 spezieller ungerichteter Graph zur Darstellung der
 * Landesgrenzen Laendername wird in dem String-Array nodes gespeichert In der
 * adjacencyMatrix steht an [land1][land2] der Wert true, wenn die Laender eine
 * gemeinsame Grenze haben, andernfalls false
 *
 * @author Fernuniversitaet in Hagen
 * @author Julian Staudt 
 *
 * @version 3.2
 */
class GraphException extends Exception {
}

public class Graph {

    protected boolean[][] adjacencyMatrix;
    protected String[] nodes;

    protected int indexOf(String node) throws GraphException {
        for (int i = 0; i < nodes.length; i++) {
            if (node.equals(nodes[i])) {
                return i;
            }
        }
        throw new GraphException();
    }

    public Graph(int nodeNumber) {
        nodes = new String[nodeNumber];
        adjacencyMatrix = new boolean[nodeNumber][nodeNumber];
    }

    public Graph(String[] nodes) {
        this(nodes.length);
        for (int i = 0; i < nodes.length; i++) {
            this.nodes[i] = nodes[i];
        }
    }

    /**
     * Gibt den Namen des Landes in nodes[index] zurueck
     *
     * @param index
     * @return nodes[index]
     * @throws GraphException
     */
    public String getNode(int index) throws GraphException {
        if (index < this.getNumberOfNodes()) {
            return nodes[index];
        } else {
            throw new GraphException();
        }
    }

    /**
     * Gibt die Laenge des String-Arrays nodes zurueck
     *
     * @return
     */
    public int getNumberOfNodes() {
        return this.nodes.length;
    }

    /**
     * weist den ersten k Elementen des Attributs nodes die entsprechenden Werte
     * des Parameters nodes zu
     *
     * @param nodes
     */
    public void setNodes(String[] nodes) {
        for (int k = 0; k < nodes.length; k++) {
            this.nodes[i] = nodes[i];
        }
    }

    /**
     * prueft, ob die Knoten mit dem Index index1 und index2 benachbart sind
     * gibt, wenn benachbart 'true', andernfalls 'false' zurueck
     *
     * @param index1
     * @param index2
     * @return this.adjacencyMatrix[index1][index2]
     * @throws GraphException
     */
    public boolean isAdjacent(int index1, int index2) throws GraphException {
        if (index1 <= this.getNumberOfNodes() && index2 <= this.getNumberOfNodes()) {
            return (this.adjacencyMatrix[index1][index2]);
        } else {
            throw new GraphException();
        }

    }

    /**
     * prueft, ob gegebene Laender mit Namen node1 und node2 benachbart gibt,
     * wenn benachbart 'true', andernfalls 'false' zurueck
     *
     * @param node1
     * @param node2
     * @return adjacencyMatrix[indexNode1][indexNode2]
     * @throws GraphException
     */
    public boolean isAdjacent(String node1, String node2) throws GraphException {
        int indexNode1 = this.indexOf(node1);
        int indexNode2 = this.indexOf(node2)
        
        try {
            return this.adjacencyMatrix[indexNode1][indexNode2];
        } catch (Exception err) {
            throw new GraphException();
        }
    }

    /**
     * fuegt eine Kante zwischen den Knoten mit Index index1 und index2 ein,
     * wenn diese Indizes von Laendern sind, wirft sonst eine GraphEception
     *
     * @param index1
     * @param index2
     * @throws GraphException
     */
    public void addEdge(int index1, int index2) throws GraphException {

        if (index1 > this.getNumberOfNodes() || index2 > this.getNumberOfNodes()) {
            throw new GraphException();
        } else {
            adjacencyMatrix[index1][index2] = true;
            adjacencyMatrix[index2][index1] = true;
        }
    }

    /**
     * fuegt eine Kante zwischen den Knoten mit dem Index node1 und node2 ein,
     * falls diese Indizes von Laendern sind; wirft sonst eine GraphException
     *
     * @param node1
     * @param node2
     * @throws GraphException
     */
    public void addEdge(String node1, String node2) throws GraphException {
        int indexNode1 = this.indexOf(node1);
        int indexNode2 = this.indexOf(node2);

        try {
            this.adjacencyMatriy[indexNode1][indexNode2] = true;
            this.adjacencyMatrix[indexNode2][indexNode1] = true;
        } catch (Exception err) {
            throw new GraphException();
        }
    }
}
