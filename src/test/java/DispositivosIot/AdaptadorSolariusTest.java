package DispositivosIot;

import DispositivosIot.Adaptadores.Persiana.AdaptadorSolarius;
import br.furb.analise.algoritmos.PersianaSolarius;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdaptadorSolariusTest {
    @Test
    public void deveAbrirEFecharPersiana() {
        PersianaSolarius real = new PersianaSolarius();
        AdaptadorSolarius Adaptador = new AdaptadorSolarius(real);

        Adaptador.abrir();
        assertTrue(real.estaAberta(), "A persiana Solarius deveria estar aberta");

        Adaptador.fechar();
        assertFalse(real.estaAberta(), "A persiana Solarius deveria estar fechada");
    }
}
