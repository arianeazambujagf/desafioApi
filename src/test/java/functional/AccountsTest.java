package functional;

import client.ApiClient;
import factory.DataFactory;
import io.restassured.http.ContentType;
import model.AccountModel;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AccountsTest {

    protected ApiClient client;
    private static AccountModel response;

    @Test
    public void postAccounts(){
        /*response = client.postAccount(DataFactory.withDefaultAccountValues()).extract().as(AccountModel.class);

        client.getAccounts()
                .assertThat()
                .body("[0].id", equalTo(response.getId()))
                .body("[0].nome",equalTo(response.getNome()))
                .body("[0].visivel", equalTo(response.getVisivel()))
                .body("[0].usuario_id", equalTo(response.getUsuario_id()));*/
    }

    @Test
    public void getAccounts(){
        given().
                baseUri("http://barrigarest.wcaquino.me/").
                header("Authorization", DataFactory.HeaderToken()).
        when().
                get("contas").
        then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }


}
