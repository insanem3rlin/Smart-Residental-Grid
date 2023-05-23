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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
public class ReadJsonController {

    Logger logger = Logger.getLogger(ReadJsonController.class.getName());

    @Autowired
    private DatapointRepository datapointRepository;
    @Autowired
    private AverageByYearRepository averageByYearRepository;
    @Autowired
    private AverageByMonthRepository averageByMonthRepository;
    @Autowired
    private AverageByDayRepository averageByDayRepository;

    @PostConstruct
    public @ResponseBody Iterable<Datapoint> loadDatapoints() throws IOException {
        Gson gson = new Gson();
        String apiUrl;
        Datapoint lastRecord = datapointRepository.findTopByOrderByIdDesc();
        long end = System.currentTimeMillis();
        long start;
        if (lastRecord == null) {
            start = end - Long.parseLong("2592000000");
        } else {
            start = lastRecord.getEndDate().getTime();
        }
        end = end + 36 * 60 * 60 * 1000;
        apiUrl = "https://api.awattar.at/v1/marketdata?start=" + start + "&end=" + end;

        URL url = new URL(apiUrl);
        InputStreamReader reader = new InputStreamReader(url.openStream());
        MarketData marketData = gson.fromJson(reader, MarketData.class);
        List<Datapoint> points = new ArrayList<>();
        try {
            for (Datapoint d : marketData.getData()
            ) {
                d.setValue(d.getValue() / 10);
                d.setUnity("cent/kWH");
                points.add(d);
            }
            datapointRepository.saveAll(points);
        } catch (Exception ex) {
            logger.log(Level.WARNING, ex.toString());
        } finally {
            return marketData.getData();
        }
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
