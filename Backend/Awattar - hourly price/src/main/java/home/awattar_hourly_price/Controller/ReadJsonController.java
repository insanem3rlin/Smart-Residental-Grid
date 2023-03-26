package home.awattar_hourly_price.Controller;

import com.google.gson.Gson;
import home.awattar_hourly_price.Models.Datapoint;
import home.awattar_hourly_price.Models.MarketData;
import home.awattar_hourly_price.Repositories.DatapointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Controller
public class ReadJsonController {

    @Autowired
    private DatapointRepository repository;

    @GetMapping("/loadDatapoints")
    public @ResponseBody Iterable<Datapoint> loadDatapoints() throws IOException {
        repository.deleteAll();
        Gson gson = new Gson();
        String apiUrl = "https://api.awattar.at/v1/marketdata";
        URL url = new URL(apiUrl);
        InputStreamReader reader = new InputStreamReader(url.openStream());
        MarketData marketData = gson.fromJson(reader, MarketData.class);
        repository.saveAll(marketData.getData());
        /*
        //repository.deleteAll();
        JSONParser parser = new JSONParser();
        List<Datapoint> datapointList = new ArrayList<>();
        List<Datapoint> existing = new ArrayList<>();
        try {
            String uri = "https://api.awattar.at/v1/marketdata";
            RestTemplate request = new RestTemplate();
            String result = request.getForObject(uri, String.class);
            //Object obj = parser.parse(new FileReader(Paths.get("").toAbsolutePath().toString() + "\\data4.json"));
            //JSONObject jsonObject = (JSONObject) obj;
            JSONObject jsonObject = (JSONObject) parser.parse(result);
            JSONArray datapoints = (JSONArray) jsonObject.get("data");
            for (int i = 0; i < datapoints.size(); i++) {
                JSONObject oneObject = (JSONObject) datapoints.get(i);
                Datapoint d = new Datapoint();
                d.startDate = new Timestamp(Long.parseLong(oneObject.get("start_timestamp").toString()));
                d.endDate = new Timestamp(Long.parseLong(oneObject.get("end_timestamp").toString()));
                d.value = Double.parseDouble(oneObject.get("marketprice").toString());
                d.value = d.value / 10;
                d.unity = "cent/kWH";
                existing = repository.findDatapointByStartDate(d.startDate);
                if (existing == null) {
                    datapointList.add(d);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(datapointList.isEmpty());
        datapointList.forEach(dp -> System.out.println(dp.toString()));
        repository.saveAll(datapointList);
        //return repository.findAll();
        return null;
        */
        return null;
    }


    @GetMapping("/getAllPoints")
    public @ResponseBody Iterable<Datapoint> getAllPoints() {
        return repository.findAll();
    }

    @GetMapping("/getByDay")
    public @ResponseBody Iterable<Datapoint> getByDay() {
        return repository.findAll();
    }
/*
    @GetMapping("/getByMonth")
    public @ResponseBody Iterable<Datapoint> getBayMonth() {
        return repository.findDatapointsByStartDateYear();
    }*/

    @GetMapping("/getByYear")
    public @ResponseBody Iterable<Datapoint> getByYear() {
        return repository.findAll();
    }
}
