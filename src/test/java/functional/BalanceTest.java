package functional;

import client.ApiClient;
import factory.DataFactory;
import model.BalanceModel;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static requestSpecification.ApiRequestSpecification.getRequestSpecification;

public class BalanceTest {

    ApiClient client;
    DataFactory dataFactory;

    @Test
    public void getBalance(){
        given().
                spec(getRequestSpecification()).
                header(dataFactory.headerName, dataFactory.headerToken).
        when().
                get("saldo").
        then().
                body("[0].conta_id", notNullValue()).
                body("[0].conta", notNullValue()).
                body("[0].saldo", notNullValue());
    }


    @Test
    public void postBalance(){
        BalanceModel balanceBody = dataFactory.withRandomBalanceValues();

        client.postBalance(balanceBody).extract().as(BalanceModel.class);
        client.getBalance().
                assertThat().
                    body("[0].conta_id", equalTo(balanceBody.getConta_id())).
                    body("[0].conta", equalTo(balanceBody.getConta())).
                    body("[0].saldo", equalTo(balanceBody.getSaldo()));


    }
}
