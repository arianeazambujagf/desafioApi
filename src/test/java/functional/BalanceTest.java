package functional;

import client.ApiClient;
import factory.DataFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

public class BalanceTest {

    ApiClient client;

    @Test
    public void getBalance(){
        given().
                baseUri("http://barrigarest.wcaquino.me/").
                header("Authorization", DataFactory.HeaderToken()).
        when().
                get("saldo").
        then().
                body("[0].conta_id", notNullValue()).
                body("[0].conta", notNullValue()).
                body("[0].saldo", notNullValue());
    }

    @Test
    public void getClientBalance(){
        /*client.getBalance();*/
    }



}
