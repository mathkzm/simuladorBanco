import java.util.ArrayList;

public class ContaPoupanca extends Conta
{
  private final String tipoConta = "Poupança";
  private double limitePoupanca;

  public ContaPoupanca(Cliente don, double valor) // Construtor da superclasse que informa o valor.
  {
    super(don, valor);
    this.limitePoupanca = 1500 + (this.getDono().getLimiteCredito() * 0.18);
  }

  /* Métodos getter */

  public double getLimite()
  {
    return limitePoupanca;
  }

  public String getTipoConta()
  {
    return tipoConta;
  }
  
  void deposito(double valor) 
  {
    this.somaSaldo(valor);
    this.adicionaOperacao(new Operacao(valor, "Depósito"));
    System.out.println("Depósito realizado com sucesso.");
  }

  boolean saque(double valor) 
  {
    double saldo = this.getSaldo();
    if (valor <= saldo && valor <= limitePoupanca) 
    {
      this.subSaldo(valor);
      this.adicionaOperacao(new Operacao(valor, "Saque"));
      return true;
    } 
    else {
      return false;
    }
  }

  boolean transferencia(double valor, int nConta, ArrayList<Conta> contas) {
    try {
      if (valor <= this.getSaldo() && valor <= this.limitePoupanca){
        contas.get(nConta).somaSaldo(valor);
        this.adicionaOperacao(new Operacao(valor, "Transferência"));
        this.subSaldo(valor);
        return true;
      } else
        return false;
    } catch (IndexOutOfBoundsException e) {
      return false;
    }
  }

  public void extrato() {
    System.out.println("Extrato da conta Poupança.");
    for(Operacao op: this.getListaOperacoes()) {
      System.out.print(op.getNomeOperacao() + "  ");
      System.out.print("$" + op.getOpValor() + "  ");
      System.out.println(op.getData());
    }
  }
}