import java.util.ArrayList;

public class ContaCorrente extends Conta
{
  private final String tipoConta = "Corrente";
  private double limiteCorrente;
  
  public ContaCorrente(Cliente don, double valor) 
  {
    super(don, valor);
    this.limiteCorrente = 3000 + (this.getDono().getLimiteCredito() * 0.2);
  }

  /* Métodos getter */

  public double getLimite()
  {
    return limiteCorrente;
  }

  public String getTipoConta()
  {
    return tipoConta;
  }

  void deposito(double valor){
      this.somaSaldo(valor);
      this.adicionaOperacao(new Operacao(valor, "Depósito"));
      System.out.println("Depósito realizado com sucesso.");
  }

  boolean saque(double valor){
    double saldo = this.getSaldo();
    if (valor <= saldo && valor <= limiteCorrente) {
      this.subSaldo(valor);
      this.adicionaOperacao(new Operacao(valor, "Saque"));
      return true;
    } 
    else{
      return false;
    }
  }
  
  boolean transferencia(double valor, int nConta, ArrayList<Conta> contas)
  {
    try {
      if (valor <= this.getSaldo() && valor <= this.limiteCorrente){
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
    System.out.println("Extrato da conta Corrente.");
    for(Operacao op: this.getListaOperacoes()) {
      System.out.print(op.getNomeOperacao() + "  ");
      System.out.print("$" + op.getOpValor() + "  ");
      System.out.println(op.getData());
    }
  }
}