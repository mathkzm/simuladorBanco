import java.util.*;

public class Main   
{
  public static void main (String args[])
  {
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    ArrayList<Conta> listaContas = new ArrayList<Conta>();
    Scanner input = new Scanner(System.in);

    String opcao;

    String nome, genero, nomePai, nomeMae, rgOrg, endereco, nascimento, cpf, telefone;
    double rendaMensal, valor;
    int rgNum;
    Cliente ultimoCliente;
    Conta ultimaConta;
    boolean ok = true;

    listaClientes.add(new ClienteA("Controle", "Banco", null, null, null, null,
                                   "0/0/0", null, 0, null, 100000, input));
    listaContas.add(new ContaCorrente(listaClientes.get(0), 100000));
    listaContas.add(new ContaPoupanca(listaClientes.get(0), 100000));
    
    System.out.println("Bem vindo ao DuBanco.");
    System.out.println("Já é cliente? Ou deseja criar uma conta?");
    System.out.println("1 = Criar uma conta\n2 = Acessar uma conta");

    do {
      // Volta para essa opção caso o cliente não deseje fazer outra operação.

      
      opcao = input.nextLine();

      switch (opcao) {
        case "1":
          System.out.println("Digite seu nome completo:");
          nome = input.nextLine();

          System.out.println("Digite seu gênero:");
          genero = input.nextLine();

          System.out.println("Digite o nome completo de seu pai:");
          nomePai = input.nextLine();

          System.out.println("Digite o nome completo de sua mãe:");
          nomeMae = input.nextLine();

          System.out.println("Digite a sua data de nascimento:");
          nascimento = input.nextLine();

          System.out.println("Digite o seu endereço:");
          endereco = input.nextLine();

          System.out.println("Digite seu telefone de contato:");
          telefone = input.nextLine();

          System.out.println("Digite o número do RG:");
          while (true) {
            try {
              rgNum = input.nextInt();
              input.nextLine();
              break;
            } catch (InputMismatchException e) {
              input.nextLine();
              System.out.println("Digite um valor válido.");
            }
          }   

          System.out.println("Digite o órgão expedidor do RG:");
          rgOrg = input.nextLine();

          System.out.println("Digite o número do seu CPF:");
          cpf = input.nextLine();

          System.out.println("Digite a sua renda mensal:");
          while (true) {
            try {
              rendaMensal = input.nextDouble();
              input.nextLine();
              break;
            } catch (InputMismatchException e) {
              input.nextLine();
              System.out.println("Digite um valor válido.");
            }
          }
        
          if (rendaMensal <= 3300.00) 
            listaClientes.add(new ClienteB(nome, genero, nomePai, nomeMae, 
                              rgOrg, endereco, nascimento, cpf,
                              rgNum, telefone, rendaMensal, input));
          else
            listaClientes.add(new ClienteA(nome, genero, nomePai, nomeMae, 
                              rgOrg, endereco, nascimento, cpf,
                              rgNum, telefone, rendaMensal, input));
        
          System.out.println("Deseja uma corrente, poupança ou ambas?");
          System.out.println("1 = Corrente\n2 = Poupança\n3 = Ambas");

          opcao = input.nextLine();
          ultimoCliente = listaClientes.get(listaClientes.size() - 1);
        
          switch (opcao) {
            case "1":
              System.out.println("Deseja adicionar algum valor à conta?");
              while (true) {
                try {
                  valor = input.nextDouble();
                  input.nextLine();
                  break;
                } catch (InputMismatchException e) {
                  input.nextLine();
                  System.out.println("Digite um valor válido.");
                }
              }
              listaContas.add(new ContaCorrente(ultimoCliente, valor));

              ultimaConta = listaContas.get(listaContas.size() - 1);
            
              System.out.println("Sua conta corrente foi criada com sucesso.");
              System.out.println("Os dados da sua conta são:");
              System.out.println("Agencia: " + ultimaConta.getAgencia());
              System.out.println("Número da conta: " + ultimaConta.getNumeroConta());
              System.out.println("Número do cartão: " + ultimoCliente.getCartao().getNumCartao());
              System.out.println("Vencimento do cartão: " + ultimoCliente.getCartao().formataVencimento());

              break;
          
            case "2":
              System.out.println("Deseja adicionar algum valor à conta?");
              while (true) {
                try {
                  valor = input.nextDouble();
                  input.nextLine();
                  break;
                } catch (InputMismatchException e) {
                  input.nextLine();
                  System.out.println("Digite um valor válido.");
                }
              }
              listaContas.add(new ContaPoupanca(ultimoCliente, valor));

              ultimaConta = listaContas.get(listaContas.size() - 1);

              System.out.println("Sua conta poupança foi criada com sucesso.");
              System.out.println("Os dados da sua conta são:");
              System.out.println("Agencia: " + ultimaConta.getAgencia());
              System.out.println("Número da conta: " + ultimaConta.getNumeroConta());
              System.out.println("Número do cartão: " + ultimoCliente.getCartao().getNumCartao());
              System.out.println("Vencimento do cartão: " + ultimoCliente.getCartao().formataVencimento());

              break;

            case "3":
              System.out.println("Deseja adicionar algum valor à conta corrente?");
              while (true) {
                try {
                  valor = input.nextDouble();
                  input.nextLine();
                  break;
                } catch (InputMismatchException e) {
                  input.nextLine();
                  System.out.println("Digite um valor válido.");
                }
              }
              listaContas.add(new ContaCorrente(ultimoCliente, valor));

              ultimaConta = listaContas.get(listaContas.size() - 1);

              System.out.println("Sua conta corrente foi criada com sucesso.");
              System.out.println("Os dados da sua conta são:");
              System.out.println("Agencia: " + ultimaConta.getAgencia());
              System.out.println("Número da conta: " + ultimaConta.getNumeroConta());
              System.out.println("Número do cartão: " + ultimoCliente.getCartao().getNumCartao());
              System.out.println("Vencimento do cartão: " + ultimoCliente.getCartao().formataVencimento());
          
              System.out.println("Deseja adicionar algum valor à conta poupança?");
              while (true) {
                try {
                  valor = input.nextDouble();
                  input.nextLine();
                  break;
                } catch (InputMismatchException e) {
                  input.nextLine();
                  System.out.println("Digite um valor válido.");
                }
              }
              listaContas.add(new ContaPoupanca(ultimoCliente, valor));

              ultimaConta = listaContas.get(listaContas.size() - 1);

              System.out.println("Sua conta poupança foi criada com sucesso.");
              System.out.println("Os dados da sua conta são:");
              System.out.println("Agencia: " + ultimaConta.getAgencia());
              System.out.println("Número da conta: " + ultimaConta.getNumeroConta());
              System.out.println("Número do cartão: " + ultimoCliente.getCartao().getNumCartao());
              System.out.println("Vencimento do cartão: " + ultimoCliente.getCartao().formataVencimento());

              break;
          
            default:
              System.out.println("Digite uma opção válida.");
        }
        
        break;

        case "2":
          System.out.println("Digite o número da conta que deseja acessar:");
          while (true) {
            try {
              rgNum = input.nextInt();
              input.nextLine();
              ultimaConta = listaContas.get(rgNum);
              break;
            } catch (InputMismatchException e) {
              input.nextLine();
              System.out.println("Digite um valor válido.");
            } catch (IndexOutOfBoundsException e) {
              System.out.println("Conta não encontrada, tente novamente.");
            }
          }
        
          do {
            // Volta para essa opção caso o cliente realize outra operação.
            System.out.println("O que deseja fazer?");
            System.out.println("1 = Consulta de Saldo\n2 = Saque\n3 = Depósito\n4 = Transferência\n"
                                + "5 = Emitir extrato\n6 = Pagamento\n7 = Emitir fatura\n8 = Pagar fatura\n9 = Sair");
            opcao = input.nextLine();

            switch(opcao) {
              case "1": // Consulta saldo
                System.out.println("Seu saldo de sua conta é de :");
                System.out.println("R$" + ultimaConta.getSaldo());
                
                break;
          
              case "2": // Saque
                System.out.println("Digite o valor que você deseja sacar:");
                while (true) {
                  try {
                    valor = input.nextDouble();
                    input.nextLine();
                    break;
                  } catch (InputMismatchException e) {
                    input.nextLine();
                    System.out.println("Digite um valor válido.");
                  }
                }            
                if (ultimaConta.saque(valor))
                  System.out.println("Saque realizado com sucesso.");
                else
                  System.out.println("Saque não pôde ser realizado.");
            
                break;

              case "3": // Depósito
                System.out.println("Digite o valor a ser depositado: ");
                while (true) {
                  try {
                    valor = input.nextDouble();
                    input.nextLine();
                    break;
                  } catch (InputMismatchException e) {
                    input.nextLine();
                    System.out.println("Digite um valor válido.");
                  }
                }
                ultimaConta.deposito(valor);

                break;

              case "4": // Transferência
                System.out.println("Digite o número da conta que receberá a tranferência:");
                while (true) {
                  try {
                    rgNum = input.nextInt();
                    input.nextLine();
                    break;
                  } catch (InputMismatchException e) {
                    input.nextLine();
                    System.out.println("Digite um número de conta válido.");
                  }
                }  
                System.out.println("Digite o valor a ser trasnferido:");
                while (true) {
                  try {
                    valor = input.nextDouble();
                    input.nextLine();
                    break;
                  } catch (InputMismatchException e) {
                    input.nextLine();
                    System.out.println("Digite um valor válido.");
                  }
                }
                if (ultimaConta.transferencia(valor, rgNum, listaContas))
                  System.out.println("Transferência realizada com sucesso.");
                else
                  System.out.println("Tranferência não pôde ser realizada.");
                
                break;

              case "5": // Extrato
                ultimaConta.extrato();
                break;
          
              case "6": // Faz compra
                ultimoCliente = ultimaConta.getDono();
                System.out.println("Faça uma observação sobre a compra:");
                nome = input.nextLine();
                System.out.println("Digite o valor da compra:");
                while (true) {
                  try {
                    valor = input.nextDouble();
                    input.nextLine();
                    break;
                  } catch (InputMismatchException e) {
                    input.nextLine();
                    System.out.println("Digite um valor válido.");
                  }
                }
                if (ultimoCliente.getFatura().fazCompra(new Compra(nome, valor), ultimoCliente.getCartao())) {
                  System.out.println("Compra realizada com sucesso.");
                } else
                  System.out.println("Saldo insuficiente.");
                break;
              
              case "7": // Emite fatura.
                ultimaConta.getDono().getFatura().imprimeFatura();    
                break;

              case "8": // Paga fatura.
                if (ultimaConta.getDono().getFatura().pagaFatura(ultimaConta)) {
                  System.out.println("Fatura paga com sucesso.");
                } else
                  System.out.println("Saldo insuficiente.");
                break;
              
              case "9": // Sai da seleção de operações.
                ok = false;
                break;

              default:
                System.out.println("Digite uma opção válida.");
            } 
          } while (ok);
          break;

        default:
          System.out.println("Digite uma opção válida.");
      }

      System.out.println("Bem vindo ao DuBanco.");
      System.out.println("Já é cliente? Ou deseja criar uma conta?");
      System.out.println("1 = Criar uma conta\n2 = Acessar uma conta");

    } while (input.hasNextLine());
    input.close();
  }
}

