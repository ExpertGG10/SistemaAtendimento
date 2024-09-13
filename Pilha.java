
public class Pilha {
    private Node topo;

    public Pilha() {
        this.topo = null;
    }

    public void push(Elemento elemento) {
        Node novoNode = new Node(elemento);
        novoNode.proximo = topo;
        topo = novoNode;
    }

    public Elemento remover(String id) throws Exception {
        if (topo == null) {
            throw new Exception("Pilha vazia");
        }

        Node atual = topo;
        Node anterior = null;

        while (atual != null) {
            if (atual.elemento.id.equals(id)) {
                if (anterior == null) { // O elemento a ser removido é o topo
                    topo = atual.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }
                return atual.elemento;
            }
            anterior = atual;
            atual = atual.proximo;
        }

        throw new Exception("Elemento com ID " + id + " não encontrado.");
    }

    public void imprimirPilha() {
        Node atual = topo;
        while (atual != null) {
            System.out.println(atual.elemento);
            atual = atual.proximo;
        }
    }
}