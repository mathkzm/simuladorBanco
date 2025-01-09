import java.util.Random;

public class Cartao
{
  private String titular, numCartao; 
  private int mesVencimento = 11, anoVencimento = 2026;
  private double limiteTotal;
  private boolean valido;

  public Cartao(String titular, double valor) 
  {
    this.titular = titular;
    this.valido = true;
    this.limiteTotal = valor;
    numCartao = defineNumCartao();
  }

  /* Métodos getter */
  public String getTitular() {
    return titular;
  }

  public String getNumCartao() {
    return numCartao;
  }

  public int getMesVencimento() {
    return mesVencimento;
  }

  public int getAnoVencimento() {
    return anoVencimento;
  }

  public double getLimiteTotal() {
    return limiteTotal;
  }

  public boolean getValido() {
    return valido;
  }

  public void setValido(boolean valido) {
    this.valido = valido;
  }

  public void setLimiteTotal(double limiteTotal) {
    this.limiteTotal = limiteTotal;
  }

  public void toggleCartao() {
    if (this.valido == true) {
      this.setValido(false);
    } else {
      this.setValido(true);
    }
  }

  // Fiz o método que verifica se o cartão expirou e, caso esteja vencido, informa que um novo será solicitado.
  public boolean verificaCartaoVencido(int mesAtual, int anoAtual) {
    int soma = 12 * (this.getAnoVencimento() - anoAtual) + this.getMesVencimento() - mesAtual;
    if (soma < 0)
      return true;
    else
      return false;
  }
  
  // Alterar o método validarCartão para se adequar às estruturas de dados usadas.
  public String defineNumCartao() {
    int soma, digito;
    String numCartao = "";
    Random rand = new Random();
    boolean toggle = false;
    soma = 0;
    for (int i = 0; i < 15; i++) {
      digito = rand.nextInt(10);
      numCartao += digito;
      if (toggle) {
        digito *= 2;
        if (digito > 9)
          digito -= 9;
        toggle = false;
      } else
        toggle =  true;
      soma += digito;
    }
    digito = 10 - soma % 10;
    return numCartao += digito;
  }

  public boolean validaCartao() {
    String aux = this.getNumCartao();
    boolean toggle = false;
    int soma, digito;
    soma = 0;
    for (int i = 0; i < 15; i++) {
      digito = aux.charAt(i) - '0';
      if (toggle) {
        digito *= 2;
        if (digito > 9)
          digito -= 9;
        toggle = false;
      } else
        toggle = true;
      soma += digito;
    }
    digito = 10 - soma % 10;
    if (digito == 10)
      digito = 0;
    if ((int)(aux.charAt(15) - '0') == digito)
      return true;
    else
      return false;
  }

  public String formataVencimento() {
    return (this.mesVencimento + "/" + this.anoVencimento);
  }
}