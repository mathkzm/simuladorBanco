# Simulador de Banco
Trabalho prático realizado para a disciplina Linguagem de Programação Orientada a Objetos no semestre 2021/2.

Alunos: Gabriel Cosme Zanata de Morais e Matheus Kazumi Silva Miyashiro.

## Linguagem

A linguagem utilizada para o desenvolvimento do trabalho foi Java.

## Sobre o trabalho

- Para o trabalho em questão foi escolhida a implementação de um sistema bancário simplificado. Ao executar o programa, abre-se um diálogo com duas opções, criar ou acessar uma conta. A conta é criada junto ao cadastro do cliente, após a primeira criação de conta, criar uma nova conta exige repetir um novo cadastro do cliente.

- A opção de criação de conta exige que o usuário digite seus dados no terminal como solicitado, todos os campos declarados como String aceitarão um misto de caracteres especiais e alfanuméricos, entretanto, o campo com o número do RG é um int, então deve ser provido como tal, outro campo especial é a data de nascimento, que deve ser dada no formato xx/xx/xxxx, onde cada x é um número inteiro. Não há tratamento de exceções quanto ao conteúdo dos atributos do tipo String.

- Após digitar os dados corretamente, o terminal pedirá que o usuário determine se sua conta será uma conta poupança ou corrente, além disso há uma opção para a criação das duas. Para cada conta o usuário deve determinar um valor inicial (double) para o saldo inicial e então os dados de cada conta serão emitidos. Os dados incluem o número da conta, o número da agência e o número do cartão pertencente ao cliente com a data de vencimento do cartão.

- A opção de acessar uma conta pede somente o número da conta a ser acessada. Após digitar o número da conta, o usuário pode escolher uma operação a ser realizada. As opções incluem visualizar o saldo da conta, depositar dinheiro, sacar uma quantia, transferir dinheiro para uma outra conta, fazer uma compra, pagar a fatura do cliente ou emitir um extrato com as operações realizadas na conta.

- A opção de saldo mostra a quantia disponível em conta, depósito recebe um double e permite adicionar um montante ao saldo da conta, saque permite retirar uma quantia da conta e transferência permite mover uma quantidade de uma conta para outra.

- A opção Extrato chama o método extrato, que imprime na tela o nome da operação, a quantia movimentada e a data da realização da operação. Pagamento realiza uma compra, recebendo uma String de detalhes da compra e o valor dela, adicionando na fatura que é emitida para o usuário através da opção emitir fatura e paga usando a opção de pagar a fatura caso a conta possua fundos suficientes. O usuário pode também optar pela opção “Sair”, que volta ao estado inicial do programa.

- A execução do código é encerrada simulando EOF no terminal (ctrl+Z ou ctrl+D).

## Classes

- A classe ‘Cliente’ é responsável por guardar dados de cadastro de um cliente e serve como ponte de comunicação entre as outras classes. Essa classe se estende por meio de duas outras classes, ‘ClienteA’ e ‘ClienteB’, que indicam a categoria do cliente baseado na renda mensal. 

- A classe ‘Conta’ é responsável por guardar as informações da conta do cliente, como o saldo e o histórico de operações realizadas por ele. Ela também possui um campo do tipo Cliente que indica o seu dono e se estende por meio de duas classes filhas, ContaCorrente e ContaPoupanca, que indicam o tipo de conta, cada uma com um limite próprio para operações de saque e transferência.

- A classe ‘Cartao’ é instanciada em conjunto com o cadastro do cliente, ela possui um número de cartão gerado aleatoriamente pelo método ‘defineNumCartao’, que é uma implementação do algoritmo de Luhn.

- A classe ‘Compra’ guarda os dados de um pagamento feito por um cliente, como uma observação, o valor do pagamento e a data do pagamento. 

- A classe ‘Fatura’ guarda as compras realizadas em uma ‘ArrayList’ de compras e emite a fatura através do método ‘imprimeFatura’. 

- A classe ‘Operacao’ indica uma operação realizada pelo usuário, essas operações são guardadas pela classe Conta e mostradas para o usuário através do método extrato.

## Execução

No terminal:

```
javac *.java
```

Em seguida:

```
java Main
```

##

