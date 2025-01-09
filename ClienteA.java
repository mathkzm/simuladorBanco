import java.util.Scanner;

public class ClienteA extends Cliente 
{
  public ClienteA(String nome, String genero, String nomePai, String nomeMae, 
                  String rgOrg, String endereco, String nascimento, String cpf,
                  int rgNum, String telefone, double rendaMensal, Scanner input)
  {
    super(nome, genero, nomePai, nomeMae,
          rgOrg, endereco, nascimento, cpf,
          rgNum, telefone, rendaMensal, input);
    this.defineLimiteCredito();
  }

  public void defineLimiteCredito() { 
    double renda = this.getRendaMensal();  
    if (renda > 3300.00 && renda <= 5500.00) {
      this.setLimiteCredito(0.45 * renda);
    } else if (renda > 5500.00) {
      this.setLimiteCredito(0.5 * renda);
    }
  }
}