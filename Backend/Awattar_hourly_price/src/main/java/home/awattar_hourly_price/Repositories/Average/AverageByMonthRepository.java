package home.awattar_hourly_price.Repositories.Average;

import home.awattar_hourly_price.Models.Average.AverageByMonth;
import org.springframework.data.repository.CrudRepository;

public interface AverageByMonthRepository extends CrudRepository<AverageByMonth, Long> {
}
