package home.awattar_hourly_price.Repositories;

import home.awattar_hourly_price.Models.Battery;
import org.springframework.data.repository.CrudRepository;

public interface BatteryRepository extends CrudRepository<Battery, Long> {


    Battery findTopByOrderByIdDesc();
}
