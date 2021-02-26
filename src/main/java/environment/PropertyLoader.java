package environment;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    private PropertyLoader() {}

    public static String retornarValorArquivoConfiguracao(final String propriedade) {
        Properties properties = new Properties();


        try (InputStream propFileInpStream = PropertyLoader.class.getClassLoader()
                .getResourceAsStream("env.properties")) {

            properties.load(propFileInpStream);

            return properties.getProperty(propriedade);
        } catch (IOException ignored) {}
        return propriedade;
    }
}
