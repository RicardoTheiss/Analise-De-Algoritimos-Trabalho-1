package DispositivosIot.Adaptadores.ArCondicionado;

public interface ArCondicionado {
    void ligar();
    void desligar();
    void aumentarTemperatura();
    void diminuirTemperatura();
    void definirTemperatura(int temperatura);
}
