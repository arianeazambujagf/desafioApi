package contract;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ContractTest {

    @Test
    public void getBarrigaContractTest() {
        //TODO
        //COLOCAR OS VALORES DO HEADER NUM BASETEST OU EM UMA PATA DE MASSA DE DADOS
        String headerValue = "JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MTM0ODJ9.gx7pnWtTgsOVPl8LRE9kYu5L158QnvRmXYs25eFZZMo";

        given().
                baseUri("http://barrigarest.wcaquino.me/").
                header("Authorization", headerValue).
        when().
                get("saldo").
        then().
            body(matchesJsonSchema(new File("scr/test/resources/jsonSchema/getCustomerBalanceJsonSchema.json")));

    }
}