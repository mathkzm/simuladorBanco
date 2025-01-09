import java.util.Scanner;

public abstract class Cliente
{
  private String nome, genero, nomePai, nomeMae, rgOrg, endereco, telefone, cpf;
  private int nascimento[], rgNum;
  private double rendaMensal, limiteCredito;
  private Cartao cartao;
  private Fatura fatura;

  public Cliente (String nome, String genero, String nomePai, String nomeMae, 
                  String rgOrg, String endereco, String nascimento, String cpf,
                  int rgNum, String telefone, double rendaMensal, Scanner input)
  {
    String[] aux = new String[3];
    this.nascimento = new int[3];
    this.nome = nome;
    this.genero = genero;
    this.nomePai = nomePai;
    this.nomeMae = nomeMae;
    this.endereco = endereco;
    aux = nascimento.split("/");
    while (true) {
      try {    
        for (int i = 0; i < 3; i++)
          this.nascimento[i] = Integer.valueOf(aux[i]);
        break;
      } catch (NumberFormatException e) {
        System.out.println("Digite uma data de nascimento válida.");
        aux = input.nextLine().split("/");
      }
    } 
    this.rgNum = rgNum;
    this.rgOrg = rgOrg;
    this.cpf = cpf;
    this.telefone = telefone;
    this.rendaMensal = rendaMensal;
    this.cartao = new Cartao(nome, rendaMensal * 0.5);
    this.fatura = new Fatura(nome, this.cartao.getNumCartao().substring(12, 16));
  }
  
  public String getNome() {
    return nome;
  }

  public String getGenero() {
    return genero;
  }

  public String getNomePai() {
    return nomePai;
  }

  public String getNomeMae() {
    return nomeMae;
  }

  public String getRgOrg() {
    return rgOrg;
  }

  public String getEndereco() {
    return endereco;
  }

  public int[] getNascimento() {
    return nascimento;
  }

  public String getCpf() {
    return cpf;
  }

  public int getRgNum() {
    return rgNum;
  }

  public String getTelfone() {
    return telefone;
  }

  public double getRendaMensal() {
    return rendaMensal;
  }

  public double getLimiteCredito() {
    return limiteCredito;
  }

  public Cartao getCartao() {
    return this.cartao;
  }

  public Fatura getFatura() {
    return this.fatura;
  }

  public void setLimiteCredito(double limiteCredito) {
    this.limiteCredito = limiteCredito;
  }

  //outros métodos
  abstract public void defineLimiteCredito();
}