package i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {
    @Test
    public void localeRu(){
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

        String answer = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals("Добро пожаловать", answer);
    }

    @Test
    public void localeUS(){
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

        String answer = localizationService.locale(Country.USA);
        Assertions.assertEquals("Welcome", answer);
    }
}
