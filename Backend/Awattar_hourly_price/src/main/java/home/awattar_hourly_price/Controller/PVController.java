package home.awattar_hourly_price.Controller;

import com.google.gson.JsonObject;
import home.awattar_hourly_price.Models.PV;
import home.awattar_hourly_price.Repositories.PVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;

@Controller
public class PVController {
    @Autowired
    private PVRepository repository;

    @GetMapping("/PV")
    public @ResponseBody Iterable<PV> getPV() {
        return repository.findAll();
    }

    @GetMapping("/getPVOutput")
    public @ResponseBody ResponseEntity<String> getPVOutput() {
        JsonObject response = new JsonObject();

        Iterator<PV> iter = getPV().iterator();
        PV pv = null;

        while(iter.hasNext()) {
            pv = iter.next();
        }

        if(pv != null) {
            response.addProperty("PVOutput", pv.getWatt());
        }
        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
    }
}
