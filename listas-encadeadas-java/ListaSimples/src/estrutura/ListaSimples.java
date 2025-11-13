package estrutura;

public class ListaSimples {
    private Node head;

    public ListaSimples() {
        head = null;
    }

    // Inserção no início
    public void inserirInicio(int data) {
        Node novo = new Node(data);
        novo.next = head;
        head = novo;
    }

    // Inserção no final
    public void inserirFim(int data) {
        Node novo = new Node(data);
        if (head == null) {
            head = novo;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = novo;
    }

    // Inserção no meio (após um valor específico)
    public void inserirDepoisDe(int valor, int data) {
        Node temp = head;
        while (temp != null && temp.data != valor) {
            temp = temp.next;
        }
        if (temp != null) {
            Node novo = new Node(data);
            novo.next = temp.next;
            temp.next = novo;
        } else {
            System.out.println("Valor " + valor + " não encontrado.");
        }
    }

    // Busca
    public Node buscar(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Remoção
    public void remover(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Valor " + data + " não encontrado.");
        }
    }

    // Listagem
    public void listar() {
        Node temp = head;
        System.out.print("Lista: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
