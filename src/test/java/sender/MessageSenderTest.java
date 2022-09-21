package sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;

public class MessageSenderTest {
    @Test
    public void sendRu(){
        GeoService geoService = Mockito.mock(GeoService.class);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);

        Mockito.when(geoService.byIp(Mockito.anyString())).thenReturn(new Location("Moscow", Country.RUSSIA, "Kirova", 20));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Привет");
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Hi");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String answer = messageSender.send(new HashMap<String, String>());

        Assertions.assertEquals("Привет", answer);
    }

    @Test
    public void sendEng(){
        GeoService geoService = Mockito.mock(GeoService.class);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);

        Mockito.when(geoService.byIp(Mockito.anyString())).thenReturn(new Location("Washington", Country.USA, "NorthWest", 34));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Привет");
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Hi");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String answer = messageSender.send(new HashMap<String, String>());

        Assertions.assertEquals("Hi", answer);
    }

}
