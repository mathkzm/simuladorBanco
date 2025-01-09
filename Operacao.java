import java.time.*;

public class Operacao
{
  private String opNome;
  private double opValor;
  private String data;

  public Operacao(double valor, String nome){
    opNome = nome;
    opValor = valor;
    data = LocalDate.now().toString();
  }

  /* Métodos getter */

  public String getNomeOperacao(){
    return opNome;
  }

  public double getOpValor(){
    return opValor;
  }

  public String getData(){
    return data;
  }
}