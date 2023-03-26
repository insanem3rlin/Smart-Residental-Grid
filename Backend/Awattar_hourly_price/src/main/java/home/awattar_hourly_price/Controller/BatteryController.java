package home.awattar_hourly_price.Controller;

import home.awattar_hourly_price.Models.BatteryData;
import home.awattar_hourly_price.Repositories.BatteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BatteryController {
    @Autowired
    private BatteryRepository repository;

    @GetMapping("/battery")
    public @ResponseBody BatteryData battery() {
        return repository.findTopByOrderByIdDesc();
    }
}
