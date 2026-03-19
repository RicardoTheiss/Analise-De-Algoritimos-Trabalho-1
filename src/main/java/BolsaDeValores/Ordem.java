package BolsaDeValores;

public class Ordem {
    private String nomeInvestidor;
    private TipoOrdem tipo;
    private double valor;

    public Ordem(String nomeInvestidor, TipoOrdem tipo, double valor) {
        this.nomeInvestidor = nomeInvestidor;
        this.tipo = tipo;
        this.valor = valor;
    }

    public TipoOrdem getTipo() { return tipo; }
    public double getValor() { return valor; }
    public String getNomeInvestidor() { return nomeInvestidor; }
}
