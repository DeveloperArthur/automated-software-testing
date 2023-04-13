import static org.junit.jupiter.api.Assertions.assertEquals;

import com.globo.jv.checkout.domain.service.StringUtil;
import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class TestPalindromoComTestesParametrizados {

  @ParameterizedTest
  @MethodSource("criaTestCases")
  public void deveVerificarSePalavraEhPalindromo(TestCase testCase) {
    boolean result = StringUtil.verificaSePalavraEhPalindromo(testCase.palindromo);
    System.out.println("input value: " + testCase.palindromo + "= result: " + result);
    assertEquals(testCase.expectedResult, result);
  }

  private static Collection<TestCase> criaTestCases() {
    return Arrays.asList(
        new TestCase("Rotator", true),
        new TestCase("bob", true),
        new TestCase("madam", true),
        new TestCase("mAlAyAlam", true),
        new TestCase("1", true),
        new TestCase("Able was I, ere I saw Elba", true),
        new TestCase("Madam I’m Adam", true),
        new TestCase("Step on no pets.", true),
        new TestCase("Top spot!", true),
        new TestCase("02/02/2020", true),
        new TestCase("xyz", false),
        new TestCase("elephant", false),
        new TestCase("Country", false),
        new TestCase("Top . post!", false),
        new TestCase("Wonderful-fool", false),
        new TestCase("Wild imagination!", false));
  }

  private static class TestCase {
    String palindromo;
    boolean expectedResult;

    public TestCase(String palindromo, boolean expectedResult) {
      this.palindromo = palindromo;
      this.expectedResult = expectedResult;
    }
  }
}
