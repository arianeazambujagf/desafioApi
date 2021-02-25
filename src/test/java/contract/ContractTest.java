package contract;

import org.testng.annotations.Test;
import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ContractTest {

    @Test
    public void getBarrigaContractTest() {
        given().
                baseUri("http://barrigarest.wcaquino.me/").
                header("Authorization", "JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MTM0ODJ9.gx7pnWtTgsOVPl8LRE9kYu5L158QnvRmXYs25eFZZMo").
        when().
                get("saldo").
        then().
            body(matchesJsonSchema(new File("src/test/resources/jsonSchema/getCustomerBalanceJsonSchema.json")));
    }
}