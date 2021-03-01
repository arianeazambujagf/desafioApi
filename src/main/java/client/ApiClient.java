package client;

import factory.DataFactory;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import java.io.File;

import static factory.DataFactory.statementParam;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static requestSpecification.ApiRequestSpecification.getRequestSpecification;

public class ApiClient {

    DataFactory dataFactory;
    /*************************************************************
     * get: Busca a conta passada por parametro
     *************************************************************/
    public ValidatableResponse getAccount(int id){
        return
                given().
                        spec(getRequestSpecification()).
                        header(dataFactory.headerName, dataFactory.headerToken).
                        contentType("application/x-www-form-urlencoded;charset=UTF-8").
                        accept("application/json, text/plain, */*").
                        pathParam("id", id).
                when().
                        get("contas/{id}").
                then().
                        statusCode(HttpStatus.SC_OK).
                        contentType(ContentType.JSON);
    }

    /*************************************************************
     * get: Busca todas as contas
     *************************************************************/
    public ValidatableResponse getAccounts(){
        return
                given().
                        spec(getRequestSpecification()).
                        header(dataFactory.headerName, dataFactory.headerToken).
                        contentType("application/x-www-form-urlencoded;charset=UTF-8").
                        accept("application/json, text/plain, */*").
                when().
                        get("contas").
                then().
                        statusCode(HttpStatus.SC_OK).
                        contentType(ContentType.JSON);
    }

    /*************************************************************
     * get: Busca todas as contas
     *************************************************************/
    public ValidatableResponse getStatement(){
        return
                given().
                        spec(getRequestSpecification()).
                        header(dataFactory.headerName, dataFactory.headerToken).

                when().
                        get("extrato/"+statementParam).
                then().
                        statusCode(HttpStatus.SC_OK);
                        //contentType(ContentType.JSON);
    }

    /*************************************************************
     * post: Cadastra uma conta passando um body
     *************************************************************/
    public ValidatableResponse postAccount(Object body){
        return
                given().
                        spec(getRequestSpecification()).
                        header(DataFactory.headerName, DataFactory.headerToken).
                        contentType("application/json").
                        body(body).relaxedHTTPSValidation().
                when().
                        post("contas").
                then().
                        statusCode(HttpStatus.SC_CREATED).
                        contentType(ContentType.JSON);
    }

    /*************************************************************
     * delete: Deleta uma conta passando um body
     *************************************************************/
    public ValidatableResponse deleteAccounts(int id) {
        return
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

    /*************************************************************
     * post: Efetua um depósito na conta passando um body
     *************************************************************/
    public ValidatableResponse postBalance(Object body){
        return
                given().
                        spec(getRequestSpecification()).
                        header(DataFactory.headerName, DataFactory.headerToken).
                        contentType("application/x-www-form-urlencoded;charset=UTF-8").
                        accept("application/json, text/plain, */*").
                        body(body).
                when().
                        post("/saldo").
                then().
                        statusCode(HttpStatus.SC_CREATED).
                        contentType(ContentType.JSON);
    }

    /*************************************************************
     * get: Busca os saldos Cliente
     *************************************************************/
    public ValidatableResponse getBalance(){
        return
                given().
                        spec(getRequestSpecification()).
                        header(dataFactory.headerName, dataFactory.headerToken).
                        contentType("application/x-www-form-urlencoded;charset=UTF-8").
                        accept("application/json, text/plain, */*").
                when().
                        get("saldo").
                then().
                        statusCode(HttpStatus.SC_OK).
                        contentType(ContentType.JSON);
    }

    /*************************************************************
     * get: Reseta as informações
     *************************************************************/
    public ValidatableResponse getReset(){
        return
                given().
                        spec(getRequestSpecification()).
                        header(dataFactory.headerName, dataFactory.headerToken).
                when().
                        get("reset").
                then().
                        statusCode(HttpStatus.SC_OK);
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

    /*************************************************************
     * getContract: verifica que a integridade do contrato não foi comprometida
     *************************************************************/
    public static ValidatableResponse getContrato(){
        return
                given().
                        //baseUri("http://barrigarest.wcaquino.me/").
                        spec(getRequestSpecification()).
                        header(DataFactory.headerName, DataFactory.headerToken).
                when().
                        get("saldo").
                then().
                        body(matchesJsonSchema(new File("src/test/resources/jsonSchema/getCustomerBalanceJsonSchema.json")));
    }
}
