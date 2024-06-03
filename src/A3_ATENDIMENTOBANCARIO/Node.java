package A3_ATENDIMENTOBANCARIO;

/*
A classe No foi utilizada para compor
a fila dinâmica de objetos, nesse caso, clientes
*/

public class Node {

    public Cliente cliente = new Cliente();
    public Node next;

    public Node(int horaDeEntrada) {
        cliente = new Cliente(horaDeEntrada);
        this.next = null;
    }

}