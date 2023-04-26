package poc.teste.inteligente;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ValidadorDeBilhetes {
  private static final Double VALOR_PASSAGEM = 4.0;
  private static final Integer PERIODO_HORAS_INTEGRACAO = 2;

  public static Boolean valida(Bilhete bilhete) {
    //nao deve dar passagem se o cartao estiver bloqueado
    if (bilhete.estaBloqueado()){
      return Boolean.FALSE;
    }

    //se a ultima vez estiver dentro do periodo de integracao, deve dar passagem sem cobrar
    long diferencaEmHoras = ChronoUnit.HOURS.between(LocalDateTime.now(),
        bilhete.getUltimaVezUtilizado());
    if (diferencaEmHoras <= PERIODO_HORAS_INTEGRACAO){
      return Boolean.TRUE;
    }

    //checar se tem saldo disponivel no VT
    //se nao tiver dinheiro suficiente no VT, tentar no comum
    double saldoVTAposDeducao = bilhete.getSaldoVT() - VALOR_PASSAGEM;
    double salvoComumAposDeducao = bilhete.getSaldoComum() - VALOR_PASSAGEM;
    if (saldoVTAposDeducao >= 0.0) {
      bilhete.setSaldoVT(saldoVTAposDeducao);
      return Boolean.TRUE;
    } else if (salvoComumAposDeducao >= 0.0) {
      bilhete.setSaldoComum(salvoComumAposDeducao);
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }
}
