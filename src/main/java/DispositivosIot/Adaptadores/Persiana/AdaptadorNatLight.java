package DispositivosIot.Adaptadores.Persiana;

import br.furb.analise.algoritmos.PersianaNatLight;

public class AdaptadorNatLight implements Persiana {
    private PersianaNatLight persiana;

    public AdaptadorNatLight(PersianaNatLight persiana) {
        this.persiana = persiana;
    }

    @Override
    public void abrir() throws Exception {
        persiana.abrirPalheta();
        persiana.subirPalheta();
    }

    @Override
    public void fechar() throws Exception {
        persiana.descerPalheta();
        persiana.fecharPalheta();
    }
}
