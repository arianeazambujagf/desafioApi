package contract;

import client.ApiClient;
import org.testng.annotations.Test;

public class ContractTest {

    ApiClient client;

    @Test
    public void getClientContractTest() {
        client.getContrato();
    }
}