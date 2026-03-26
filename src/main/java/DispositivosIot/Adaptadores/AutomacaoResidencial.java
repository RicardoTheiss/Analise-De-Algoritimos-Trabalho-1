package DispositivosIot.Adaptadores;

import DispositivosIot.Adaptadores.ArCondicionado.ArCondicionado;
import DispositivosIot.Adaptadores.Lampada.Lampada;
import DispositivosIot.Adaptadores.Persiana.Persiana;

import java.util.ArrayList;
import java.util.List;

public class AutomacaoResidencial {
    private List<Lampada> lampadas = new ArrayList<>();
    private List<Persiana> persianas = new ArrayList<>();
    private List<ArCondicionado> ares = new ArrayList<>();

    public void adicionarDispositivo(Object dispositivo) {
        if (dispositivo instanceof Lampada) {
            lampadas.add((Lampada) dispositivo);
        } else if (dispositivo instanceof Persiana) {
            persianas.add((Persiana) dispositivo);
        } else if (dispositivo instanceof ArCondicionado) {
            ares.add((ArCondicionado) dispositivo);
        }
    }

    public void modoSono() throws Exception{
        lampadas.forEach(Lampada::desligar);
        ares.forEach(ArCondicionado::desligar);
        for (Persiana p : persianas) {
            try {
                p.fechar();
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }
    }

    public void modoTrabalho() throws Exception{
        lampadas.forEach(Lampada::ligar);
        for (Persiana p : persianas) {
            try {
                p.abrir();
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }
        ares.forEach(ar -> {
            ar.ligar();
            ar.definirTemperatura(25);
        });
    }
}
