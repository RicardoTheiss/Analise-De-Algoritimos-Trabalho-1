package DispositivosIot;

import DispositivosIot.Adaptadores.AutomacaoResidencial;
import DispositivosIot.Adaptadores.Lampada.AdaptadorShoyouMi;
import DispositivosIot.Adaptadores.Persiana.AdaptadorNatLight;
import br.furb.analise.algoritmos.LampadaShoyuMi;
import br.furb.analise.algoritmos.PersianaNatLight;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AutomacaoResidencialTest {
    @Test
    public void deveAdicionarEExecutarModos() {
        AutomacaoResidencial central = new AutomacaoResidencial();

        AdaptadorShoyouMi lampada = new AdaptadorShoyouMi(new LampadaShoyuMi());
        AdaptadorNatLight persiana = new AdaptadorNatLight(new PersianaNatLight());

        central.adicionarDispositivo(lampada);
        central.adicionarDispositivo(persiana);

        assertDoesNotThrow(() -> central.modoTrabalho());
        assertDoesNotThrow(() -> central.modoSono());
    }
}
