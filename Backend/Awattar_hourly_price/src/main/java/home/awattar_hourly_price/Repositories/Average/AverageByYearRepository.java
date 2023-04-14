package home.awattar_hourly_price.Repositories.Average;

import home.awattar_hourly_price.Models.Average.AverageByYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AverageByYearRepository extends JpaRepository<AverageByYear, Long> {
}
