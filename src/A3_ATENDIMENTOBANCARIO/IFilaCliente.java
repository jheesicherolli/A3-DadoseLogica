package A3_ATENDIMENTOBANCARIO;

/*
O uso da interface é para garantir que os métodos
da fila não sejam alterados
*/

public interface IFilaCliente {

    public void enfileirar(int horaDeEntrada);
    public int desinfileirar();
    public boolean filaEstaVazia();
    public int tamanhoFila();
    public void mostrarInformacoes();
}