# Estrutura de Dados - A3: Fila do banco

## Relatório de Aplicação:

O objetivo do trabalho foi criar um algoritmo que determine o tempo médio que um cliente permanece na fila de uma agência bancária. 

Foi definido que: 

Na simulação a ser realizada, há dois eventos importantes:
- Um cliente chega à agência e entra na fila.
- Um guichê é liberado, alguém sai da fila e o utiliza.

### Definição das classes 

Para resolução do problema criamos as seguintes classes: 

#### Atendimento:

Classe Main, contendo uma verificação de `GuicheLivre()` e se `ChegouCliente()`.

Pontos de lógica que consideramos: 

- Se está dentro do tempo de expediente .
- Se a fila não está vazia.
- Se os guiches estão livres e qual guiche está livre.
- Realiza as transações (saque, depósito e pagamento).

A principal funcionalidade dessa classe é realizar os calculos para a saída desejada. Contendo essas informações:
- Número total de clientes atendidos.
- Número de clientes que fizeram saque, depósito e pagamento.
- Tempo médio de espera na fila.
- Tempo extra de expediente.

#### Cliente:

A classe Cliente possui um atributo `horaDeEntrada` que armazena a hora de entrada de um cliente.

Há dois construtores:
Um construtor padrão que não inicializa a hora de entrada.
Um construtor que permite definir a hora de entrada no momento da criação do objeto Cliente.

#### FilaCliente: 

Estrutura de lista encadeada, onde cada nó representa um cliente. 

- `qtdeElementos`: Um inteiro que mantém o número de elementos na fila.
- `inicio`: Referência para o primeiro nó da lista (início da fila), lista precisa começar vazia.

##### Métodos FilaCliente: 

- `enfileirar`: adiciona um novo cliente na fila. 
- `desinfileirar`: remove e retorna o tempo de entrada do cliente no inicio da fila. 
- `filaEstaVazia`: verificar se a fila está vazia. 
- `tamanhoFila`: retorna o número de elementos da fila. 
- `mostrarInformacoes`: imprime as horas de entrada de todos os clientes. 

#### Node

A classe Node encapsula um objeto `Cliente` e a referência para o próximo nó na lista encadeada. Ela é essencial para a implementação da lista encadeada usada pela classe `FilaCliente`.

#### Guiche: 

A classe Guiche possui dois atributos:
- `livre`: Um booleano que indica se o guichê está disponível (true) ou não (false).
- `tempoOcupado`: Um inteiro que indica o tempo em que o guichê estará ocupado.

O construtor inicializa livre com o valor passado como parâmetro e tempoOcupado com 0, indicando que o guichê não está ocupado inicialmente.


#### ListaGuiche

A classe ListaGuiche possui quatro atributos: 

- `qtdeElementos`: Um inteiro que mantém o número de guichês na lista.
- `lista`: Um array de objetos `Guiche` que armazena os guichês. (classe Guiche)
- `inicio`: Índice que aponta para o início da lista. 
- `fim`: Índice que aponta para o fim da lista.

##### Métodos ListaGuiche: 

- `inserir`: adiciona um guichê à lista.
- `checar`: verifica se o guichê no índice especificado está livre.
- `obter`: retorna o guichê na lista.
- `tamanho`: retorna a quantidade de guiches na lista. 
- `listaEstaVazia`: retorna se a lista ta vazia. 
- `listaEstaCheia`: retorna se a lista está cheia. 

# Estrutura do projeto 

O projeto foi estruturado em um pacote contendo todas as classes. 

Para utilizar do sistema compile o arquivo `Atendimento`.