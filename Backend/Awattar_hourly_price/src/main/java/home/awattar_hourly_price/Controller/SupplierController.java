package home.awattar_hourly_price.Controller;

import com.google.gson.JsonObject;
import home.awattar_hourly_price.Models.Supplier;
import home.awattar_hourly_price.Repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SupplierController {
    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping("/supplier")
    public @ResponseBody ResponseEntity<String> getLatestConsumer() {
        JsonObject response = new JsonObject();
        Supplier sp = supplierRepository.findTopByOrderByIdDesc();
        response.addProperty("id", sp.getId());
        response.addProperty("time", String.valueOf(sp.time));
        response.addProperty("watt", sp.watt);
        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }

}
