package estrutura;

public class ListaDupla {
    private NodeDuplo head;
    private NodeDuplo tail;

    public ListaDupla() {
        head = null;
        tail = null;
    }

    // Inserção no início
    public void inserirInicio(int data) {
        NodeDuplo novo = new NodeDuplo(data);
        if (head == null) {
            head = tail = novo;
        } else {
            novo.next = head;
            head.prev = novo;
            head = novo;
        }
    }

    // Inserção no final
    public void inserirFim(int data) {
        NodeDuplo novo = new NodeDuplo(data);
        if (tail == null) {
            head = tail = novo;
        } else {
            tail.next = novo;
            novo.prev = tail;
            tail = novo;
        }
    }

    // Inserção após valor específico
    public void inserirDepoisDe(int valor, int data) {
        NodeDuplo temp = head;
        while (temp != null && temp.data != valor) {
            temp = temp.next;
        }
        if (temp != null) {
            NodeDuplo novo = new NodeDuplo(data);
            novo.next = temp.next;
            novo.prev = temp;
            if (temp.next != null) {
                temp.next.prev = novo;
            } else {
                tail = novo;
            }
            temp.next = novo;
        } else {
            System.out.println("Valor " + valor + " não encontrado.");
        }
    }

    // Busca
    public NodeDuplo buscar(int data) {
        NodeDuplo temp = head;
        while (temp != null) {
            if (temp.data == data) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Remoção
    public void remover(int data) {
        NodeDuplo temp = head;
        while (temp != null && temp.data != data) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Valor " + data + " não encontrado.");
            return;
        }
        if (temp.prev != null) temp.prev.next = temp.next;
        else head = temp.next;

        if (temp.next != null) temp.next.prev = temp.prev;
        else tail = temp.prev;
    }

    // Listagem
    public void listar() {
        NodeDuplo temp = head;
        System.out.print("Lista Dupla: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
