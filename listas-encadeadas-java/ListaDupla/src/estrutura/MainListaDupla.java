package estrutura;

public class MainListaDupla {
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();

        lista.inserirInicio(10);
        lista.inserirFim(20);
        lista.inserirFim(30);
        lista.inserirDepoisDe(20, 25);

        lista.listar();

        System.out.println("Buscando 25: " + (lista.buscar(25) != null ? "Encontrado" : "Não encontrado"));

        lista.remover(20);
        lista.listar();
    }
}
