package A3_ATENDIMENTOBANCARIO;
//A FilaCliente armazena os nós de cada cliente

public class FilaCliente implements IFilaCliente {

    public int qtdeElementos;
    public Node inicio;

    public FilaCliente() {
        this.qtdeElementos = 0;
        this.inicio = null;
    }

    @Override
    public void enfileirar(int tempoExpedienteCorrido) {
        Node novo = new Node(tempoExpedienteCorrido);
        if (filaEstaVazia()) {
            novo.next = null;
            this.inicio = novo;
            qtdeElementos++;

        } else {
            Node auxiliar = inicio;
            while (auxiliar.next != null) {
                auxiliar = auxiliar.next;
            }
            auxiliar.next = novo;
            qtdeElementos++;
        }
    }

    @Override
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

    @Override
    public boolean filaEstaVazia() {
        return this.qtdeElementos == 0;
    }

    @Override
    public int tamanhoFila() {
        return this.qtdeElementos;
    }

    @Override
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