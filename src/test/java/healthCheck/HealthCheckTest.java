package healthCheck;

import client.ApiClient;
import org.testng.annotations.Test;

public class HealthCheckTest {

    ApiClient client;
    @Test
    public void healthCheck() {
        client.getHealthCheck();
    }

}
