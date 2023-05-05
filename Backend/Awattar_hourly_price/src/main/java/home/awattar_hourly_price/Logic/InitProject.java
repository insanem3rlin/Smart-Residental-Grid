package home.awattar_hourly_price.Logic;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class InitProject {

    Properties properties;
    @PostConstruct
    private void init() {
        StatusInformations.setProperties();
    }
}
