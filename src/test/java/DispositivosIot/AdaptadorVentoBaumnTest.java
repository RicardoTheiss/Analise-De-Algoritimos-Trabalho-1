package DispositivosIot;

import DispositivosIot.Adaptadores.ArCondicionado.AdaptadorVentoBaumn;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdaptadorVentoBaumnTest {
    @Test
    public void deveControlarTemperaturaVentoBaumn() {
        ArCondicionadoVentoBaumn real = new ArCondicionadoVentoBaumn();
        AdaptadorVentoBaumn Adaptador = new AdaptadorVentoBaumn(real);

        Adaptador.ligar();
        assertEquals(24, real.getTemperatura(), "Deveria iniciar em 24");

        Adaptador.aumentarTemperatura();
        assertEquals(25, real.getTemperatura());

        Adaptador.definirTemperatura(20);
        assertEquals(20, real.getTemperatura());
    }
}
