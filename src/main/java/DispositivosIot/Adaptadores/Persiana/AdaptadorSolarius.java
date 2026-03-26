package DispositivosIot.Adaptadores.Persiana;

import br.furb.analise.algoritmos.PersianaSolarius;

public class AdaptadorSolarius implements Persiana {
    private PersianaSolarius persiana;

    public AdaptadorSolarius(PersianaSolarius persiana) {
        this.persiana = persiana;
    }

    @Override
    public void abrir() {
        this.persiana.subirPersiana();
    }

    @Override
    public void fechar() {
        this.persiana.descerPersiana();
    }
}
