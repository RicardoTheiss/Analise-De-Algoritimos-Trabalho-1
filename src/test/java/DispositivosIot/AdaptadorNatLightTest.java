package DispositivosIot;

import DispositivosIot.Adaptadores.Persiana.AdaptadorNatLight;
import br.furb.analise.algoritmos.PersianaNatLight;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AdaptadorNatLightTest {
    @Test
    public void deveAbrirSeguindoAsRegras() {
        PersianaNatLight real = new PersianaNatLight();
        AdaptadorNatLight adapter = new AdaptadorNatLight(real);

        assertDoesNotThrow(() -> adapter.abrir());
        assertTrue(real.estaPalhetaAberta());
        assertTrue(real.estaPalhetaErguida());
    }

    @Test
    public void deveFecharSeguindoAsRegras() throws Exception {
        PersianaNatLight real = new PersianaNatLight();
        AdaptadorNatLight adapter = new AdaptadorNatLight(real);

        adapter.abrir();
        adapter.fechar();

        assertFalse(real.estaPalhetaErguida());
        assertFalse(real.estaPalhetaAberta());
    }
}
