import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViaCepRestAssuredTest {
    private String JSONRetornado = "{\n" +
            "  \"cep\": \"01001-000\",\n" +
            "  \"logradouro\": \"Praça da Sé\",\n" +
            "  \"complemento\": \"lado ímpar\",\n" +
            "  \"bairro\": \"Sé\",\n" +
            "  \"localidade\": \"São Paulo\",\n" +
            "  \"uf\": \"SP\",\n" +
            "  \"ibge\": \"3550308\",\n" +
            "  \"gia\": \"1004\",\n" +
            "  \"ddd\": \"11\",\n" +
            "  \"siafi\": \"7107\"\n" +
            "}";

    @BeforeAll
    public static void setBaseURI() {
        RestAssured.baseURI = "https://viacep.com.br/ws";
    }

    @Test
    public void deveRetornarEnderecoComSucesso() {
        Response resp = RestAssured
                .given()
                .get("/01001000/json/");

        assertEquals(HttpStatus.SC_OK, resp.getStatusCode());
        assertEquals(JSONRetornado, resp.asString());
    }

    @Test
    public void deveRetornarQueEnderecoNaoExiste() {
        Response resp = RestAssured
                .given()
                .get("/01001000/");

        assertEquals(HttpStatus.SC_BAD_REQUEST, resp.getStatusCode());
    }
}
