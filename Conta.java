import java.util.*;

public abstract class Conta
{
  private static int contaContas = 0;
  private final int agencia = 1;
  private int numeroConta;
  private double saldo;
  private Cliente dono;
  private ArrayList<Operacao> listaOperacoes = new ArrayList<Operacao>();

  public Conta(Cliente dono, double valor){
    this.numeroConta = contaContas;
    contaContas++;
    this.saldo = valor;
    this.dono = dono;
  }

  public int getAgencia(){
    return agencia;
  }

  public int getNumeroConta(){
    return numeroConta;
  }

  public double getSaldo(){
    return saldo;
  }

  public Cliente getDono(){
    return dono;
  }

  public ArrayList<Operacao> getListaOperacoes(){
    return listaOperacoes;
  }

  protected void somaSaldo(double valor){
    this.saldo += valor;
  }

  protected void subSaldo(double valor){
    this.saldo -= valor;
  }

  public void adicionaOperacao(Operacao op) {
    this.listaOperacoes.add(op);
  }

  abstract public void extrato(); 
  
  abstract void deposito(double valor);

  abstract boolean saque(double valor);

  abstract boolean transferencia(double valor, int nConta, ArrayList<Conta> contas);
}