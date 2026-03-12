import Fretes.Sedex;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SedexTest {

    @Test
    void deveCalcularValorParaPesoAte500g() {
        // Arrange
        double peso = 300.0;
        double valorEsperado = 12.5;
        Sedex sedex = new Sedex(peso);

        // Act
        double valorCalculado = sedex.calculaValor();

        // Assert
        assertEquals(valorEsperado, valorCalculado, 0.001);
    }

    @Test
    void deveCalcularValorParaPesoIgualA500g() {
        // Arrange
        double peso = 500.0;
        double valorEsperado = 12.5;
        Sedex sedex = new Sedex(peso);

        // Act
        double valorCalculado = sedex.calculaValor();

        // Assert
        assertEquals(valorEsperado, valorCalculado, 0.001);
    }

    @Test
    void deveCalcularValorParaPesoEntre500gE1000g() {
        // Arrange
        double peso = 750.0;
        double valorEsperado = 15.0;
        Sedex sedex = new Sedex(peso);

        // Act
        double valorCalculado = sedex.calculaValor();

        // Assert
        assertEquals(valorEsperado, valorCalculado, 0.001);
    }

    @Test
    void deveCalcularValorParaPesoIgualA1000g() {
        // Arrange
        double peso = 1000.0;
        double valorEsperado = 15.0;
        Sedex sedex = new Sedex(peso);

        // Act
        double valorCalculado = sedex.calculaValor();

        // Assert
        assertEquals(valorEsperado, valorCalculado, 0.001);
    }

    @ParameterizedTest
    @CsvSource({
            "1100, 48.0",
            "1200, 49.5",
            "1300, 51.0",
            "1500, 54.0"
    })
    void deveCalcularValorParaPesoAcimaDe1000g(double peso, double valorEsperado) {
        // Arrange
        Sedex sedex = new Sedex(peso);

        // Act
        double valorCalculado = sedex.calculaValor();

        // Assert
        assertEquals(valorEsperado, valorCalculado, 0.001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.1, 1.0, 250.0, 499.9})
    void deveCalcularValorParaPesosPositivosAbaixoDe500g(double peso) {
        // Arrange
        Sedex sedex = new Sedex(peso);

        // Act
        double valorCalculado = sedex.calculaValor();

        // Assert
        assertEquals(12.5, valorCalculado, 0.001);
    }

    @Test
    void deveLancarExcecaoParaPesoInvalido() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Sedex(0));
        assertThrows(IllegalArgumentException.class, () -> new Sedex(-100));
    }

    @Test
    void deveCalcularAdicionalCorretamente() {
        // Arrange
        double peso = 1250.0; // 250g acima do limite
        // 250/100 = 2.5 unidades adicionais * 1.5 = 3.75 + 46.5 = 50.25
        double valorEsperado = 50.25;
        Sedex sedex = new Sedex(peso);

        // Act
        double valorCalculado = sedex.calculaValor();

        // Assert
        assertEquals(valorEsperado, valorCalculado, 0.001);
    }
}