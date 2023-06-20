package home.awattar_hourly_price.Controller;

import com.google.gson.JsonObject;
import home.awattar_hourly_price.Models.Consumer;
import home.awattar_hourly_price.Models.Supplier;
import home.awattar_hourly_price.Repositories.ConsumerRepository;
import home.awattar_hourly_price.Repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConsumerController {
    @Autowired
    private ConsumerRepository consumerRepository;

    @GetMapping("/consumer")
    public @ResponseBody ResponseEntity<String> getLatestSupplier() {
        JsonObject response = new JsonObject();
        Consumer c = consumerRepository.findTopByOrderByIdDesc();
        response.addProperty("id", c.getId());
        response.addProperty("time", String.valueOf(c.time));
        response.addProperty("watt", c.watt);
        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }
}
