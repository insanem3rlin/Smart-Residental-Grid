package home.awattar_hourly_price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;

@SpringBootApplication
@ServletComponentScan
public class AwattarHourlyPriceApplication {

    public static Properties properties;
    public static void main(String[] args) {
        properties = new Properties();
        properties.putIfAbsent("batteryMinimum", "0");
        properties.putIfAbsent("batteryMaximum", "100");
        SpringApplication.run(AwattarHourlyPriceApplication.class, args);
    }

}
