package DispositivosIot;

import DispositivosIot.Adaptadores.Lampada.AdaptadorPhelippes;
import br.furb.analise.algoritmos.LampadaPhellipes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdaptadorPhellipesTest {
    @Test
    public void deveDefinirIntensidadeCorreta() {
        LampadaPhellipes real = new LampadaPhellipes();
        AdaptadorPhelippes adapter = new AdaptadorPhelippes(real);

        adapter.ligar();
        assertEquals(100, real.getIntensidade());

        adapter.desligar();
        assertEquals(0, real.getIntensidade());
    }
}
