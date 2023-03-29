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
