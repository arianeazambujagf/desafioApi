package requestSpecification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static environment.PropertyLoader.retornarValorArquivoConfiguracao;

public class ApiRequestSpecification {

    private static final String BASEURI = retornarValorArquivoConfiguracao("baseUri");

    private ApiRequestSpecification(){}

    public static RequestSpecification getRequestSpecification(){
        return new RequestSpecBuilder()
                .setConfig(
                        new RestAssuredConfig()
                        .sslConfig(
                                new SSLConfig().relaxedHTTPSValidation()
                        )
                )
                .setContentType(ContentType.TEXT)
                .setBaseUri(BASEURI)
                .addFilter(new RequestLoggingFilter())
                .build();
    }
}
