package poc.teste.inteligente.tdd;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poc.teste.inteligente.Bilhete;
import poc.teste.inteligente.ValidadorDeBilhetes;

public class ValidadorDeBilhetesTest {

  @Test
  void deveRetornarFalse_quandoBilheteEstiverBloqueado(){
    Bilhete bilhete = new Bilhete();
    bilhete.setBloqueado(Boolean.TRUE);

    Boolean resultado = ValidadorDeBilhetes.valida(bilhete);

    Assertions.assertEquals(Boolean.FALSE, resultado);
  }

  @Test
  void deveRetornarTrueSemCobrarNada_poisBilheteEstaDentroDoPeriodoDaIntegracaoTarifaria(){
    Bilhete bilhete = new Bilhete();
    bilhete.setBloqueado(Boolean.FALSE);
    bilhete.setSaldoVT(20.0);
    bilhete.setSaldoComum(13.0);
    bilhete.setUltimaVezUtilizado(LocalDateTime.now().minusHours(1));

    Boolean resultado = ValidadorDeBilhetes.valida(bilhete);

    Assertions.assertEquals(Boolean.TRUE, resultado);
    Assertions.assertEquals(20.0, bilhete.getSaldoVT());
    Assertions.assertEquals(13.0, bilhete.getSaldoComum());
  }

  @Test
  void deveRetornarFalse_quandoBilheteNaoTiverSaldoSuficiente(){
    Bilhete bilhete = new Bilhete();
    bilhete.setBloqueado(Boolean.FALSE);
    bilhete.setSaldoVT(0.0);
    bilhete.setSaldoComum(0.0);
    bilhete.setUltimaVezUtilizado(LocalDateTime.now().plusHours(7));

    Boolean resultado = ValidadorDeBilhetes.valida(bilhete);

    Assertions.assertEquals(Boolean.FALSE, resultado);
    Assertions.assertEquals(0.0, bilhete.getSaldoVT());
    Assertions.assertEquals(0.0, bilhete.getSaldoComum());
  }

  @Test
  void deveRetornarTrue_quandoBilheteNaoTiverSaldoSuficienteNoVT_masTiverNoComum(){
    Bilhete bilhete = new Bilhete();
    bilhete.setBloqueado(Boolean.FALSE);
    bilhete.setSaldoVT(0.0);
    bilhete.setSaldoComum(12.0);
    bilhete.setUltimaVezUtilizado(LocalDateTime.now().plusHours(7));

    Boolean resultado = ValidadorDeBilhetes.valida(bilhete);

    Assertions.assertEquals(Boolean.TRUE, resultado);
    Assertions.assertEquals(0.0, bilhete.getSaldoVT());
    Assertions.assertEquals(8.0, bilhete.getSaldoComum());
  }

  @Test
  void deveRetornarTrue_quandoBilheteNaoTiverSaldoSuficienteNoComum_masTiverNoVT(){
    Bilhete bilhete = new Bilhete();
    bilhete.setBloqueado(Boolean.FALSE);
    bilhete.setSaldoVT(20.0);
    bilhete.setSaldoComum(0.0);
    bilhete.setUltimaVezUtilizado(LocalDateTime.now().plusHours(7));

    Boolean resultado = ValidadorDeBilhetes.valida(bilhete);

    Assertions.assertEquals(Boolean.TRUE, resultado);
    Assertions.assertEquals(16.0, bilhete.getSaldoVT());
    Assertions.assertEquals(0.0, bilhete.getSaldoComum());
  }

}
