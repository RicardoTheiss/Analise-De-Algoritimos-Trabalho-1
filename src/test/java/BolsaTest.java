import BolsaDeValores.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BolsaTest {

    @Test
    void testeMatchDeOrdensEAtualizacaoDePreco() {
        Acao bolsa = new Acao("bolsa", 20.0);
        Investidor ricardo = new Investidor("Ricardo");
        Investidor jc = new Investidor("Jc");

        bolsa.registrarObservador(ricardo);

        jc.colocarOrdem(bolsa, TipoOrdem.COMPRA, 24.00);
        assertEquals(20.0, bolsa.getValorAtual(), "Preço não deve mudar sem match");

        ricardo.colocarOrdem(bolsa, TipoOrdem.VENDA, 24.00);

        assertEquals(24.0, bolsa.getValorAtual(), "O preço da ação deve ser atualizado após o match");
    }

    @Test
    void deveNotificarInvestidorQuandoPrecoMudarPorMatch() {
        Acao bolsa2 = new Acao("bolsa2", 30.0);

        final boolean[] notificacaoRecebida = {false};
        Observador investidorTeste = new Observador() {
            @Override
            public void atualizar(String nomeAcao, double novoPreco) {
                notificacaoRecebida[0] = true;
            }
        };

        bolsa2.registrarObservador(investidorTeste);

        bolsa2.registrarOrdem(new Ordem("Vendedor", TipoOrdem.VENDA, 35.0));
        assertFalse(notificacaoRecebida[0], "Não deve notificar antes do match");

        bolsa2.registrarOrdem(new Ordem("Comprador", TipoOrdem.COMPRA, 35.0));

        assertTrue(notificacaoRecebida[0], "O investidor deveria ter sido notificado da mudança de preço");
        assertEquals(35.0, bolsa2.getValorAtual());
    }
}