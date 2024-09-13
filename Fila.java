
public class Fila {
    private Node frente;
    private Node tras;

    public Fila() {
        this.frente = null;
        this.tras = null;
    }

    public void enqueue(Elemento elemento) {
        Node novoNode = new Node(elemento);
        if (tras != null) {
            tras.proximo = novoNode;
        }
        tras = novoNode;
        if (frente == null) {
            frente = novoNode;
        }
    }

    public Elemento dequeue() throws Exception {
        if (frente == null) {
            throw new Exception("Fila vazia");
        }
        Elemento elemento = frente.elemento;
        frente = frente.proximo;
        if (frente == null) {
            tras = null;
        }
        return elemento;
    }

    public void imprimirFila() {
        Node atual = frente;
        while (atual != null) {
            System.out.println(atual.elemento);
            atual = atual.proximo;
        }
    }
}
