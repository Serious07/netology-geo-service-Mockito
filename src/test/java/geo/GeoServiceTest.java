package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceTest {
    @Test
    public void byIpRu(){
        GeoServiceImpl geoService = new GeoServiceImpl();

        Location loc = geoService.byIp("172.56.45.12");
        Assertions.assertEquals(Country.RUSSIA, loc.getCountry());
    }

    @Test
    public void byIpEng(){
        GeoServiceImpl geoService = new GeoServiceImpl();

        Location loc = geoService.byIp("96.456.34.57");
        Assertions.assertEquals(Country.USA, loc.getCountry());
    }
}
