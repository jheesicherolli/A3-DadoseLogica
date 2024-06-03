package A3_ATENDIMENTOBANCARIO;


import java.util.Random;
public class Atendimento {

    //Utilizando o Random para gerar números aleatórios
    public static Random random = new Random();

    public static boolean chegouCliente() {
        //só vai chegar um cliente se o número sorteado for igual a zero, ou seja 3,33% de chance
        int r = random.nextInt(30);
        return r == 0;
    }

    
    //Verifica se há um guichê livre
    public static boolean guicheLivre(ListaGuiche lista) {
        boolean retorno = false;
        for (int indice = 0; indice <= lista.tamanho() -1 ; indice++) {
            //tamanho é dinâmico ele vai iterar a lista de guiches e para cada item dentro da lista (Guiche), ele vai chamar a função ".checar()"
            //a ideia dessa função é saber se existe pelo menos um Guiche aberto, não especificando necessariamente qual
            if (lista.checar(indice)) {
                retorno = true;
                break;
            }
        }
        return retorno;

    }


    public static void main(String[] args) {
        
        //Instanciando as estruturas que serão utilizadas
        FilaCliente filaClientes = new FilaCliente();
        ListaGuiche listaGuiches = new ListaGuiche(3);

        //Variáveis que serão utilizadas
        int saques = 0;
        int depositos = 0;
        int pagamentos = 0;
        listaGuiches.tamanho();

        //Variáveis aritiméticas 
        int totalClientes = 0;
        int somaEspera = 0;
        int tempoTransacao = 0;
        double mediaEspera = 0;

        //Criando e adicionando guichês de uma agência em uma lista
        Guiche guiche1 = new Guiche(true);
        Guiche guiche2 = new Guiche(true);
        Guiche guiche3 = new Guiche(true);
        listaGuiches.inserir(guiche1); 
        listaGuiches.inserir(guiche2);
        listaGuiches.inserir(guiche3);

        int tempoExpedienteCorrido = 0;
        int tempoExtra = 0;

        while (tempoExpedienteCorrido <= 21600 || !filaClientes.filaEstaVazia()) { // While representa o expediente total 
            //Se está dentro do expediente ou a fila não está vazia

            if (tempoExpedienteCorrido > 21600) { //Tempo extra
                tempoExtra++;
            }

            /* -------------------------- */
            if (tempoExpedienteCorrido <= 21600) { //Impedir a chegada de clientes depois do fim do expediente

                if (chegouCliente()) {
                    filaClientes.enfileirar(tempoExpedienteCorrido); //Adiciona um cliente na fila com o segundo atual
                    totalClientes++;
                }
            }

            /* -------------------------- */


            if (guicheLivre(listaGuiches) && !filaClientes.filaEstaVazia()) { 
                //A função guicheLivre irá percorrer todos os Guiches e irá chamar a função ".checar()"
                //E para a condição ser verdadeira alguns dos guiches precisam estar livres e a fila deve estar vazia

                somaEspera += tempoExpedienteCorrido - filaClientes.desinfileirar(); //Soma o tempo de espera de cada cliente

                for (int indice = 0; indice <= listaGuiches.tamanho() -1; indice++) { //Verifica qual guichê está livre
                    if (listaGuiches.obter(indice).livre) {
                        listaGuiches.obter(indice).livre = false; //Ocupa o guichê assim que descobrir que está livre
                       

                        //Tipo de transação
                        int r = random.nextInt(3);
                        switch (r) {
                            case 0:
                                //Transação de saque
                                tempoTransacao = tempoExpedienteCorrido + 60;
                                saques++; //contagem de saques
                                break;
                            case 1:
                                //Transação de depósito
                                tempoTransacao = tempoExpedienteCorrido + 90;
                                depositos++; //contagem de depositos
                                break;
                            case 2:
                                //Transação de pagamento
                                tempoTransacao = tempoExpedienteCorrido + 120;
                                pagamentos++; //contagem de pagamento
                                break;
                        }
                        listaGuiches.obter(indice).tempoOcupado = tempoTransacao; 
                        //Indica o tempo que aquele guichê do indice ficará ocupado

                        break;
                    }
                }
            }
            
            /* -------------------------- */

            for (int indice = 0; indice <= listaGuiches.tamanho() -1; indice++) {
                if (listaGuiches.obter(indice).livre == false && tempoExpedienteCorrido == listaGuiches.obter(indice).tempoOcupado) {
                    listaGuiches.obter(indice).livre = true;  //Se o cliente terminou a transação, o guichê fica livre
                }
            }

            tempoExpedienteCorrido++;

        }
        /* -------------------------- */
        if (totalClientes > 0) {
            mediaEspera = somaEspera / totalClientes;
        }

        //Cálculos utilizados para processar as saídas
        int mediaSegundos = (int) mediaEspera % 60;
        mediaEspera /= 60;
        int mediaMinutos = (int) mediaEspera % 60;

        int segundosExtra = (int) tempoExtra % 60;
        tempoExtra /= 60;
        int minutosExtra = (int) tempoExtra % 60;

        /* -------------------------- */
        
        //Resultados
        System.out.println("Número total de clientes: " + totalClientes + ".");
        System.out.println("Número de clientes que fizeram saque: " + saques + ".");
        System.out.println("Número de clientes que fizeram depósito: " + depositos + ".");
        System.out.println("Número de clientes que fizeram pagamento: " + pagamentos + ".");
        System.out.println("Tempo médio de espera: " + mediaMinutos + " minutos e " + mediaSegundos + " segundos.");
        System.out.println("Tempo extra de expediente: " + minutosExtra + " minutos e " + segundosExtra + " segundos.");

    }
    

}