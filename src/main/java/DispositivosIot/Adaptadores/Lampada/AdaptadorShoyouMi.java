package DispositivosIot.Adaptadores.Lampada;

import br.furb.analise.algoritmos.LampadaShoyuMi;

public class AdaptadorShoyouMi implements Lampada {
    private LampadaShoyuMi lampada;

    public AdaptadorShoyouMi(LampadaShoyuMi lampada) {
        this.lampada = lampada;
    }

    @Override
    public void ligar() {
        this.lampada.ligar();
    }

    @Override
    public void desligar() {
        this.lampada.desligar();
    }
}
