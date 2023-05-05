package home.awattar_hourly_price;

import com.google.gson.Gson;
import home.awattar_hourly_price.Controller.ReadJsonController;
import home.awattar_hourly_price.Models.Datapoint;
import home.awattar_hourly_price.Models.MarketData;
import home.awattar_hourly_price.Repositories.DatapointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@ServletComponentScan
public class AwattarHourlyPriceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwattarHourlyPriceApplication.class, args);
    }
}
