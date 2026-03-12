import Fretes.*;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    static final int ENCOMENDA_PAC = 1;
    static final int SEDEX = 2;
    static final int RETIRADA_NO_LOCAL = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double peso = pegaPeso(scanner);
        final int tipoFrete = pegaTipoFrete(scanner);

        Frete frete;

        try{
            switch (tipoFrete){
                case ENCOMENDA_PAC:
                    frete = new EncomendaPac(peso);
                    break;
                case SEDEX:
                    frete = new Sedex(peso);
                    break;
                case RETIRADA_NO_LOCAL:
                    System.out.println("Frete sem custos!");
                    return;
                default:
                    System.out.println("Erro! Tipo inválido.");
                    return;
            }

            final double valor = frete.calculaValor();
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println("Valor do frete: " + df.format(valor));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static double pegaPeso(final Scanner scanner) {
        System.out.println("Digite o peso (gramas):");
        return scanner.nextDouble();
    }

    private static int pegaTipoFrete(final Scanner scanner) {
        System.out.println("Digite o tipo de entrega\n1-  Encomenda PAC\n2 - Sedex\n3 - Retirada no local");
        return scanner.nextInt();
    }
}
