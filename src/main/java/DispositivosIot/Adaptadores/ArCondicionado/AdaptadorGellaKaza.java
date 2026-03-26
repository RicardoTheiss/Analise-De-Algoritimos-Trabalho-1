package DispositivosIot.Adaptadores.ArCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;

public class AdaptadorGellaKaza implements ArCondicionado {
    private ArCondicionadoGellaKaza arCondicionado;

    public AdaptadorGellaKaza(ArCondicionadoGellaKaza arCondicionadoGellaKaza) {
        this.arCondicionado = arCondicionadoGellaKaza;
    }

    @Override
    public void ligar() {
        this.arCondicionado.ativar();
    }

    @Override
    public void desligar() {
        this.arCondicionado.desativar();
    }

    @Override
    public void aumentarTemperatura() {
        this.arCondicionado.aumentarTemperatura();
    }

    @Override
    public void diminuirTemperatura() {
        this.arCondicionado.diminuirTemperatura();
    }

    @Override
    public void definirTemperatura(int temperatura) {
        while (this.arCondicionado.getTemperatura() < temperatura) {
            this.aumentarTemperatura();
        }

        while (this.arCondicionado.getTemperatura() > temperatura) {
            this.diminuirTemperatura();
        }
    }
}
