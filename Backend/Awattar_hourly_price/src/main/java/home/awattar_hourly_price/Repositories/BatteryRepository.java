package home.awattar_hourly_price.Repositories;

import home.awattar_hourly_price.Models.BatteryData;
import home.awattar_hourly_price.Models.Datapoint;
import org.springframework.data.repository.CrudRepository;

public interface BatteryRepository extends CrudRepository<BatteryData, Long> {


    BatteryData findTopByOrderByIdDesc();
}
