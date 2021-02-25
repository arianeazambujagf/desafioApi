package contract;

import org.testng.annotations.Test;
import java.io.File;
import factory.DataFactory;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ContractTest {
    
    @Test
    public void getBarrigaContractTest() {
        given().
                baseUri("http://barrigarest.wcaquino.me/").
                header("Authorization", DataFactory.HeaderToken()).
        when().
                get("saldo").
        then().
            body(matchesJsonSchema(new File("src/test/resources/jsonSchema/getCustomerBalanceJsonSchema.json")));
    }
}