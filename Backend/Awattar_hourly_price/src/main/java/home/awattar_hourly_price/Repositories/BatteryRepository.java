package home.awattar_hourly_price.Repositories;

import home.awattar_hourly_price.Models.Battery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteryRepository extends CrudRepository<Battery, Long> {


    Battery findTopByOrderByIdDesc();
}
