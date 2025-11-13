package estrutura;

public class ListaCircular {
    private NodeCircular head;
    private NodeCircular tail;

    public ListaCircular() {
        head = null;
        tail = null;
    }

    // Inserção no início
    public void inserirInicio(int data) {
        NodeCircular novo = new NodeCircular(data);
        if (head == null) {
            head = tail = novo;
            tail.next = head;
        } else {
            novo.next = head;
            head = novo;
            tail.next = head;
        }
    }

    // Inserção no final
    public void inserirFim(int data) {
        NodeCircular novo = new NodeCircular(data);
        if (head == null) {
            head = tail = novo;
            tail.next = head;
        } else {
            tail.next = novo;
            tail = novo;
            tail.next = head;
        }
    }

    // Inserção após valor específico
    public void inserirDepoisDe(int valor, int data) {
        NodeCircular temp = head;
        boolean encontrado = false;
        if (head != null) {
            do {
                if (temp.data == valor) {
                    NodeCircular novo = new NodeCircular(data);
                    novo.next = temp.next;
                    temp.next = novo;
                    if (temp == tail) tail = novo;
                    encontrado = true;
                    break;
                }
                temp = temp.next;
            } while (temp != head);
        }
        if (!encontrado) System.out.println("Valor " + valor + " não encontrado.");
    }

    // Busca
    public NodeCircular buscar(int data) {
        NodeCircular temp = head;
        if (head != null) {
            do {
                if (temp.data == data) return temp;
                temp = temp.next;
            } while (temp != head);
        }
        return null;
    }

    // Remoção
    public void remover(int data) {
        if (head == null) return;

        NodeCircular temp = head;
        NodeCircular prev = tail;
        boolean encontrado = false;
        do {
            if (temp.data == data) {
                if (temp == head) head = head.next;
                if (temp == tail) tail = prev;

                prev.next = temp.next;
                encontrado = true;
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (!encontrado) System.out.println("Valor " + data + " não encontrado.");
    }

    // Listagem
    public void listar() {
        if (head == null) {
            System.out.println("Lista Circular vazia");
            return;
        }
        NodeCircular temp = head;
        System.out.print("Lista Circular: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}
