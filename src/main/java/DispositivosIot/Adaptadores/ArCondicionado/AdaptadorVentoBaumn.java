package DispositivosIot.Adaptadores.ArCondicionado;

import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;

public class AdaptadorVentoBaumn implements ArCondicionado {
    private ArCondicionadoVentoBaumn arCondicionado;

    public AdaptadorVentoBaumn(ArCondicionadoVentoBaumn arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public void ligar() {
        this.arCondicionado.ligar();
    }

    @Override
    public void desligar() {
        this.arCondicionado.desligar();
    }

    @Override
    public void aumentarTemperatura() {
        int atual = this.arCondicionado.getTemperatura();
        this.arCondicionado.definirTemperatura(atual + 1);
    }

    @Override
    public void diminuirTemperatura() {
        int atual = this.arCondicionado.getTemperatura();
        this.arCondicionado.definirTemperatura(atual - 1);
    }

    @Override
    public void definirTemperatura(int temperatura) {
        this.arCondicionado.definirTemperatura(temperatura);
    }
}
