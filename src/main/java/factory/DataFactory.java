package factory;

import com.github.javafaker.Faker;
import model.AccountModel;
import model.BalanceModel;

import java.util.Locale;

public class DataFactory {

    private static final Faker faker = new Faker(new Locale("pt-BR"));

    private DataFactory() {}

    public static Object HeaderToken(){
        Object headerToken = "JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MTM0ODJ9.gx7pnWtTgsOVPl8LRE9kYu5L158QnvRmXYs25eFZZMo";
       return headerToken;
    }

    public static BalanceModel withDefaultBalanceValues() {
        return getBalance();
    }

    private static BalanceModel getBalance() {
        return BalanceModel.builder()
                .saldo(faker.number().digits(3))
                .conta_id((faker.hashCode()))
                .conta(faker.number().digits(7))
                .build();
    }

    public static AccountModel withDefaultAccountValues() {
        return postAccount();
    }

    private static AccountModel postAccount() {
        return AccountModel.builder()
                .id(90877)
                .nome("Nome da Pessoa")
                .visivel(true)
                .usuario_id(12323)
                .build();
    }



}
