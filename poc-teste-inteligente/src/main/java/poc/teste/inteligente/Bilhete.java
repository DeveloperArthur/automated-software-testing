package poc.teste.inteligente;

import java.time.LocalDateTime;

public class Bilhete {
  private Double saldoComum;
  private Double saldoVT;
  private Boolean bloqueado;
  private LocalDateTime ultimaVezUtilizado;

  public Double getSaldoComum() {
    return saldoComum;
  }

  public void setSaldoComum(Double saldoComum) {
    this.saldoComum = saldoComum;
  }

  public Double getSaldoVT() {
    return saldoVT;
  }

  public void setSaldoVT(Double saldoVT) {
    this.saldoVT = saldoVT;
  }

  public Boolean estaBloqueado() {
    return bloqueado;
  }

  public void setBloqueado(Boolean bloqueado) {
    this.bloqueado = bloqueado;
  }

  public LocalDateTime getUltimaVezUtilizado() {
    return ultimaVezUtilizado;
  }

  public void setUltimaVezUtilizado(LocalDateTime ultimaVezUtilizado) {
    this.ultimaVezUtilizado = ultimaVezUtilizado;
  }
}
