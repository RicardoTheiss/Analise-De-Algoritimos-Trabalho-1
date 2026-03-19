package Fretes;

public class Sedex implements Frete {
    private static final double PESO_MAXIMO_PRIMEIRA_FAIXA = 500.0;
    private static final double PESO_MAXIMO_SEGUNDA_FAIXA = 1000.0;
    private static final double VALOR_PRIMEIRA_FAIXA = 12.5;
    private static final double VALOR_SEGUNDA_FAIXA = 15.0;
    private static final double VALOR_BASE_ACIMA_1000g = 46.5;
    private static final double VALOR_ADICIONAL_POR_100g = 1.5;
    private static final double PESO_POR_UNIDADE_ADICIONAL = 100.0;
    private final double peso;

    public Sedex(double peso) {
        validarPeso(peso);
        this.peso = peso;
    }

    @Override
    public double calculaValor() {
        if (isPesoAteMinimo()) {
            return VALOR_PRIMEIRA_FAIXA;
        }

        if (isPesoAteMaximo()) {
            return VALOR_SEGUNDA_FAIXA;
        }

        return calcularValorAcimaDoMaximo();
    }

    private boolean isPesoAteMinimo() {
        return peso <= PESO_MAXIMO_PRIMEIRA_FAIXA;
    }

    private boolean isPesoAteMaximo() {
        return peso <= PESO_MAXIMO_SEGUNDA_FAIXA;
    }

    private double calcularValorAcimaDoMaximo() {
        double unidadesAdicionais = (peso - PESO_MAXIMO_SEGUNDA_FAIXA) / PESO_POR_UNIDADE_ADICIONAL;
        double adicionalTotal = unidadesAdicionais * VALOR_ADICIONAL_POR_100g;

        return VALOR_BASE_ACIMA_1000g + adicionalTotal;
    }

    private void validarPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso deve ser maior que zero");
        }
    }
}