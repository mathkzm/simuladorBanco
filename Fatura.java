import java.util.*;

public class Fatura
{
  private String nomeCliente, cartaoReferente;
  private final int vencimentoFatura = 5;
  private int mesReferencia = 11;
  private double valorFatura;
  ArrayList<Compra> listaCompras = new ArrayList<Compra>();

  public Fatura(String pessoa, String cartaoReferente) {
    this.nomeCliente = pessoa;
    this.cartaoReferente = cartaoReferente;
  }

  public int getVencimentoFatura() {
    return vencimentoFatura;
  }

  public int getMesReferencia() {
    return this.mesReferencia;
  }

  public String getNomeCliente() {
    return this.nomeCliente;
  }

  public String getReferente(){
    return this.cartaoReferente;
  }

  public double getValorFatura(){
    return this.valorFatura;
  }

  public void aumentaFatura(double valor) {
    this.valorFatura += valor;
  }

  
  public boolean fazCompra(Compra compra, Cartao cartao) {
    double aux = this.valorFatura + compra.getValorCompra();
    if (aux <= cartao.getLimiteTotal()) {
      this.aumentaFatura(compra.getValorCompra());
      this.listaCompras.add(compra);
      return true;
    } 
    else
      return false;
  }

  public boolean pagaFatura(Conta conta) {
    if (conta.getSaldo() >= this.valorFatura) {
      conta.subSaldo(this.valorFatura);
      this.valorFatura = 0;
      mesReferencia++;
      return true;
    } else {
      return false;
    }
  }

  void imprimeFatura(){ 
    System.out.println("XXXX-XXXX-XXXX-" + this.getReferente());
    
    for(Compra compra: listaCompras) {
      System.out.print(compra.getCompra() + "  ");
      System.out.println("$" + compra.getValorCompra() + "  ");
      System.out.println(compra.getDataCompra() + "\n");
    }
    System.out.println("Total: $" + this.valorFatura);
  } 
}