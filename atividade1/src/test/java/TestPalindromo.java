import br.com.atividade.tdd.StringUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPalindromo {

    @Test
    public void deveRetornarVerdadeiro() {
        boolean rotator = StringUtil.verificaSePalavraEhPalindromo("Rotator");
        boolean bob = StringUtil.verificaSePalavraEhPalindromo("bob");
        boolean madam = StringUtil.verificaSePalavraEhPalindromo("madam");
        boolean mAlAyAlam = StringUtil.verificaSePalavraEhPalindromo("mAlAyAlam");
        boolean um = StringUtil.verificaSePalavraEhPalindromo("1");
        boolean Able = StringUtil.verificaSePalavraEhPalindromo("Able was I, ere I saw Elba");
        boolean Madam = StringUtil.verificaSePalavraEhPalindromo("Madam I’m Adam");
        boolean Step = StringUtil.verificaSePalavraEhPalindromo("Step on no pets.");
        boolean Top = StringUtil.verificaSePalavraEhPalindromo("Top spot!");
        boolean data = StringUtil.verificaSePalavraEhPalindromo("02/02/2020");

        assertEquals(true, rotator);
        assertEquals(true, bob);
        assertEquals(true, madam);
        assertEquals(true, mAlAyAlam);
        assertEquals(true, um);
        assertEquals(true, Able);
        assertEquals(true, Madam);
        assertEquals(true, Step);
        assertEquals(true, Top);
        assertEquals(true, data);
    }

    @Test
    public void deveRetornarFalso(){
        boolean xyz = StringUtil.verificaSePalavraEhPalindromo("xyz");
        boolean elephant = StringUtil.verificaSePalavraEhPalindromo("elephant");
        boolean Country = StringUtil.verificaSePalavraEhPalindromo("Country");
        boolean Top = StringUtil.verificaSePalavraEhPalindromo("Top . post!");
        boolean Wonderful = StringUtil.verificaSePalavraEhPalindromo("Wonderful-fool");
        boolean Wild = StringUtil.verificaSePalavraEhPalindromo("Wild imagination!");

        assertEquals(false, xyz);
        assertEquals(false, elephant);
        assertEquals(false, Country);
        assertEquals(false, Top);
        assertEquals(false, Wonderful);
        assertEquals(false, Wild);
    }
}
