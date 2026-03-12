import Fretes.EncomendaPac;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EncomendaPacTest {

    @Test
    void deveCalcularValorParaPesoAte1000g() {
        // Arrange
        double peso = 500.0;
        double valorEsperado = 10.0;
        EncomendaPac encomendaPac = new EncomendaPac(peso);

        // Act
        double valorCalculado = encomendaPac.calculaValor();

        // Assert
        assertEquals(valorEsperado, valorCalculado, 0.001);
    }

    @Test
    void deveCalcularValorParaPesoIgualA1000g() {
        // Arrange
        double peso = 1000.0;
        double valorEsperado = 10.0;
        EncomendaPac encomendaPac = new EncomendaPac(peso);

        // Act
        double valorCalculado = encomendaPac.calculaValor();

        // Assert
        assertEquals(valorEsperado, valorCalculado, 0.001);
    }

    @Test
    void deveCalcularValorParaPesoEntre1000gE2000g() {
        // Arrange
        double peso = 1500.0;
        double valorEsperado = 15.0;
        EncomendaPac encomendaPac = new EncomendaPac(peso);

        // Act
        double valorCalculado = encomendaPac.calculaValor();

        // Assert
        assertEquals(valorEsperado, valorCalculado, 0.001);
    }

    @Test
    void deveCalcularValorParaPesoIgualA2000g() {
        // Arrange
        double peso = 2000.0;
        double valorEsperado = 15.0;
        EncomendaPac encomendaPac = new EncomendaPac(peso);

        // Act
        double valorCalculado = encomendaPac.calculaValor();

        // Assert
        assertEquals(valorEsperado, valorCalculado, 0.001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.1, 1.0, 250.0, 750.0, 999.9})
    void deveCalcularValorParaPesosPositivosAte1000g(double peso) {
        // Arrange
        EncomendaPac encomendaPac = new EncomendaPac(peso);

        // Act
        double valorCalculado = encomendaPac.calculaValor();

        // Assert
        assertEquals(10.0, valorCalculado, 0.001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1000.1, 1250.0, 1750.0, 1999.9})
    void deveCalcularValorParaPesosEntre1000gE2000g(double peso) {
        // Arrange
        EncomendaPac encomendaPac = new EncomendaPac(peso);

        // Act
        double valorCalculado = encomendaPac.calculaValor();

        // Assert
        assertEquals(15.0, valorCalculado, 0.001);
    }

    @Test
    void deveLancarExcecaoParaPesoAcimaDe2000g() {
        // Arrange
        double pesoAcimaDoLimite = 2000.1;
        EncomendaPac encomendaPac = new EncomendaPac(pesoAcimaDoLimite);

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> encomendaPac.calculaValor());

        assertTrue(exception.getMessage().contains("acima de 2kg"));
    }

    @Test
    void deveLancarExcecaoParaPesoInvalido() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new EncomendaPac(0));
        assertThrows(IllegalArgumentException.class, () -> new EncomendaPac(-100));
    }

    @ParameterizedTest
    @CsvSource({
            "2000.1, Peso acima de 2kg não é aceito",
            "3000.0, Peso acima de 2kg não é aceito"
    })
    void deveLancarExcecaoComMensagemCorretaParaPesosAcimaDoLimite(double peso, String mensagemEsperada) {
        // Arrange
        EncomendaPac encomendaPac = new EncomendaPac(peso);

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> encomendaPac.calculaValor());

        assertTrue(exception.getMessage().contains(mensagemEsperada));
    }
}