package br.com.mutant.testing;

public class BusinessRules {

  public boolean verify(int a, int b){
    if (a < b){
      return true;
    }
    return false;
  }

  public int increment(int i){
    i++;
    return i;
  }

  public float negative(float i){
    return -i;
  }

  public int sum(int b, int c){
    int a = b + c;
    return a;
  }

  public boolean compateTo(int a, int b){
    if (a == b){
      return true;
    } else {
      return false;
    }
  }
}
