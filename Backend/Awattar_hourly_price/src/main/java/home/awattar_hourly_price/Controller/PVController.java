package home.awattar_hourly_price.Controller;

import home.awattar_hourly_price.Models.PV;
import home.awattar_hourly_price.Repositories.PVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PVController {
    @Autowired
    private PVRepository repository;

    @GetMapping("/PV")
    public @ResponseBody Iterable<PV> getPV() {
        return repository.findAll();
    }
}
