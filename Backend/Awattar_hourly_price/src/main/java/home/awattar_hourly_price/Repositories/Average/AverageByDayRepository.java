package home.awattar_hourly_price.Repositories.Average;

import home.awattar_hourly_price.Models.Average.AverageByDay;
import org.springframework.data.repository.CrudRepository;

public interface AverageByDayRepository extends CrudRepository<AverageByDay, Long> {
}
