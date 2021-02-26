package client;

import factory.DataFactory;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static requestSpecification.ApiRequestSpecification.getRequestSpecification;

public class ApiClient {
    /*************************************************************
     * get: Busca as contas do Cliente
     *************************************************************/
    public ValidatableResponse getAccounts(){
        return
                given().
                        baseUri("http://barrigarest.wcaquino.me/").
                        header("Authorization", DataFactory.HeaderToken()).
                when().
                        get("contas").
                then().
                        statusCode(HttpStatus.SC_OK).
                        contentType(ContentType.JSON);
    }

    /*************************************************************
     * post: Cadastra uma conta passando um body
     *************************************************************/
    public ValidatableResponse postAccount(Object body){
        return
                given().
                        spec(getRequestSpecification()).
                        header("Authorization", DataFactory.HeaderToken()).
                        body(body).
                        when().
                        post("/contas").
                        then().
                        statusCode(HttpStatus.SC_OK).
                        contentType(ContentType.JSON);
    }

    /*************************************************************
     * get: Busca os saldos Cliente
     *************************************************************/
    public ValidatableResponse getBalance(){
        return
                given().
                        baseUri("http://barrigarest.wcaquino.me/").
                        header("Authorization", DataFactory.HeaderToken()).
                when().
                        get("saldo").
                then().
                        statusCode(HttpStatus.SC_OK).
                        contentType(ContentType.JSON);
    }

    /*************************************************************
     * getHealthCheck: verifica a saúde da api
     *************************************************************/
    public static ValidatableResponse getHealthCheck(){
        return
                given().
                        baseUri("http://barrigareact.wcaquino.me/").
                when().
                        get().
                 then().
                        statusCode(HttpStatus.SC_OK).
                        contentType(ContentType.HTML);
    }
}
