package functional;

import client.ApiClient;
import factory.DataFactory;
import io.restassured.http.ContentType;
import model.AccountModel;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static requestSpecification.ApiRequestSpecification.getRequestSpecification;

public class AccountTest {

    protected ApiClient client;
    private static AccountModel response;

    @Test
    public void getAccounts(){
        given().
                spec(getRequestSpecification()).
                header(DataFactory.headerName, DataFactory.headerToken).
        when().
                get("contas").
        then().
                assertThat().
                    body("[0].id", notNullValue()).
                    body("[0].nome",notNullValue()).
                    body("[0].visivel", notNullValue()).
                    body("[0].usuario_id", notNullValue());
    }

    @Test
    public void postAccounts(){
        response = DataFactory.withRandomAccountValues();
        given().
                spec(getRequestSpecification()).
                header(DataFactory.headerName, DataFactory.headerToken).
                contentType("application/json").
                body(response).relaxedHTTPSValidation().
        when().
                post("contas").
        then().
                assertThat().
                    body("nome",equalTo(response.getNome())).
                    body("visivel", equalTo(response.getVisivel())).
                statusCode(HttpStatus.SC_CREATED).
                contentType(ContentType.JSON);
    }

    @Test(dependsOnMethods = {"postAccounts"})
    public void deleteAccount(){
        int id = response.getId();
        given().
                spec(getRequestSpecification()).
                header(DataFactory.headerName, DataFactory.headerToken).
                contentType("application/json").
                pathParam("id", id).
        when().
                delete("contas/{id}").
        then().
                statusCode(HttpStatus.SC_NO_CONTENT);
    }
}

