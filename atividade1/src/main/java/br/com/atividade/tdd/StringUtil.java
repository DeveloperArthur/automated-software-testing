package br.com.atividade.tdd;

public class StringUtil {

    public static boolean verificaSePalavraEhPalindromo(String expressao) {
        String expressaoTratada = tratarString(expressao);

        boolean ehPalindromo = false;
        if (expressaoTratada.length() == 3 && expressaoTratada.charAt(0) == expressaoTratada.charAt(2)) {
            return true;
        } else if (expressaoTratada.length() == 1) {
            return true;
        } else if (expressaoTratada.length() % 2 == 0) {
            for (int i = 0; i < expressaoTratada.length() / 2 - 1; i++) {
                if (expressaoTratada.charAt(i) != expressaoTratada.charAt(expressaoTratada.length() - i - 1)) {
                    return false;
                } else {
                    ehPalindromo = true;
                }
            }
        } else {
            for (int i = 0; i < (expressaoTratada.length() - 1) / 2 - 1; i++) {
                if (expressaoTratada.charAt(i) != expressaoTratada.charAt(expressaoTratada.length() - i - 1)) {
                    return false;
                } else {
                    ehPalindromo = true;
                }
            }
        }
        return ehPalindromo;
    }

    private static String tratarString(String expressao) {
        return expressao
                .toLowerCase()
                //retirando caracteres especiais
                .replaceAll("[^a-zA-Z0-9]", "");
    }
}
