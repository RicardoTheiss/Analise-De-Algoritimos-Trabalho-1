package DispositivosIot.Adaptadores.Lampada;

import br.furb.analise.algoritmos.LampadaPhellipes;

public class AdaptadorPhelippes implements Lampada {
    private LampadaPhellipes lampada;

    public AdaptadorPhelippes(LampadaPhellipes lampada) {
        this.lampada = lampada;
    }

    @Override
    public void ligar() {
        lampada.setIntensidade(100);
    }

    @Override
    public void desligar() {
        lampada.setIntensidade(0);
    }
}
