package healthCheck;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HealthCheckTest {

    @Test
    public void healthCheck() {
        given().
            baseUri("http://barrigareact.wcaquino.me/").
        when().
            get().
        then().
            statusCode(HttpStatus.SC_OK).
            contentType(ContentType.HTML);
    }
}
