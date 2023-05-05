package home.awattar_hourly_price.Controller;

import com.google.gson.JsonObject;
import home.awattar_hourly_price.Models.BatteryData;
import home.awattar_hourly_price.Repositories.BatteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.Properties;

import static home.awattar_hourly_price.Logic.StatusInformations.*;


@Controller
public class BatteryController {
    @Autowired
    private BatteryRepository repository;

    Properties properties = new Properties();

    @GetMapping("/battery")
    public @ResponseBody BatteryData battery() {
        return repository.findTopByOrderByIdDesc();
    }

    @PostMapping("/setBatteryProperties")
    public @ResponseBody ResponseEntity<String> setBatteryProperties(@RequestParam String minimum, @RequestParam String maximum) {
        try {
            int min = Integer.parseInt(minimum);
            int max = Integer.parseInt(maximum);

            if (min > max || min < 0 || max > 100 || max < 1) {
                return new ResponseEntity<>("Data is logically flawed!", HttpStatus.BAD_REQUEST);
            }

            setBatteryMinimum(min);
            setBatteryMaximum(max);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NumberFormatException ex) {
            return new ResponseEntity<>("Wrong data format", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getBatteryProperties")
    public @ResponseBody ResponseEntity<String> getBatteryProperties() {

        JsonObject response = new JsonObject();
        response.addProperty("batteryMinimum", getBatteryMinimum());
        response.addProperty("batteryMaximum", getBatteryMaximum());

        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }

    @GetMapping("/getBatteryCharge")
    public @ResponseBody ResponseEntity<String> getCurrentCharge() {

        JsonObject response = new JsonObject();
        DecimalFormat df = new DecimalFormat("#.##");
        response.addProperty("batteryCharge", df.format(getBatteryCharge()));

        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }
}
