package home.awattar_hourly_price.Controller;

import com.google.gson.Gson;
import home.awattar_hourly_price.Models.Average.AverageByDay;
import home.awattar_hourly_price.Models.Average.AverageByMonth;
import home.awattar_hourly_price.Models.Average.AverageByYear;
import home.awattar_hourly_price.Models.Datapoint;
import home.awattar_hourly_price.Models.MarketData;
import home.awattar_hourly_price.Repositories.Average.AverageByDayRepository;
import home.awattar_hourly_price.Repositories.Average.AverageByMonthRepository;
import home.awattar_hourly_price.Repositories.Average.AverageByYearRepository;
import home.awattar_hourly_price.Repositories.DatapointRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
public class DatapointController {

    Logger logger = Logger.getLogger(DatapointController.class.getName());

    @Autowired
    private DatapointRepository datapointRepository;
    @Autowired
    private AverageByYearRepository averageByYearRepository;
    @Autowired
    private AverageByMonthRepository averageByMonthRepository;
    @Autowired
    private AverageByDayRepository averageByDayRepository;


    @GetMapping("/bestSlotToBuy")
    public @ResponseBody Datapoint getBestHourToBuyInNext24Hours() {
        return datapointRepository.findTopByOrderByValueAsc();
    }

    @GetMapping("/bestSlotToSell")
    public @ResponseBody Datapoint getBestHourToSellInNext24Hours() {
        return datapointRepository.findTopByOrderByValueDesc();
    }

    @GetMapping("/latestDatapoints")
    public @ResponseBody Iterable<Datapoint> getLatestPoints() {
        return datapointRepository.findDatapointByEndDateAfter(new Timestamp(System.currentTimeMillis()));
    }
    @GetMapping("/getAllPoints")
    public @ResponseBody Iterable<Datapoint> getAllPoints() {
        return datapointRepository.findAll();
    }

    @GetMapping("/getByDay")
    public @ResponseBody Iterable<AverageByDay> getByDay() {
        return averageByDayRepository.findAll();
    }

    @GetMapping("/getByMonth")
    public @ResponseBody Iterable<AverageByMonth> getBayMonth() {
        return averageByMonthRepository.findAll();
    }

    @GetMapping("/getByYear")
    public @ResponseBody Iterable<AverageByYear> getByYear() {
        return averageByYearRepository.findAll();
    }
}
