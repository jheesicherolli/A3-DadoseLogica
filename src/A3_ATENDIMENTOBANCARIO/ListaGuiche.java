package A3_ATENDIMENTOBANCARIO;

/*
Utilizada para auxiliar o gerenciamento do conjunto de guichês.
*/

public class ListaGuiche {

    public int qtdeElementos;
    public Guiche lista[];
    public int inicio;
    public int fim;

    public ListaGuiche(int tamanho) {
        this.qtdeElementos = 0;
        this.lista = new Guiche[tamanho]; //lista de guiches
        this.inicio = 0;
        this.fim = 0;
    }

    public boolean inserir(Guiche guiche) {
        if (listaEstaCheia()) {
            return false;

        } else if ( listaEstaVazia()) {
            this.lista[inicio] = guiche;
            this.qtdeElementos++;
            this.inicio++;
            this.fim++;

            return true;

        } else { //Não está cheia nem vazia, ou seja tem pessoas.
            this.lista[qtdeElementos] = guiche;
            this.qtdeElementos++;
            this.fim++;
    
            return true;
        }
    }

    public boolean checar(int indice) {
        return lista[indice].livre;
    }

    public Guiche obter(int indice) {
        return lista[indice];
    }

    public int tamanho() {
        return this.qtdeElementos;
    }

    public boolean listaEstaVazia() {
        return this.qtdeElementos == 0;
    }

    public boolean  listaEstaCheia() {
        return this.qtdeElementos == lista.length;
    }

}