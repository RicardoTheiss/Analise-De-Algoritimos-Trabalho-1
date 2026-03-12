package Fretes;

public class EncomendaPac implements Frete {
    private static final double PESO_MAXIMO_PRIMEIRA_FAIXA = 1000.0;
    private static final double PESO_MAXIMO_SEGUNDA_FAIXA = 2000.0;
    private static final double VALOR_PRIMEIRA_FAIXA = 10.0;
    private static final double VALOR_SEGUNDA_FAIXA = 15.0;

    private final double peso;

    public EncomendaPac(double peso) {
        validarPeso(peso);
        this.peso = peso;
    }

    @Override
    public double calculaValor() {
        if (isPesoNaPrimeiraFaixa()) {
            return VALOR_PRIMEIRA_FAIXA;
        }

        if (isPesoNaSegundaFaixa()) {
            return VALOR_SEGUNDA_FAIXA;
        }

        throw new IllegalArgumentException("Peso acima de 2kg não é aceito para este tipo de entrega");
    }

    private boolean isPesoNaPrimeiraFaixa() {
        return peso <= PESO_MAXIMO_PRIMEIRA_FAIXA;
    }

    private boolean isPesoNaSegundaFaixa() {
        return peso <= PESO_MAXIMO_SEGUNDA_FAIXA;
    }

    private void validarPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso deve ser maior que zero");
        }
    }
}