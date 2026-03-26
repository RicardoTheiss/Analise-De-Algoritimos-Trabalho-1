package DispositivosIot;

import DispositivosIot.Adaptadores.ArCondicionado.AdaptadorGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdaptadorGellaKazaTest {
    @Test
    public void deveAlcancatTemperaturaAlvo() {
        ArCondicionadoGellaKaza real = new ArCondicionadoGellaKaza();
        AdaptadorGellaKaza adapter = new AdaptadorGellaKaza(real);

        adapter.ligar();
        adapter.definirTemperatura(22);

        assertEquals(22, real.getTemperatura());
    }
}
