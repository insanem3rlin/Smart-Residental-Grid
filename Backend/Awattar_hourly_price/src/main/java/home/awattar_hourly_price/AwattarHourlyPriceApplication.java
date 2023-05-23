package home.awattar_hourly_price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan
public class AwattarHourlyPriceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwattarHourlyPriceApplication.class, args);
    }
}
