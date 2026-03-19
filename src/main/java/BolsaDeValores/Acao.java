package BolsaDeValores;

import java.util.ArrayList;
import java.util.List;

public class Acao {
    private String nome;
    private double valorAtual;
    private List<Ordem> ordens = new ArrayList<>();
    private List<Observador> observadores = new ArrayList<>();

    public Acao(String nome, double valorInicial) {
        this.nome = nome;
        this.valorAtual = valorInicial;
    }

    private void setValorAtual(double novoValor) {
        if (this.valorAtual != novoValor) {
            this.valorAtual = novoValor;
            notificarObservadores();
        }
    }

    public void registrarOrdem(Ordem novaOrdem) {
        Ordem match = null;
        for (Ordem existente : ordens) {
            if (existente.getValor() == novaOrdem.getValor() &&
                    existente.getTipo() != novaOrdem.getTipo()) {
                match = existente;
                break;
            }
        }

        if (match != null) {
            ordens.remove(match);
            setValorAtual(novaOrdem.getValor());
            System.out.println("Match de ordens em " + nome + " no valor de R$" + valorAtual);
        } else {
            ordens.add(novaOrdem);
        }
    }

    public void registrarObservador(Observador o) {
        if (!observadores.contains(o)) observadores.add(o);
    }

    private void notificarObservadores() {
        for (Observador o : observadores) {
            o.atualizar(this.nome, this.valorAtual);
        }
    }

    public double getValorAtual() { return valorAtual; }
    public String getNome() { return nome; }
}