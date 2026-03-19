package BolsaDeValores;

public class Investidor implements Observador {
    private String nome;

    public Investidor(String nome) { this.nome = nome; }

    @Override
    public void atualizar(String nomeAcao, double novoPreco) {
        System.out.println("[Notificação para " + nome + "]: A ação " +
                nomeAcao + " mudou para R$" + novoPreco);
    }

    public void colocarOrdem(Acao acao, TipoOrdem tipo, double valor) {
        acao.registrarOrdem(new Ordem(this.nome, tipo, valor));
    }
}
