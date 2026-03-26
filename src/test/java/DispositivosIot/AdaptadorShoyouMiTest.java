package DispositivosIot;

import DispositivosIot.Adaptadores.Lampada.AdaptadorShoyouMi;
import br.furb.analise.algoritmos.LampadaShoyuMi;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdaptadorShoyouMiTest {
    @Test
    public void deveLigarEDesligarCorretamente() {
        LampadaShoyuMi real = new LampadaShoyuMi();
        AdaptadorShoyouMi adaptador = new AdaptadorShoyouMi(real);

        adaptador.ligar();
        assertTrue(real.estaLigada(), "A lâmpada deveria estar ligada");

        adaptador.desligar();
        assertFalse(real.estaLigada(), "A lâmpada deveria estar desligada");
    }
}
