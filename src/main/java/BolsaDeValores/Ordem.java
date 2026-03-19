package BolsaDeValores;

public class Ordem {
    private Investidor investidor;
    private TipoOrdem tipo;
    private double valor;

    public Ordem(Investidor investidor, TipoOrdem tipo, double valor) {
        this.investidor = investidor;
        this.tipo = tipo;
        this.valor = valor;
    }

    public TipoOrdem getTipo() { return tipo; }
    public double getValor() { return valor; }
}
