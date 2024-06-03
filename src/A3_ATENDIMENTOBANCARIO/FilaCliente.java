package A3_ATENDIMENTOBANCARIO;
//A FilaCliente armazena os nós de cada cliente

public class FilaCliente {

    public int qtdeElementos;
    public Node inicio;

    public FilaCliente() {
        this.qtdeElementos = 0;
        this.inicio = null;
    }

    public void enfileirar(int horaDeEntrada) {
        Node novo = new Node(horaDeEntrada);
        if (filaEstaVazia()) {
            this.inicio = novo;
        } else {
            Node auxiliar = inicio;
            while (auxiliar.next != null) {
                auxiliar = auxiliar.next;
            }
            auxiliar.next = novo;
        }
        qtdeElementos++;
    }

    public int desinfileirar() {
        if (filaEstaVazia()) {
            return -1;
        } else {
            Node retorno = inicio;
            inicio = inicio.next;
            qtdeElementos--;
            return retorno.cliente.horaDeEntrada;
        }
    }

    public boolean filaEstaVazia() {
        return this.qtdeElementos == 0;
    }

    public int tamanhoFila() {
        return this.qtdeElementos;
    }

    public void mostrarInformacoes() {
        Node auxiliar = inicio;
        if (!filaEstaVazia()) {
            while (auxiliar != null) {
                System.out.print(auxiliar.cliente.horaDeEntrada + ", ");
                auxiliar = auxiliar.next;
            }
        }
    }
}