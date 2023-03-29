package br.com.mutant.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BusinessRulesTest {
  BusinessRules businessRules = new BusinessRules();

  @Test
  void verify_shouldReturnTrue(){
    boolean result = businessRules.verify(5, 10);
    Assertions.assertTrue(result);
  }

  @Test
  void verify_shouldReturnFalse(){
    boolean result = businessRules.verify(9, 6);
    Assertions.assertFalse(result);
  }

  /*
  * Eu não escrevi esse teste de primeira, mas no report
  * do Pit mostrou um mutante sobrevivente nesse cenário
  * de condictional boundary, na classe BusinessRules
  * linha 6 tem a condição < e o mutante mudou para <=
  *
  * quando o mutante introduz um bug no código, e os
  * testes passam, tem algo errado, e foi o que aconteceu
  * pois eu não tinha nenhum teste que me certificasse
  * que 2 numeros iguais resultaria em false, como ele
  * mudou a condição, e eu não tinha teste garantindo isso,
  * o mutante sobreviveu
  *
  * para resolver eu criei esse teste, agora sim estou validando
  * que dado 2 números iguais, o resultado tem que ser false
  *
  * o mutante muda a condição para <= e com isso meu teste falha
  * assim, o mutante morre, pois quando o mutante introduz um
  * bug no código, o teste tem que falhar!
  *
  * https://stackoverflow.com/a/57025484/12253990
  */
  @Test
  void verify_withCondictionalBoundary(){
    boolean result = businessRules.verify(4, 4);
    Assertions.assertFalse(result);
  }

  @Test
  void increment_shouldReturnVariableIncremented(){
    int i = businessRules.increment(4);
    Assertions.assertEquals(5, i);
  }

  @Test
  void negative(){
    float number = businessRules.negative(20f);
    Assertions.assertEquals(-20.0f, number);
  }

  @Test
  void sum(){
    int i = businessRules.sum(3, 7);
    Assertions.assertEquals(10, i);
  }

  @Test
  void compateTo_shouldReturnTrue(){
    boolean result = businessRules.compateTo(10, 10);
    Assertions.assertTrue(result);
  }

  @Test
  void compateTo_shouldReturnFalse(){
    boolean result = businessRules.compateTo(9, 11);
    Assertions.assertFalse(result);
  }

}
