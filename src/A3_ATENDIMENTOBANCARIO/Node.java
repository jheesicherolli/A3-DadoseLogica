package A3_ATENDIMENTOBANCARIO;

public class Node {
    //amarra os clientes, cria novos clientes e intancia a hora de entrada

    public Cliente cliente = new Cliente();
    public Node next;

    public Node(int horaDeEntrada) {
        cliente = new Cliente(horaDeEntrada);
        this.next = null;
    }

}
