import java.time.*;

public class Compra
{
    private String compra, dataCompra;
    private double valorCompra;

    public Compra(){}

    public Compra(String compra, double valorCompra)
    {
        this.compra = compra;
        this.valorCompra = valorCompra;
        this.dataCompra = LocalDate.now().toString();
    }

    public String getDataCompra(){
        return dataCompra;
    }

    public String getCompra(){
        return compra;
    }

    public double getValorCompra(){
        return valorCompra;
    }
}
