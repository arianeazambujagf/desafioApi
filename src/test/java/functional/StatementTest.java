package functional;

import client.ApiClient;
import factory.DataFactory;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static factory.DataFactory.statementParam;
import static io.restassured.RestAssured.given;
import static requestSpecification.ApiRequestSpecification.getRequestSpecification;

public class StatementTest {
    ApiClient client;
    DataFactory dataFactory;

    @Test
    public void getStatement(){
        given().
                spec(getRequestSpecification()).
                header(dataFactory.headerName, dataFactory.headerToken).
        when().
                get("extrato/" + statementParam).
        then().
                assertThat().
                statusCode(HttpStatus.SC_OK);
    }

    //Faz a chamada pelo client
    @Test
    public void getClientStatement(){
        client.getStatement();
    }

}
