package functional;

import client.ApiClient;
import factory.DataFactory;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static requestSpecification.ApiRequestSpecification.getRequestSpecification;

public class ResetTest {
    ApiClient client;
    DataFactory dataFactory;

    @Test
    public void getReset(){
        given().
                spec(getRequestSpecification()).
                header(dataFactory.headerName, dataFactory.headerToken).
        when().
                get("reset").
                then().
                statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getClientReset(){
        client.getReset();
    }
}
