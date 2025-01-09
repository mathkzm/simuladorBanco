import java.util.Scanner;

public class ClienteB extends Cliente
{
  public ClienteB(String nome, String genero, String nomePai, String nomeMae, 
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
    if(renda <= 1100.00) {
      this.setLimiteCredito(0.3 * renda);
    } else if (renda > 1100.00 && renda <= 3300.00) {
      this.setLimiteCredito(0.4 * renda);
    }
  }
}