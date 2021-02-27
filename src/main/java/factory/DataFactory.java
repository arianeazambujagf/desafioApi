package factory;

import com.github.javafaker.Faker;
import model.AccountModel;
import model.BalanceModel;

import java.util.Locale;

public class DataFactory {

    private static final Faker faker = new Faker(new Locale("pt-BR"));

    private DataFactory() {}

    public static Object headerToken = "JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MTM1MjJ9.BlYIFdq3QYduuRP99iWNVlURXozTSADmD-pfU6aYzHQ";

    public static String headerName = "Authorization";

    public static BalanceModel withRandomBalanceValues() {
        return getBalance();
    }

    private static BalanceModel getBalance() {
        return BalanceModel.builder()
                .saldo(faker.number().digits(3))
                .conta_id(123231)
                .conta(faker.number().digits(7))
                .build();
    }

    public static AccountModel withRandomAccountValues() {
        return postAccount();
    }

    private static AccountModel postAccount() {
        return AccountModel.builder()
                //id() gerados automaticamente
                .nome(faker.name().lastName().toUpperCase())
                .visivel(true)
                //usuario_id()
                .build();
    }



}
